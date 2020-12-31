package proFinal;
import java.io.File;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;
public class MainBackup {
	static File f = new File("dataProductos.dat"); // nombre del archivo
		
	public static void main(String[] args) {
		int opcion = 0;
		while(opcion !=6) {
			opcion = menu();
			switch(opcion) {
			case 1:
				nuevoRegistro();
				break;
			case 2:
				buscaProducto();
				break;
			case 3:
				bajaLogica();
				break;
			case 4:
				cambio();
				break;
			case 5:
				listaArchivo();
				break;
			}
		}
	}
	
	static int menu() {
		String m = "MENU DE OPCIONES \n 1. Alta \n 2. Busca producto \n 3. Baja \n 4. Cambio  \n 5. Listado \n 6. Fin";
		int op = Integer.parseInt(JOptionPane.showInputDialog(m));
		return op;
	}
	
	static void buscaProducto() {
		int idp =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del producto a buscar (entero)"));
		int posRec = existeIdProducto(idp);
		if(posRec < 0) {
			JOptionPane.showMessageDialog(null, "error, id existente");
		}else {
			try {
				RandomAccessFile raf = new RandomAccessFile(f, "r");
				raf.seek(posRec);
				String reg = "";
				boolean flag = raf.readBoolean();
				if(flag == true) {
					int idProd = raf.readInt();
					String nombre = raf.readUTF();
					int cantidad = raf.readInt();
					double costoUnitario = raf.readDouble();
					reg = idProd + "  " +nombre + "  "+cantidad+ "  " +costoUnitario;
				}
				JOptionPane.showMessageDialog(null, reg);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "error "+e.getMessage());
			}
		}
	}
	
	static void nuevoRegistro() {
		int idp =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del producto (entero)"));
		String nombre = JOptionPane.showInputDialog("Ingrese nombre");
		int cantidad =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad (entero)"));
		double costo =  Double.parseDouble(JOptionPane.showInputDialog("Ingrese costo unitario (real)"));
		int posRec = existeIdProducto(idp);
		if(posRec>=0) {
			JOptionPane.showMessageDialog(null, "error, id existente");
		}else {
			alta(idp, nombre, cantidad, costo);
		}
	}
	
	
	
	static void  alta(int idProducto, String nombre, int cantidad, double costoUnitario) {
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			raf.seek(raf.length());
			raf.writeBoolean(true);
			raf.writeInt(idProducto);
			raf.writeUTF(completaConEspacios(nombre, 25));
			raf.writeInt(cantidad);
			raf.writeDouble(costoUnitario);
			raf.close();
			System.out.println("exito en la alta");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "error "+e.getMessage());
		}
	}
	
	static int existeIdProducto(int idBuscado) {
		int posUbi = -1;
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "r");
			int pos = 0;
			System.out.println("Listado del archivo ");
			while(pos < raf.length()) {
				raf.seek(pos);
				boolean flag = raf.readBoolean();
				if(flag == true) {
					int idProd = raf.readInt();
					if(idProd == idBuscado) {
						posUbi = pos;
					}
				}
				pos = pos + 44;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "error "+e.getMessage());
		}
		return posUbi;
	}
	
	static void bajaLogica() {
		int idBuscado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese id de producto a eliminar")); 
		int idRes = existeIdProducto(idBuscado);
		if(idRes>=0) {
			int res = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
			System.out.println(" res = "+res);
			baja(idRes);
		}else {
			JOptionPane.showMessageDialog(null, "error, id de producto inexistente");
		}
	}
	
	static void baja(int pos) {
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			raf.seek(pos);
			raf.writeBoolean(false);
			raf.close();
			System.out.println("exito en la baja logica");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "error "+e.getMessage());
		}
	}
	
	
	
	static void  cambio() {
		int idp =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del producto a modificar (entero)"));
		int posRec = existeIdProducto(idp);
		if(posRec < 0) {
			JOptionPane.showMessageDialog(null, "error, id existente");
		}else {
			String nombre = JOptionPane.showInputDialog("Ingrese nuevo nombre");
			int cantidad =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese nueva cantidad (entero)"));
			double costo =  Double.parseDouble(JOptionPane.showInputDialog("Ingrese nuevo costo unitario (real)"));
			cambioEfectivo(posRec, nombre, cantidad, costo);
		}
	}
	
	static void  cambioEfectivo(int pos, String nombre, int cantidad, double costoUnitario) {
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			raf.seek(pos+5);
			raf.writeUTF(completaConEspacios(nombre, 25));
			raf.writeInt(cantidad);
			raf.writeDouble(costoUnitario);
			raf.close();
			System.out.println("exito en el cambio");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "error "+e.getMessage());
		}
	}
	
	
	static String completaConEspacios(String nombre, int tamanio) {
		if(nombre.length() > tamanio) {
			nombre = nombre.substring(0,tamanio);
		}else {
			while(nombre.length()<tamanio) {
				nombre = nombre + " ";
			}
		}
		return nombre;
	}
	
	static void listaArchivo() {
		try {
			RandomAccessFile raf = new RandomAccessFile(f, "r");
			int pos = 0;
			String datos = "";
			String reg = "";
			while(pos < raf.length()) {
				raf.seek(pos);
				boolean flag = raf.readBoolean();
				if(flag == true) {
					int idProd = raf.readInt();
					String nombre = raf.readUTF();
					int cantidad = raf.readInt();
					double costoUnitario = raf.readDouble();
					reg = idProd + " " +nombre + "  "+cantidad+ "    " +costoUnitario+"\n";
				}
				datos = datos + reg;
				reg = "";
				pos = pos + 44;
			}
			JOptionPane.showMessageDialog(null, datos);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "error "+e.getMessage());
		}
	}
}

