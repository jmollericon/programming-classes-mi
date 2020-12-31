package ejercicio6;
public class Administrativo extends Empleado{
    double SalarioBase;
    public Administrativo(String nombre, String cedula, String dependencia, double salarioBase) {
	super(nombre, cedula, dependencia);
	SalarioBase = salarioBase;
    }
    public void mostrar(){
        super.mostrar();
    }
    public double calcularSalario(){
        SalarioBase = 5000;
        return SalarioBase;
    }
}
