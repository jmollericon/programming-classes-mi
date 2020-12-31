import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ClienteCajero implements Serializable{

	// Atributos
	private String codigoCuenta;
	private int tipoTransaccion;
	private double montoTransaccion;
	private String fechaTransaccion;

	// Constructor
	public ClienteCajero(String codigoCuenta, int tipoTransaccion, double montoTransaccion, String fechaTransaccion) {
		this.codigoCuenta = codigoCuenta;
		this.tipoTransaccion = tipoTransaccion;
		this.montoTransaccion = montoTransaccion;
		this.fechaTransaccion = fechaTransaccion;
	}

	// Getters and Setters 
	public String getCodigoCuenta() {
		return codigoCuenta;
	}
	public void setCodigoCuenta(String codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}
	public int getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(int tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public double getMontoTransaccion() {
		return montoTransaccion;
	}
	public void setMontoTransaccion(double montoTransaccion) {
		this.montoTransaccion = montoTransaccion;
	}
	public String getFechaTransaccion() {
		return fechaTransaccion;
	}
	public void setFechaTransaccion(String fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}
	
	// Métodos	
	
	/*public void producirArchivoSerializado() {
		//ClienteCajero cc = new ClienteCajero(codigoCuenta, tipoTransaccion, montoTransaccion, fechaTransaccion);
		try {
			FileOutputStream fos = new FileOutputStream("datos.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.writeObject(this);
			oos.close();
			
		} catch (Exception e) {
			System.out.println("Error en el archivo"+e.getMessage());
		}
	}
	public void leerArchivoSerializado() throws ClassNotFoundException {
		try{
			FileInputStream fs2=new FileInputStream("datos.bin");
	        ObjectInputStream fs1=new ObjectInputStream(fs2);
	        ClienteCajero obj = null;
	        double total=0,i=0;
	        while (fs2.available()!=0){
	        	obj= (ClienteCajero)fs1.readObject();
	        	total++;
	        	System.out.println(obj.getCodigoCuenta());
	        }
	        fs2.close();
	        System.out.println("cantidad de registros: "+total);
		}
		catch(IOException e){
			System.out.println("Error en el archivo"+e.getMessage());
		}
	}*/
	
	
	

}
