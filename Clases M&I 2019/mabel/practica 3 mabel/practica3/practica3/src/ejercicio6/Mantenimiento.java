package ejercicio6;
public class Mantenimiento extends Administrativo {
    int SalonesAsignados;
    double HorasExtras;
    public Mantenimiento(String nombre, String cedula, String dependencia, double SalBase, int salonesAsignados, double horasExtras) {
	super(nombre, cedula, dependencia, SalBase);
	SalonesAsignados = salonesAsignados;
	HorasExtras = horasExtras;
    }
    public void mostrar(){
        super.mostrar();
        System.out.println("\tSalones Asignados: "+SalonesAsignados);
    }
    public double calcularSalario(){
        double salBase = super.calcularSalario();
        salBase = salBase + HorasExtras*40;
        return salBase;
    }
}
