package Prueba1;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class Conexion {
	
    //Datos para conectarnos a la BD  MySQL
    //Usuario de la BD
    private String usuario = "root";
    //Contraseña si tiene, si no tiene entonces dejar en blanco
    private String pass = "root"; 
    //Servidor (localhost si lo tenemos local) o puede ser un servidor remoto
    private String host = "localhost";
    //Nombre de la base de datos a la cual queremos conectarnos
    private String nombre_BD = "agenda"; 
 
    //Objeto del tipo conexion lo declaramos nulo
    private Connection con = null;
 
    //Metodo que realiza la conexion a la BD
    //Devuelve null si no se pudo realizar la conexion
    //Devuelve la conexion en caso de exito
    public Connection getConexionMYSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance( );
            String servidor = "jdbc:mysql://"+host+"/"+nombre_BD;
            con = (Connection) DriverManager.getConnection(servidor,usuario,pass);
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return con;
        }
    }

}
