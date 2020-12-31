package prueba3;

import java.sql.*;

public class conectarMostrar {
    private static Connection conexion = null;
    private static String bd = "supermarket"; // Nombre de BD.
    private static String user = "root"; // Usuario de BD.
    private static String password = "root"; // Password de BD.
    // Driver para MySQL en este caso.
    private static String driver = "com.mysql.jdbc.Driver";
    // Ruta del servidor.
    private static String server = "jdbc:mysql://localhost/" + bd;
 
    public static void main(String[] args) throws SQLException {
 
        System.out.println("INICIO DE EJECUCIÓN.");
        conectar();
        Statement st = conexion();
 
        // Se elimina la tabla "personal" en caso de existir.
        String cadena = "DROP TABLE IF EXISTS producto;";
        consultaActualiza(st, cadena);
 
        // Se crea la tabla "personal"
        cadena = "CREATE TABLE producto (`Identificador` int(11) NOT NULL AUTO_INCREMENT, `Nombre` varchar(50) NOT NULL,"
        		+ " `Tipo` varchar(20) NOT NULL, `Procedencia` varchar(12) DEFAULT NULL, `FechaExpiracion` varchar(10) DEFAULT NULL, PRIMARY KEY (`Identificador`))";
        consultaActualiza(st, cadena);
 
        // Se crean datos de prueba para utilizarlos en la tabla "personal"
        cadena = "INSERT INTO producto (`Identificador`, `Nombre`, `Tipo`, `Procedencia`, `FechaExpiracion`) VALUES (1, 'Licuadora', "
        		+ "'Electrodomestico', 'USA', 'NINGUNA'), "
        		+ "(2, 'Embutido', 'Comestible', 'Nacional', '12/12/2016'), "
        		+ "(3, 'Pan Molde', 'Comestible', 'Nacional', '19/12/2016'), "
        		+ "(4, 'Leche Soya', 'Comestible', 'Nacional', '01/01/2017');";
        consultaActualiza(st, cadena);
 
        // Se sacan los datos de la tabla personal
        cadena = "SELECT * FROM producto;";
        ResultSet rs = consultaQuery(st, cadena);
        if (rs != null) {
            System.out.println("El listado del producto es el siguiente:");
 
            while (rs.next()) {
                System.out.println("  ID: " + rs.getObject("Identificador"));
                System.out.println("  Nombre producto: "
                        + rs.getObject("Nombre"));
 
                System.out.println("  Tipo: " + rs.getObject("Tipo")
                        + "  Procedencia:" + rs.getObject("Procedencia"));
 
                System.out.println("- ");
            }
            cerrar(rs);
        }
        cerrar(st);
        System.out.println("FIN DE EJECUCIÓN.");
    }
 
    /**
     * Método neecesario para conectarse al Driver y poder usar MySQL.
     */
    public static void conectar() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(server, user, password);
        } catch (Exception e) {
            System.out.println("Error: Imposible realizar la conexion a BD.");
            e.printStackTrace();
        }
    }
 
    /**
     * Método para establecer la conexión con la base de datos.
     *
     * @return
     */
    private static Statement conexion() {
        Statement st = null;
        try {
            st = conexion.createStatement();
        } catch (SQLException e) {
            System.out.println("Error: Conexión incorrecta.");
            e.printStackTrace();
        }
        return st;
    }
 
    /**
     * Método para realizar consultas del tipo: SELECT * FROM tabla WHERE..."
     *
     * @param st
     * @param cadena La consulta en concreto
     * @return
     */
    private static ResultSet consultaQuery(Statement st, String cadena) {
        ResultSet rs = null;
        try {
            rs = st.executeQuery(cadena);
        } catch (SQLException e) {
            System.out.println("Error con: " + cadena);
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
        return rs;
    }
 
    /**
     * Método para realizar consultas de actualización, creación o eliminación.
     *
     * @param st
     * @param cadena La consulta en concreto
     * @return
     */
    private static int consultaActualiza(Statement st, String cadena) {
        int rs = -1;
        try {
            rs = st.executeUpdate(cadena);
        } catch (SQLException e) {
            System.out.println("Error con: " + cadena);
            System.out.println("SQLException: " + e.getMessage());
            e.printStackTrace();
        }
        return rs;
    }
 
    /**
     * Método para cerrar la consula
     *
     * @param rs
     */
    private static void cerrar(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.print("Error: No es posible cerrar la consulta.");
            }
        }
    }
 
    /**
     * Método para cerrar la conexión.
     *
     * @param st
     */
    private static void cerrar(java.sql.Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (Exception e) {
                System.out.print("Error: No es posible cerrar la conexión.");
            }
        }
    }
}