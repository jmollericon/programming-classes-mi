package ejercicio3;

import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class OperacionesCajero {

	private JFrame frame;
	
	
	// ---- para conexion a la base de datos ------
	Conexion con = new Conexion();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement stmt;
	// ----- variables para los datos de la tabla de la bd ----------
	int nro_cuenta[] 	= new int[100];
	int nro_ci[]		= new int[100];
	String nombre[] 	= new String[100];
	String fecha[] 		= new String[100];
	double saldo[] 		= new double[100];
	String pin_cuenta[]	= new String[100];
	
	// ----- variables para los datos de la tabla transacciones de la bd ----------
	int nro_cuenta_tra[] 	= new int[100];
	String fecha_tra[] 		= new String[100];
	String tipo_tra[] 		= new String[100];
	double monto_tra[] 		= new double[100];
	
	int nro_cuentas = 0;		// contador de clientes (cuentas)
	int nro_transacciones = 0;	// contador de transacciones
		
	int cuenta_seleccionada = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperacionesCajero window = new OperacionesCajero(0);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OperacionesCajero(int id_user) {
		cuenta_seleccionada = id_user;
		System.out.println(cuenta_seleccionada);
		initialize();
		// ---- conexion a la base de datos y obtencion de datos ------
		try {
			cn = con.getConexionMYSQL();
			stm = (Statement) cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM clientes"); // consulta sql (consulta a la base de datos)
			
			while(rs.next()){
				nro_cuenta[nro_cuentas] = rs.getInt(1); // columna a extraer
				nro_ci[nro_cuentas]	 	= rs.getInt(2);
				nombre[nro_cuentas] 	= rs.getString(3); // columna a extraer
				fecha[nro_cuentas] 		= rs.getString(4); // columna a extraer
				saldo[nro_cuentas] 		= rs.getDouble(5); // columna a extraer
				pin_cuenta[nro_cuentas] = rs.getString(6); // columna a extraer
				nro_cuentas++;
			}
			//System.out.println(nro_cuentas);
			rs = stm.executeQuery("SELECT * FROM transacciones"); // consulta sql (consulta a la base de datos)
			
			while(rs.next()){
				nro_cuenta_tra[nro_transacciones] = rs.getInt(1);    // columna a extraer
				fecha_tra[nro_transacciones] 		= rs.getString(2); // columna a extraer
				tipo_tra[nro_transacciones] 		= rs.getString(3); // columna a extraer
				monto_tra[nro_transacciones] 		= rs.getDouble(4); // columna a extraer
				nro_transacciones++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(cn != null) cn.close();
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(730, 350, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCajeroAutomtico = new JLabel("Operaciones Cajero Autom\u00E1tico");
		lblCajeroAutomtico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCajeroAutomtico.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCajeroAutomtico.setBounds(0, 11, 434, 35);
		frame.getContentPane().add(lblCajeroAutomtico);
		
		JButton btnNewButton = new JButton("RETIRO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int aux=0;
				System.out.println(cuenta_seleccionada);
				double retiro = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a Retirar: "));
				if(retiro > 1500){
					JOptionPane.showMessageDialog(null, "No se permite retiros mayores a 1500Bs.");
				}else{
					for(int i=0; i< nro_cuentas; i++){
						if(cuenta_seleccionada == nro_cuenta[i]){
							aux=i;
							break;
						}
					}
					if(retiro >= saldo[aux]){
						JOptionPane.showMessageDialog(null, "No cuenta con saldo suficiente.");
					}else{
						saldo[aux] = saldo[aux]-retiro;
						actualizarSaldoBBDD(aux);
						registrarTransaccion(1, retiro); // 1: retiro
						JOptionPane.showMessageDialog(null, "Retiro Realizado Satisfactoriamente.!.");
					}
				}
			}
		});
		btnNewButton.setBounds(100, 51, 225, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Cerrando sesion!");
				Inicio i = new Inicio();
				i.mostrarVentana();
				frame.setVisible(false);
			}
		});
		btnSalir.setBounds(26, 189, 102, 48);
		frame.getContentPane().add(btnSalir);
		
		JButton btnDeposito = new JButton("DEPOSITO");
		btnDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int aux=0;
				//System.out.println(cuenta_seleccionada);
				double deposito = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto a Depositar: "));
				for(int i=0; i< nro_cuentas; i++){
					if(cuenta_seleccionada == nro_cuenta[i]){
						aux=i;
						break;
					}
				}
				saldo[aux] = saldo[aux]+deposito;
				actualizarSaldoBBDD(aux);
				registrarTransaccion(2, deposito); // 1: deposito
				JOptionPane.showMessageDialog(null, "Deposito Realizado Satisfactoriamente.!.");
			}
		});
		btnDeposito.setBounds(100, 97, 225, 35);
		frame.getContentPane().add(btnDeposito);
		
		JButton btnConsultaDeSaldo = new JButton("CONSULTA DE SALDO");
		btnConsultaDeSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int i=0; i< nro_cuentas; i++){
					if(cuenta_seleccionada == nro_cuenta[i]){
						JOptionPane.showMessageDialog(null, "Su saldo actual es: " + ((double)Math.round(saldo[i] * 100d)/100d) + " Bs.");
						break;
					}
				}
				
			}
		});
		btnConsultaDeSaldo.setBounds(100, 143, 225, 35);
		frame.getContentPane().add(btnConsultaDeSaldo);
		
		JButton btnTransacciones = new JButton("VER TRANSACCIONES");
		btnTransacciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msj = "TRANSACCIONES   -   Nro de Cuenta: "+cuenta_seleccionada+"\n";
				String fila = "";
				int c = 1;
				for (int i = 0; i < nro_transacciones; i++) {
					if(nro_cuenta_tra[i] == cuenta_seleccionada){
						fila = 	(c)+".- "+fecha_tra[i]+"   -   "+tipo_tra[i]+"   -   "+monto_tra[i]+" Bs.\n";
						msj = msj + fila;
						c++;
					}
				}
				JOptionPane.showMessageDialog(null, msj);
			}
		});
		btnTransacciones.setBounds(234, 189, 158, 48);
		frame.getContentPane().add(btnTransacciones);
	}
	void mostrarVentana(){
		frame.setVisible(true);
	}
	void actualizarSaldoBBDD(int m){
		try {
			cn = con.getConexionMYSQL();
			//stm = (Statement) cn.createStatement();
			stmt = (PreparedStatement) cn.prepareStatement("UPDATE clientes SET saldo_actual="+saldo[m]+" WHERE nro_cuenta = "+cuenta_seleccionada);
			int retorno = stmt.executeUpdate();
			//rs = stm.executeQuery("+""); // consulta sql (consulta a la base de datos)
			//rs = stm.executeQuery("UPDATE clientes SET saldo_actual=25 WHERE nro_cuenta = 1"); // consulta sql (consulta a la base de datos)
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(cn != null) cn.close();
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	void registrarTransaccion(int y, double monto){
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    String strDate = sdf.format(cal.getTime());
	    //System.out.println(strDate);
		
		String tipo = "";
		if (y == 1) tipo = " RETIRO ";
		if (y == 2) tipo = "DEPOSITO";
		
		nro_cuenta_tra[nro_transacciones]   = cuenta_seleccionada;
		fecha_tra[nro_transacciones] 		= strDate;
		tipo_tra[nro_transacciones] 		= tipo;
		monto_tra[nro_transacciones] 		= monto;
		nro_transacciones++;
		
		try {
			cn = con.getConexionMYSQL();
			stmt = (PreparedStatement) cn.prepareStatement("INSERT INTO transacciones " + "VALUES ("+cuenta_seleccionada+", '"+strDate+"', '"+tipo+"', "+monto+")");
	        //stmt.executeUpdate("INSERT INTO transacciones " + "VALUES ("+cuenta_seleccionada+", '"+"06/12/2019"+"', '"+tipo+"', "+monto+")");
			int retorno = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(cn != null) cn.close();
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
