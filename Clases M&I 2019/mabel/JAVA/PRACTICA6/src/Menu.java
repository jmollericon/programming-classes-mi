import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;


public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
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
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAdministracionBd = new JMenu("Administracion BD");
		menuBar.add(mnAdministracionBd);
		
		JMenuItem mntmAnadirNuevosProductos = new JMenuItem("anadir nuevos productos");
		mnAdministracionBd.add(mntmAnadirNuevosProductos);
		
		JMenuItem mntmEliminarProducto = new JMenuItem("eliminar producto");
		mnAdministracionBd.add(mntmEliminarProducto);
		
		JMenuItem mntmBuscarProducto = new JMenuItem("buscar producto");
		mnAdministracionBd.add(mntmBuscarProducto);
		
		JMenu mnFormulariodeVenta = new JMenu("formulariode venta");
		menuBar.add(mnFormulariodeVenta);
		
		JMenuItem mntmIrAFormulario = new JMenuItem("ir a formulario");
		mnFormulariodeVenta.add(mntmIrAFormulario);
		
		JMenu mnSalir = new JMenu("salir");
		menuBar.add(mnSalir);
	}
}
