package laboratorio;


import java.awt.EventQueue;
import java.awt.TextField;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reportes implements Serializable{

	JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reportes window = new Reportes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 */
	public Reportes() throws ClassNotFoundException {
		initialize();
		String lista="";
		try{
			FileInputStream fs2=new FileInputStream("datos.bin");
	        ObjectInputStream fs1=new ObjectInputStream(fs2);
	        Auto obj = null;
	        while (fs2.available()!=0){
	        	obj= (Auto)fs1.readObject();
	        	lista += obj.getCi()+"\t"+obj.getNombre()+"\t"+obj.getPlaca()+"\n";
	        }
	        fs2.close();
		}
		catch(IOException e){
			System.out.println("Error en el archivo"+e.getMessage());
		}
		System.out.println("datos\n"+lista);
		textField.setText(lista);
		
		JButton btnNewButton = new JButton("SALIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inicio v = new Inicio();
				v.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
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
		textField.setBounds(38, 26, 370, 195);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
