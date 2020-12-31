import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class FormularioVenta {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JSpinner spinner;
	private JCheckBox chckbxDescuento;
	private JRadioButton rdbtnRecibo;
	private JRadioButton rdbtnFactura;
		
	// ---- para conexion a la base de datos ------
	Conexion con = new Conexion();
	Connection cn = null;
	Statement stm = null;
	ResultSet rs = null;
	// ----- variables para los datos de la tabla de la bd ----------
	String codigo[] = new String[100];
	String nombre[] = new String[100];
	double precio[] = new double[100];
	int cantidad[] = new int[100];
	
	int contProducto = 0;	// contador de productos
	// --------------------------------------------

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioVenta window = new FormularioVenta();
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
	public FormularioVenta() {
		initialize();
		// ---- conexion a la base de datos y obtencion de datos ------
		try {
			cn = con.getConexionMYSQL();
			stm = (Statement) cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM tabla_productos"); // consulta sql (consulta a la base de datos)
			
			while(rs.next()){
				codigo[contProducto] = rs.getString(1); // columna a extraer
				nombre[contProducto] = rs.getString(2); // columna a extraer
				precio[contProducto] = rs.getDouble(3); // columna a extraer
				cantidad[contProducto] = rs.getInt(4); // columna a extraer
				contProducto++;
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
		// ----------- ADICIONAR ITEMS AL COMBO BOX --------------
		for (int i = 0; i < contProducto; i++) {
			//System.out.println("nombres: "+nombre[i]);
			comboBox.addItem(nombre[i]);
		}
		// --------------------------------------------------------------
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre Cliente:");
		lblNewLabel.setBounds(20, 59, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(20, 107, 73, 14);
		frame.getContentPane().add(lblProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(20, 159, 73, 14);
		frame.getContentPane().add(lblCantidad);
		
		textField = new JTextField();
		textField.setBounds(103, 56, 168, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECCIONAR"}));
		comboBox.setBounds(103, 104, 116, 20);
		frame.getContentPane().add(comboBox);
		
		spinner = new JSpinner();
		spinner.setBounds(103, 156, 86, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Precio:");
		lblNewLabel_1.setBounds(247, 87, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(316, 82, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		chckbxDescuento = new JCheckBox("Descuento (10%)");
		chckbxDescuento.setBounds(263, 126, 139, 23);
		frame.getContentPane().add(chckbxDescuento);
		
		rdbtnRecibo = new JRadioButton("Recibo pago");
		rdbtnRecibo.setBounds(110, 190, 109, 23);
		frame.getContentPane().add(rdbtnRecibo);
		
		rdbtnFactura = new JRadioButton("Factura");
		rdbtnFactura.setBounds(241, 190, 109, 23);
		frame.getContentPane().add(rdbtnFactura);
		
		JButton btnGenerar = new JButton("GENERAR");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nom  = (String) comboBox.getSelectedItem();
				int cant	= (int) spinner.getValue();
 				
				for (int i = 0; i < contProducto; i++) {
					if(nombre[i].equals(nom)){
						double pre = precio[i];
						double importe = pre*cant;
						String msj = String.valueOf(importe);
						textField_1.setText(msj);
						break;
					}
				}
			}
		});
		btnGenerar.setBounds(71, 220, 89, 23);
		frame.getContentPane().add(btnGenerar);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// limpiar fomrulario
				textField.setText("");
				textField_1.setText("0.0");
				comboBox.setSelectedItem("SELECCIONAR");
				spinner.setValue(0);
				chckbxDescuento.setSelected(false);
				rdbtnRecibo.setSelected(false);
				rdbtnFactura.setSelected(false);
			}
		});
		btnNuevo.setBounds(186, 220, 89, 23);
		frame.getContentPane().add(btnNuevo);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnSalir.setBounds(300, 220, 89, 23);
		frame.getContentPane().add(btnSalir);
	}
}

