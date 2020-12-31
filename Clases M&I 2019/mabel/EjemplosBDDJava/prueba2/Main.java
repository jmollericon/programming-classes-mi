package prueba2;


import java.sql.ResultSet;
import java.sql.SQLException;
public class Main {

	public static void main(String[] args) {
	    MyDataAcces conexion = new MyDataAcces();
	    ResultSet resultado;
	    String telefono, nombre;
	  
	    resultado = conexion.getQuery("select * from t1");
	  
	    try {
	      while(resultado.next()){
	      telefono = resultado.getString("fono");
	      nombre=resultado.getString("nombre");
	      System.out.println("Telefono : "+telefono);
	      System.out.println("Nombre o : "+nombre);
	      
	      }
	    }catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	   }  
	 }
	}


