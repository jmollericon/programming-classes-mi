package examen;
/**
 *
 * @author Isabel
 */
import java.io.File;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

public class examen {
    static File f1 = new File("carrera.dat");  // nombre del archivo para menjo de los producto
    static File f2 = new File("materia.dat");     // nombre del archivo, regsro de ventas
    static File f3 = new File("alumno.dat");     // nombre del archivo, regsro de ventas
    static File f4 = new File("inscripcion.dat");     // nombre del archivo, regsro de ventas
    
    static String nombreProducto[] = new String[100];
    static int cantidadProducto[] = new int[100];
    static double importeProducto[] = new double[100];
    static int idProducto[] = new int[100];
    static int nroVentas = 0;
	
    public static void main(String[] args) {
		int op = 0;
		while(op != 3) {
	            op = menuPrincipal();
	            switch(op) {
	        	case 1:
	        		
	        		break;
	        	case 2:
	                
	                
	                break;
	            }
		}
    }
    
	static int menuPrincipal() {
		int op = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la operación a realizar:\n    1. Registrar\n    2. Registrar Venta\n    3. Salir"));
		return op;
	}
	
	static void registrarCarrera() {
            int idp = -1, verificar, cantidad = -1;
           
                idp         = Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del producto (entero)"));
                
            String nombre   = JOptionPane.showInputDialog("Ingrese nombre del producto");
           
                cantidad    = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad (entero)"));
                
                costo    = Double.parseDouble(JOptionPane.showInputDialog("Ingrese costo unitario (real)"));
                
            alta(idp, nombre, cantidad, costo);
	}
    static void alta(int idProducto, String nombre, int cantidad, double precioUnitario) { // registr producto en el archivo dataProductos.dat
	try {
            RandomAccessFile raf = new RandomAccessFile(f1, "rw");
            raf.seek(raf.length());
            raf.writeBoolean(true);
            raf.writeInt(idProducto);
            raf.writeUTF(completaConEspacios(nombre, 25));
            raf.writeInt(cantidad);
            raf.writeDouble(precioUnitario);
            raf.close();
            System.out.println("exito en la alta");
	}catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error "+e.getMessage());
	}
    }
    static void buscaProducto() {
	int idp =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del producto a buscar (entero)"));
	int posRec = existeIdProducto(idp);
	if(posRec < 0) {
            JOptionPane.showMessageDialog(null, "El ID no existe.! ");
	}else {
            try {
		RandomAccessFile raf = new RandomAccessFile(f1, "r");
		raf.seek(posRec);
		String reg = "RESULTADO DE LA BÚSQUEDA:\nidProd     nombre            cantidad     precio Unit'\n";
		boolean flag = raf.readBoolean();
		if(flag == true) {
                    int idProd              = raf.readInt();
                    String nombre           = raf.readUTF();
                    int cantidad            = raf.readInt();
                    double precioUnitario   = raf.readDouble();
                    reg += "    "+idProd+"           "+nombre + "  "+cantidad+ "            " +precioUnitario+" Bs.\n";
                }
		JOptionPane.showMessageDialog(null, reg);
            }catch(Exception e) {
                JOptionPane.showMessageDialog(null, "error "+e.getMessage());
            }
        }
    }
    static int existeIdProducto(int idBuscado) {
	int posUbi = -1;
	try {
            RandomAccessFile raf = new RandomAccessFile(f1, "r");
            int pos = 0;
            while(pos < raf.length()) {
		raf.seek(pos);
		boolean flag = raf.readBoolean();
		if(flag == true) {
                    int idProd = raf.readInt();
                    if(idProd == idBuscado) {
			posUbi = pos;
                        break;
                    }
		}
		pos = pos + 44;
            }
	}catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error "+e.getMessage());
	}
        return posUbi;
    }
    static int existeNombreProducto(String nomBuscado) {
		int posUbi = -1;
		try {
			RandomAccessFile raf = new RandomAccessFile(f1, "r");
			int pos = 0;
			System.out.println("Listado del archivo ");
			while(pos < raf.length()) {
				raf.seek(pos);
				boolean flag = raf.readBoolean();
				if(flag == true) {
					int idProd = raf.readInt();
					String nomProd = raf.readUTF();
					System.out.println("nombre prod = "+nomBuscado +" y "+nomProd);
					nomBuscado = completaConEspacios(nomBuscado, 25);
					if(nomProd.equals(nomBuscado)) {
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
	static double[] buscarProductoNombre(String nombreBuscar){
		double precio_cantidad_id[] = new double[5];
		precio_cantidad_id[0] = -1;
		precio_cantidad_id[1] = 0;
		precio_cantidad_id[2] = 0;
		int posRec = existeNombreProducto(nombreBuscar);
		if(posRec < 0) {
			JOptionPane.showMessageDialog(null, "El producto no existe.\ningrese nuevamente.");
		}else {
			try {
				RandomAccessFile raf = new RandomAccessFile(f1, "r");
				raf.seek(posRec);
				String reg = "";
				boolean flag = raf.readBoolean();
				if(flag == true) {
					int idProd = raf.readInt();
					String nombre = raf.readUTF();
					int cantidad = raf.readInt();
					double precioUnitario = raf.readDouble();
					reg = "Nombre producto: "+nombre+"\nPrecio unitario: "+precioUnitario+" Bs. \nCantidad disponible: "+cantidad+" unidades.";
					precio_cantidad_id[0] = precioUnitario;
					precio_cantidad_id[1] = cantidad;
					precio_cantidad_id[2] = idProd;
				}
				JOptionPane.showMessageDialog(null, reg);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "error "+e.getMessage());
			}
		}
		return precio_cantidad_id;
	}
    static void bajaLogica() {
	int idBuscado   = Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del producto a eliminar")); 
	int idRes       = existeIdProducto(idBuscado);
	if(idRes >= 0) {
            int res = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
            System.out.println(" res = "+res);
            if(res == 0) baja(idRes);
	}else {
            JOptionPane.showMessageDialog(null, "ID de producto inexistente");
	}
    }
    static void baja(int pos) {
	try {
            RandomAccessFile raf = new RandomAccessFile(f1, "rw");
            raf.seek(pos);
            raf.writeBoolean(false);
            raf.close();
            System.out.println("exito en la baja logica");
	}catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error "+e.getMessage());
        }
    }
    static void editarProducto() {
	int idp     = Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del producto a modificar (entero)"));
	int posRec  = existeIdProducto(idp);
	if(posRec < 0) {
            JOptionPane.showMessageDialog(null, "El ID no existe.!");
	}else {
            String nombre = JOptionPane.showInputDialog("Ingrese nuevo nombre");
            int cantidad = -1;
            double costo = -1;
            do{
                cantidad    = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nueva cantidad (entero)"));
                if(cantidad <= 0) JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a cero.");
            }while(cantidad <= 0);
            do{
                costo    = Double.parseDouble(JOptionPane.showInputDialog("Ingrese nuevo costo unitario (real)"));
                if(costo <= 0) JOptionPane.showMessageDialog(null, "El costo unitario debe ser mayor a cero.");
            }while(costo <= 0);
            cambioEfectivo(posRec, nombre, cantidad, costo);
	}
    }
    static void cambioEfectivo(int pos, String nombre, int cantidad, double precioUnitario) {
	try {
            RandomAccessFile raf = new RandomAccessFile(f1, "rw");
            raf.seek(pos+5);
            raf.writeUTF(completaConEspacios(nombre, 25));
            raf.writeInt(cantidad);
            raf.writeDouble(precioUnitario);
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
            RandomAccessFile raf = new RandomAccessFile(f1, "r");
            int pos = 0;
            String datos = "idProd     nombre            cantidad     precio Unit'\n";
            String reg = "";
            while(pos < raf.length()) {
		raf.seek(pos);
		boolean flag = raf.readBoolean();
		if(flag == true) {
                    int idProd = raf.readInt();
                    String nombre = raf.readUTF();
                    int cantidad = raf.readInt();
                    double precioUnitario = raf.readDouble();
                    reg = "    "+idProd+"           "+nombre + "  "+cantidad+ "            " +precioUnitario+" Bs.\n";
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
    static void registrarVenta() {
        int ciComprador = Integer.parseInt(JOptionPane.showInputDialog("Ingrese CI del comprador"));
        int pro = 0, sigOpe;
        boolean sw2 = true;
        String nombre;
        do{
            double pre_cant_id[] = new double[5];
            pre_cant_id[0] = 0;
            pre_cant_id[1] = 0;
            int cantidad = 0;
            do{
                nombre = JOptionPane.showInputDialog("Ingrese nombre del producto "+(pro+1)+": ");
                pre_cant_id = buscarProductoNombre(nombre); // devuelve el precio (si no encontro '-1') y la cantidad
            }while(pre_cant_id[0] < 0); // si es mayor que cero -> se encontró el material deseado
            do{
                cantidad =  Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad (entero)"));
                if(cantidad > pre_cant_id[1]) JOptionPane.showMessageDialog(null, "La cantidad excede a la disponible.");
                if(cantidad <= 0) JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a cero.");
            }while(cantidad > pre_cant_id[1] || cantidad <= 0);
            double importe =  cantidad*pre_cant_id[0]; // pre_cant[0] = precio
            nombreProducto[pro]     = nombre;
            cantidadProducto[pro]   = cantidad;
            importeProducto[pro]    = importe;
            idProducto[pro]         = (int)pre_cant_id[2];
            pro++;
            do{
                sigOpe = Integer.parseInt(JOptionPane.showInputDialog("1. Ingresar Otro producto\n2. Finalizar Venta"));
            }while(sigOpe<1 || sigOpe > 2);
            if(sigOpe == 2){
                sw2 = false;
                for(int i=0; i<pro; i++){
                    altaVenta(nroVentas, ciComprador, (i+1), nombreProducto[i], cantidadProducto[i], importeProducto[i]);
                    //System.out.println("iddddd = "+ idProducto[i]);
                    cambiarStockProducto(idProducto[i], cantidadProducto[i]);
                }
                JOptionPane.showMessageDialog(null, "Registrado correctamente.!");
                nroVentas++;
            }
        }while(sw2 == true);		
    }
    static void altaVenta(int nroFactura, int ciComprador, int nroLista, String nomProd, int cantidadProd, double importeProd) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f2, "rw");
            raf.seek(raf.length());
            raf.writeBoolean(true);
            raf.writeInt(nroFactura);
            raf.writeInt(ciComprador);
            raf.writeInt(nroLista);
            raf.writeUTF(completaConEspacios(nomProd, 25));
            raf.writeInt(cantidadProd);
            importeProd = (double)Math.round(importeProd * 100d) / 100d;
            raf.writeDouble(importeProd);
            raf.close();
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error "+e.getMessage());
        }
    }	
	static void mostrarVentas() {
		try {
			RandomAccessFile raf2 = new RandomAccessFile(f2, "r");
			int pos = 0;
			String datos = "factura       CI          nro      nombre Prod    cantidad     importe \n";
			String reg = "";
			while(pos < raf2.length()) {
				raf2.seek(pos);
				boolean flag = raf2.readBoolean();
				if(flag == true) {
					int nroFactura		= raf2.readInt();
					int ciCompra 		= raf2.readInt();
					int nroLista 		= raf2.readInt();
					String nomProd 		= raf2.readUTF();
					int cantidadProd	= raf2.readInt();
					double importeProd 	= raf2.readDouble();
					reg = "nro.   "+nroFactura+"   "+ciCompra+"    "+nroLista+"          "+nomProd+"  "+cantidadProd+"            "+importeProd+" Bs.\n";
					//                  4        +      4       +       4           +        25+2    +        4             +             8     + 1 (boolean)   = 52 bytes
				}
				datos = datos + reg;
				reg = "";
				pos = pos + 52;
			}
			JOptionPane.showMessageDialog(null, datos);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "error "+e.getMessage());
		}
	}
    static int cargarNumeroFactura(){
	int  c = 0;
	try {
            RandomAccessFile raf2 = new RandomAccessFile(f2, "r");
            int pos = 0;
            while(pos < raf2.length()) {
		raf2.seek(pos);
		boolean flag = raf2.readBoolean();
            	if(flag == true) {
                    c   = raf2.readInt();
		}
		pos = pos + 52;
            }
	}catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error "+e.getMessage());
	}
        c = c + 1;
        return c;
    }
	static void cambiarStockProducto(int idp, int cantidadSalida){
		String dataProducto[] = new String[10];
		dataProducto[0] = "-1"; // posicion
		dataProducto[1] = " "; // nombre
		dataProducto[2] = "0"; // cantidad
		dataProducto[3] = "0"; // costo unitario
		dataProducto[4] = "0"; // id
		dataProducto = obtenerDatosProducto(idp);

		int posRec = Integer.parseInt(dataProducto[0]);
		String nombre = dataProducto[1];
		int cantidad =  Integer.parseInt(dataProducto[2]) - cantidadSalida;
		double costo =  Double.parseDouble(dataProducto[3]);
		cambioEfectivo(posRec, nombre, cantidad, costo);
    }
	static String[] obtenerDatosProducto(int idBuscado) {
		String valores[] = new String[10];
		valores[0] = "-1"; // posicion
		valores[1] = " "; // nombre
		valores[2] = "0"; // cantidad
		valores[3] = "0"; // costo unitario
		valores[4] = "0"; // id
		try {
			RandomAccessFile raf = new RandomAccessFile(f1, "r");
			int pos = 0;
			System.out.println("Listado del archivo ");
			while(pos < raf.length()) {
				raf.seek(pos);
				boolean flag = raf.readBoolean();
				if(flag == true) {
					int idProd = raf.readInt();
					if(idProd == idBuscado) {
						valores[0] = pos+""; 			  // posicion
						valores[1] = raf.readUTF()+"";    // nombre
						valores[2] = raf.readInt()+"";    // cantidad
						valores[3] = raf.readDouble()+""; // costo unitario
						valores[4] = idProd+"";    	      // id

					}
				}
				pos = pos + 44;
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "error "+e.getMessage());
		}
		return valores;
	}
	static void mostrarVentasFactura(int nFac) {
		try {
			RandomAccessFile raf2 = new RandomAccessFile(f2, "r");
			int pos = 0;
			String datos = "factura       CI          nro      nombre Prod    cantidad     importe \n";
			String reg = "";
			double impTotal = 0;
			while(pos < raf2.length()) {
				raf2.seek(pos);
				boolean flag = raf2.readBoolean();

				if(flag == true) {
					int nroFactura		= raf2.readInt();
					int ciCompra 		= raf2.readInt();
					int nroLista 		= raf2.readInt();
					String nomProd 		= raf2.readUTF();
					int cantidadProd	= raf2.readInt();
					double importeProd 	= raf2.readDouble();
					if(nroFactura == nFac){
					      reg = "nro.   "+nroFactura+"   "+ciCompra+"    "+nroLista+"          "+nomProd+"  "+cantidadProd+"            "+importeProd+" Bs.\n";
							//                  4        +      4       +       4           +        25+2    +        4             +             8     + 1 (boolean)   = 52 bytes					      
					      impTotal = impTotal + importeProd;
					}
				}
				datos = datos + reg;
				reg = "";
				pos = pos + 52;
			}
			JOptionPane.showMessageDialog(null, datos+"\nIMPORTE TOTAL:   "+impTotal+" Bs.");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "error "+e.getMessage());
		}
	}
}