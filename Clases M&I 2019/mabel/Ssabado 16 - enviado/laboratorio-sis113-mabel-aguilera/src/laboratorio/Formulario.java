package laboratorio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Formulario implements Serializable{

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario window = new Formulario();
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
	public Formulario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(148, 44, 151, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 75, 151, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 123, 151, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCi = new JLabel("CI:");
		lblCi.setBounds(38, 47, 46, 14);
		frame.getContentPane().add(lblCi);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBounds(38, 82, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblPlacaVehiculo = new JLabel("PLACA VEHICULO");
		lblPlacaVehiculo.setBounds(38, 126, 100, 14);
		frame.getContentPane().add(lblPlacaVehiculo);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// GUARDAR
				String ci = textField.getText();
				String nom = textField_1.getText();
				String plc = textField_2.getText();
				
				try {
					FileOutputStream fos = new FileOutputStream("datos.bin");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					Auto a = new Auto(ci, nom, plc);
					oos.writeObject(a);
					oos.close();
				} catch (Exception e) {
					System.out.println("Error en el archivo: "+e.getMessage());
				}
				JOptionPane.showMessageDialog(null, "Guardado con exito");
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnGuardar.setBounds(54, 192, 100, 23);
		frame.getContentPane().add(btnGuardar);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnLimpiar.setBounds(185, 192, 89, 23);
		frame.getContentPane().add(btnLimpiar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inicio v = new Inicio();
				v.frame.setVisible(true);
			}
		});
		btnSalir.setBounds(311, 192, 89, 23);
		frame.getContentPane().add(btnSalir);
	}
}
