package ejercicio6;

public class RecursosHumanos extends Administrativo{
    String Tipo;
    public RecursosHumanos(String nombre, String cedula, String dependencia, double salarioBase, String tipo) {
	super(nombre, cedula, dependencia, 100);
	Tipo = tipo;
    }
    public void mostrar(){
        super.mostrar();
        System.out.println("\tTipo: "+Tipo);
    }
    public double calcularSalario(){ // 1000 tesoreri y 700 secretaria
        double salBase = super.calcularSalario();
        switch(Tipo){
            case "Tesoreria":
                salBase = salBase + 1000;
                break;
            case "Secretaria":
                salBase = salBase +700;
                break;
            default:
                break;
        }
        return salBase;
    }
}



