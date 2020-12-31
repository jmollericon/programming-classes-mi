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
import com.mysql.jdbc.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Inicio {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	
	// ---- para conexion a la base de datos ------
	Conexion con = new Conexion();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	// ----- variables para los datos de la tabla clientes de la bd ----------
	int nro_cuenta[] 	= new int[100];
	int nro_ci[]		= new int[100];
	String nombre[] 	= new String[100];
	String fecha[] 		= new String[100];
	double saldo[] 		= new double[100];
	String pin_cuenta[]	= new String[100];

	int nro_cuentas = 0;	// contador de cuentas

	int nro_intentos = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
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
	public Inicio() {
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
		
		JLabel lblCajeroAutomtico = new JLabel("Cajero Autom\u00E1tico");
		lblCajeroAutomtico.setHorizontalAlignment(SwingConstants.CENTER);
		lblCajeroAutomtico.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCajeroAutomtico.setBounds(0, 11, 434, 35);
		frame.getContentPane().add(lblCajeroAutomtico);
		
		JButton btnNewButton = new JButton("INGRESAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(nro_intentos>0){
					String aux = textField.getText();
					if(aux.equals("")) aux="0";
					int nroC = Integer.parseInt(aux);
					String pin  = passwordField.getText();
					boolean sw = true; 
					for(int i=0; i< nro_cuentas; i++){
						if(nroC == nro_cuenta[i]){
							if(pin.equals(pin_cuenta[i])){
								// JOptionPane.showMessageDialog(null, "correcto");
								sw = false;
								OperacionesCajero oc = new OperacionesCajero(nro_cuenta[i]);
								oc.mostrarVentana();
								frame.setVisible(false);
							}
						}
					}
					if(sw){
						nro_intentos--;
						JOptionPane.showMessageDialog(null, "Error en los datos.\nLe quedan "+nro_intentos+" intentos");
					}				
				}else{
					JOptionPane.showMessageDialog(null, "Bloqueado por número de intentos excedido.");
				}
			}
		});
		btnNewButton.setBounds(175, 157, 151, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Gracias por su Visita.!");
				frame.setVisible(false);
			}
		});
		btnSalir.setBounds(26, 189, 102, 48);
		frame.getContentPane().add(btnSalir);
		
		textField = new JTextField();
		textField.setBounds(175, 57, 151, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 101, 151, 29);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNroCuenta = new JLabel("Nro. Cuenta");
		lblNroCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblNroCuenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNroCuenta.setBounds(10, 52, 177, 35);
		frame.getContentPane().add(lblNroCuenta);
		
		JLabel lblPin = new JLabel("Pin");
		lblPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPin.setBounds(0, 96, 177, 35);
		frame.getContentPane().add(lblPin);
	}
	void mostrarVentana(){
		frame.setVisible(true);
	}
}
