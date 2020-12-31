import java.util.Scanner;


public class p7 {

	public static void main(String[] args) {
	int vendedores,sueldoBase;
	Scanner entrada=new Scanner(System.in);
	System.out.println("ingrese numero de vendedores");
	vendedores=entrada.nextInt();
	System.out.println("ingrese sueldo base");
	sueldoBase=entrada.nextInt();
calcular(vendedores,sueldoBase);
	}
public static void calcular(int vendedores, int sueldoBase){
	int nVentas;
	double sueldoSemana,sueldoTotal;
	Scanner entrada=new Scanner(System.in);
	for (int i = 1; i <=vendedores; i++) {
		System.out.println("ingrese numero de ventas - vendedor "+i);
		nVentas=entrada.nextInt();
		sueldoSemana = sueldoBase*0.10*nVentas;
		sueldoTotal = sueldoBase + sueldoSemana;
		System.out.println("vendedor "+i);
		System.out.println("sueldo semana = "+sueldoSemana + "Bs.");
		System.out.println("sueldo total = "+sueldoTotal + "Bs.");
	}
}
}
