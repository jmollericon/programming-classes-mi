package ejercicio6;
public class ProfesorTiempoCompleto extends Docente{
    double TotalHorasIvestigacion;
    public ProfesorTiempoCompleto(String nombre, String cedula, String dependencia, double calificacionAsignada, double salario, double totalHorasIvestigacion) {
	super(nombre, cedula, dependencia, calificacionAsignada, salario);
	TotalHorasIvestigacion = totalHorasIvestigacion;
    }
    public void mostrar(){
        super.mostrar();
        System.out.println("\tTotal horas de Investigacion: "+TotalHorasIvestigacion+" Horas.");
    }
    public double calcularSalario(){
        return super.calcularSalario();
    }
}
