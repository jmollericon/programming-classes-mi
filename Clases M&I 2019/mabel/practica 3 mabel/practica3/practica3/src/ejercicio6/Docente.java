package ejercicio6;
public class Docente extends Empleado{
    double CalificacionAsignada;
    double Salario;
    public Docente(String nombre, String cedula, String dependencia, double calificacionAsignada, double Sal) {
	super(nombre, cedula, dependencia);
	CalificacionAsignada = calificacionAsignada;
        Salario = Sal;
    }
    public void mostrar(){
        super.mostrar();
        System.out.println("\tCalificación Asignada: "+CalificacionAsignada);
    }    
    public double calcularSalario(){
        double sal = Salario;
        if(CalificacionAsignada > 4.5){ // se aumenta 2000
            sal = sal + 2000;
        }
        return sal;
    }
}
