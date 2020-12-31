import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class Inicio {

	static File f;
	static RandomAccessFile raf;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = 0;
		while(opcion != 6) {
			opcion = menu();
			switch(opcion) {
			case 1:
				menuProducto();
				break;
			case 2:
				menuCliente();
				break;
			case 3:
				menuEmpleado();
				break;
			case 4:
				break;
			case 5:
				break;
			}
		}
	}
	
	static int menu() {
		String msgm = "MENU PRINCIPAL \n 1. Producto \n 2. Cliente  \n 3. Empelado  \n 4. Compras  \n 5. Ventas \n 6. Salir";
		int op = Integer.parseInt(JOptionPane.showInputDialog(msgm));
		return op;
	}
	
	static void menuCliente() {
		String msgm = "MENU CLIENTE \n 1. Alta \n 2. Baja  \n 3. Cambio  \n 4. Salir";
		int op = Integer.parseInt(JOptionPane.showInputDialog(msgm));
	}
	
	static void menuEmpleado() {
		String msgm = "MENU EMPLEADO \n 1. Alta \n 2. Baja  \n 3. Cambio  \n 4. Salir";
		int op = Integer.parseInt(JOptionPane.showInputDialog(msgm));
	}
	
	static void menuProducto() {
		String msgm = "MENU PRODUCTO \n 1. Alta \n 2. Baja  \n 3. Cambio  \n 4. Salir";
		int op = Integer.parseInt(JOptionPane.showInputDialog(msgm));
		switch(op) {
		case 1:
			invocaAltaProducto();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
	}
	
	static String llenarEspacios(String cad, int t) {
		while(cad.length()<t) {
			cad = cad + " ";
		}
		return cad;
	}
	
	static void invocaAltaProducto() {
		int idp = Integer.parseInt(JOptionPane.showInputDialog("Ingres ID producto:"));
		String np = JOptionPane.showInputDialog("Ingrese nombre de producto:");
		double cu = Double.parseDouble(JOptionPane.showInputDialog("Ingrese costo unitario:"));
		altaProducto(idp,np,cu);
	}
	
	static void altaProducto(int idprod, String nomProd, double cu) {
		try {
			f = new File("d:/miproyecto/producto.dat");
			raf = new RandomAccessFile(f, "rw");
			long pos = raf.length();
			raf.writeBoolean(true);
			raf.writeInt(idprod);
			raf.writeUTF(llenarEspacios(nomProd,30));
			raf.writeDouble(cu);
			raf.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
