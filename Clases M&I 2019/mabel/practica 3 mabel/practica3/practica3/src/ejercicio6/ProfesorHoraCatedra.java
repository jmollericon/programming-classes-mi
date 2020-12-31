package ejercicio6;
public class ProfesorHoraCatedra extends Docente{
    double HorasAsignadas;
    public ProfesorHoraCatedra(String nombre, String cedula, String dependencia, double califi, double horasAsignadas) {
	super(nombre, cedula, dependencia, califi, 0);
	HorasAsignadas = horasAsignadas;
    }
    public void mostrar(){
        super.mostrar();
        System.out.println("\tHoras Asignadas: "+HorasAsignadas+" Horas.");
    }	
    public double calcularSalario(){
	double salario = HorasAsignadas*50;
        return salario;
    }
}
