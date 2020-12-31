package ejercicio6;
public class Empleado {
    String Nombre;
    String Cedula;
    String Dependencia;
    public Empleado(String nombre, String cedula, String dependencia) {
        super();
	Nombre = nombre;
	Cedula = cedula;
	Dependencia = dependencia;
    }
    public void mostrar(){
        System.out.println("\tNombre: "+Nombre);
        System.out.println("\tCedula: "+Cedula);
        System.out.println("\tDependencia: "+Dependencia);
    }
}
