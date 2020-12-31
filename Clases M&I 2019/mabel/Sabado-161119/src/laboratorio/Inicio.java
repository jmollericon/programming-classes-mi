package laboratorio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.io.Serializable;

public class Inicio implements Serializable{

	JFrame frame;
	private final Action action = new SwingAction();
	private JButton btnRegistroClientes;
	private JButton btnSalie;

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
		Formulario fo = new Formulario();
		
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
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
		
		JButton btnNewButton = new JButton("AGREGAR CLIENTES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Formulario fo = new Formulario();
				fo.frame.setVisible(true);
				//String msj = textField.getText();
				//System.out.println("Presionado sobre boto\nMensaje: "+msj);
				 
			}
		});
		btnNewButton.setBounds(48, 71, 138, 69);
		frame.getContentPane().add(btnNewButton);
		
		btnRegistroClientes = new JButton("REPORTE CLIENTES");
		btnRegistroClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reportes re;
				try {
					re = new Reportes();
					re.frame.setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnRegistroClientes.setBounds(224, 71, 146, 69);
		frame.getContentPane().add(btnRegistroClientes);
		
		btnSalie = new JButton("SALIR");
		btnSalie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalie.setBounds(227, 176, 143, 61);
		frame.getContentPane().add(btnSalie);
	}
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
