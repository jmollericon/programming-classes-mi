import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class Serializacion_Datos implements Serializable{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException {
		Calendar fecha = new GregorianCalendar();
		CuentaCliente cliente[] = new CuentaCliente[100];
		ClienteCajero cajero[] = new ClienteCajero[100];
		int nroClientes = 0;
		int nroCliCajero = 0;
		double monto = 0;
		int opcion = 0;
		while(opcion != 4) {
			String menu="Seleccione una opción:\n1. Seleccionar Cliente\n2. Registrar Cliente\n3. Transacciones Cajero\n4. Salir";
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opcion) {
				case 1:
					//mostrarListaClientes();
					int nCli 	= leerArchivoSerializadoCuentaCliente(cliente);
					int cliSelc = 0, opc = 0;
					if(nCli > 0) {
						do {
							cliSelc = mostrarCuentaCliente(cliente, nCli);	
						}while(cliSelc<0 || cliSelc>nCli);
						if(cliSelc == 0) opc=4; // Salir
						// SE SELECCIONÓ UN CLIENTE
						while(opc != 4) {
							do {
								opc = menuClienteCajero(cliente[cliSelc-1]);							
							}while(opc < 1 || opc > 4);
							switch (opc) {
								case 1: // CONSULTA DE SALDO
									String msj = "Nombre: "+cliente[cliSelc-1].getNombreCliente()+"\nNro. de Cuenta:  "+cliente[cliSelc-1].getCodigoCuenta()+"\nSaldo: "+cliente[cliSelc-1].getSaldoInicial()+" Bs.";
									String fechaSaldo = fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.YEAR); 
									//System.out.println(fechaSaldo);
									
									nroCliCajero = leerArchivoSerializadoClienteCajero(cajero);
									cajero[nroCliCajero] = new ClienteCajero(cliente[cliSelc-1].getCodigoCuenta(), 1, 0.0, fechaSaldo);
									nroCliCajero++;
									
									guardarArchivoSerializadoClienteCajero(cajero, nroCliCajero);
									JOptionPane.showMessageDialog(null, msj);
									break;
								case 2: // RETIRO DE EFECTIVO
									String fechaRetiro = fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.YEAR); 
									// System.out.println(fechaRetiro);
									monto = Double.parseDouble(JOptionPane.showInputDialog("Ingresé el monto de Retiro: "));
									
									if(monto <= cliente[cliSelc-1].getSaldoInicial()) {
										// registrar retiro
										cliente[cliSelc-1].setSaldoInicial(cliente[cliSelc-1].getSaldoInicial()-monto);
										
										// eliminar contenido del fichero de CuentaCliente.bin
										vaciarFicheroCuentaCliente();
										// guardar los nuevos registros
										guardarArchivoSerializadoCuentaCliente(cliente, nCli);
										
										// registrar transaccion
										nroCliCajero = leerArchivoSerializadoClienteCajero(cajero);
										cajero[nroCliCajero] = new ClienteCajero(cliente[cliSelc-1].getCodigoCuenta(), 2, monto, fechaRetiro);
										nroCliCajero++;
										
										guardarArchivoSerializadoClienteCajero(cajero, nroCliCajero);
										JOptionPane.showMessageDialog(null, "Retiro realizado correctamente");
									}else {
										JOptionPane.showMessageDialog(null, "No tiene Saldo suficiente");
									}
									break;
								case 3: // DEPOSITO DE EFECTIVO
									// obtenemos la fecha
									String fechaDeposito = fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.YEAR); 
									// System.out.println(fechaDeposito);
									// se ingresa el monto de deposito y se actualiza el saldo del cliente
									monto = Double.parseDouble(JOptionPane.showInputDialog("Ingresé el monto de Depósito: "));
									cliente[cliSelc-1].setSaldoInicial(cliente[cliSelc-1].getSaldoInicial()+monto);
									
									// eliminar contenido del fichero de CuentaCliente.bin
									vaciarFicheroCuentaCliente();
									// guardar los nuevos registros
									guardarArchivoSerializadoCuentaCliente(cliente, nCli);
									
									// registrar la transaccion
									nroCliCajero = leerArchivoSerializadoClienteCajero(cajero);
									cajero[nroCliCajero] = new ClienteCajero(cliente[cliSelc-1].getCodigoCuenta(), 3, monto, fechaDeposito);
									nroCliCajero++;
									
									guardarArchivoSerializadoClienteCajero(cajero, nroCliCajero);
									JOptionPane.showMessageDialog(null, "Depósito realizado correctamente");
									break;
							}
						}
						//cliente[cliSelc-1].mostrar();
					}else {
						JOptionPane.showMessageDialog(null,"No hay Cliente Registrados.");
					}
					//JOptionPane.showMessageDialog(null, cliSelc);
					//System.out.println(nCli+" - "+cliSelc);
					
					break;
				case 2:
					// REGISTRAR CLIENTE
					nroClientes = leerArchivoSerializadoCuentaCliente(cliente);
					String cod 	= JOptionPane.showInputDialog("Ingrese el Código de Cuenta: ");
					String nom 	= JOptionPane.showInputDialog("Ingrese el Nombre del Cliente: ");
					double sal 	= Double.parseDouble(JOptionPane.showInputDialog("Ingrese el Saldo Inicial"));
					cliente[nroClientes] = new CuentaCliente(cod, nom, sal);
					nroClientes++;

					guardarArchivoSerializadoCuentaCliente(cliente, nroClientes);
					break;
				case 3: // MOTRAR TRANSACCIONES EN EL CAJERO
					nroCliCajero = leerArchivoSerializadoClienteCajero(cajero);
					mostrarClienteCajero(cajero, nroCliCajero);
					break;
				case 4:
					JOptionPane.showMessageDialog(null, "Saliendo del programa.");		
					break;
			}
		}
	}
	static void guardarArchivoSerializadoCuentaCliente(CuentaCliente cc[], int nc) {
		try {
			FileOutputStream fos = new FileOutputStream("datosCuentaCliente.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (int i = 0; i < nc; i++) {
				//System.out.println(cc[i].getNombreCliente());
				oos.writeObject(cc[i]);
			}
			oos.close();
		} catch (Exception e) {
			System.out.println("Error en el archivo: "+e.getMessage());
		}
	}
	static int leerArchivoSerializadoCuentaCliente(CuentaCliente cliente[]) throws ClassNotFoundException {
		int i=0;
		try{
			FileInputStream fs2=new FileInputStream("datosCuentaCliente.bin");
	        ObjectInputStream fs1=new ObjectInputStream(fs2);
	        CuentaCliente obj = null;
	        while (fs2.available()!=0){
	        	obj= (CuentaCliente)fs1.readObject();
	        	cliente[i]=obj;
	        	//System.out.println(i+".- "+obj.getCodigoCuenta()+" \t "+obj.getNombreCliente()+" \t "+obj.getSaldoInicial());
	        	i++;
	        }
	        fs2.close();
		}
		catch(IOException e){
			System.out.println("Error en el archivo"+e.getMessage());
		}
		return i;
	}
	static int mostrarCuentaCliente(CuentaCliente cliente[], int nCli) {
        String mensaje = "SELECCIONE UN CLIENTE:\n0.-  Regresar\n";
		for (int i = 0; i < nCli; i++) {
        	mensaje = mensaje + (i+1) +".-  Nombre:  "+cliente[i].getNombreCliente()+"\n       Nro. de Cuenta:  "+cliente[i].getCodigoCuenta()+"\n";
		}
		return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
	}
	static int menuClienteCajero(CuentaCliente cliS){
		
		String msj = "Nombre:   "+cliS.getNombreCliente()+"\nNro de Cuenta:   "+cliS.getCodigoCuenta()+"\n===========================\n";
		msj += "SELECCIONE UNA OPCIÓN:\n1. Consultar Saldo\n2. Retiro de Efectivo\n3. Depósito de Efectivo\n4. Atras (Salir de la Cuenta)";
		return Integer.parseInt(JOptionPane.showInputDialog(msj));
	}
	
	static int leerArchivoSerializadoClienteCajero(ClienteCajero cajero[]) throws ClassNotFoundException {
		int i=0;
		try{
			FileInputStream fs2=new FileInputStream("datosClienteCajero.bin");
	        ObjectInputStream fs1=new ObjectInputStream(fs2);
	        ClienteCajero obj = null;
	        while (fs2.available()!=0){
	        	obj= (ClienteCajero)fs1.readObject();
	        	cajero[i]=obj;
	        	i++;
	        }
	        fs2.close();
	        // System.out.println("cantidad de registros: "+ i);
		}
		catch(IOException e){
			System.out.println("Error en el archivo"+e.getMessage());
		}
		return i;
	}
	static void guardarArchivoSerializadoClienteCajero(ClienteCajero cc[], int nc) {
		try {
			FileOutputStream fos = new FileOutputStream("datosClienteCajero.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (int i = 0; i < nc; i++) {
				//System.out.println(cc[i].getNombreCliente());
				oos.writeObject(cc[i]);
			}
			oos.close();
		} catch (Exception e) {
			System.out.println("Error en el archivo: "+e.getMessage());
		}
	}
	static void mostrarClienteCajero(ClienteCajero cajero[], int nCliCa) throws ClassNotFoundException {
        String mensaje = "TRANSACCIONES: \n#  nroCuenta          Tipo         Monto     Fecha\n";
        mensaje += "=  =========      ======     ======  ======\n";

		for (int i = 0; i < nCliCa; i++) {
			String tipo="";
			String montoT = Double.toString(cajero[i].getMontoTransaccion());
			if(cajero[i].getTipoTransaccion()==1) {tipo="CONSULTA"; montoT="  s/m  "; }
			else if(cajero[i].getTipoTransaccion()==2) tipo="  RETIRO  ";
			else tipo="DEPÓSITO";
        	mensaje = mensaje + (i+1) +":   "+cajero[i].getCodigoCuenta()+"    "+tipo+"    "+montoT+"    "+cajero[i].getFechaTransaccion()+"\n";
		}
		JOptionPane.showMessageDialog(null, mensaje);
	}
	static void vaciarFicheroCuentaCliente() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("datosCuentaCliente.bin"));
			bw.write("");
			bw.close();	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
