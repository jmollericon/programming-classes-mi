
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexion {

	private String Usuario ="root";
	private String pass = "";
	private String host = "localhost";
	private String nombre_BD = "producto";
	private Connection con = null;
	
	public Connection getConexionMYSQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String servidor = "jdbc:mysql://"+host+"/"+nombre_BD;
			con = (Connection) DriverManager.getConnection(servidor,Usuario,pass);
			System.out.println("conectado");
			return con;
		}catch(Exception e) {
			e.printStackTrace();
			return con;
		}
	}
}
