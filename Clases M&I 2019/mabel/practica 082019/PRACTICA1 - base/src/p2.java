import java.util.Scanner;
public class p2 {
	public static void main(String[] args) {
		
		int salarioBasico, antiguedad;
		Scanner entrada=new Scanner(System.in);
		System.out.println("ingrese salario basico");
		salarioBasico=entrada.nextInt();
		System.out.println("ingrese antiguedad");
		antiguedad=entrada.nextInt();
		calcular(salarioBasico, antiguedad);
	}
	public static void calcular(int salarioBasico,int antiguedad){
		double bonoAntiguedad,totalGanado;
		if(antiguedad<5){
			bonoAntiguedad=salarioBasico*0.1;
		}
		else if(5<=antiguedad && antiguedad <10){
			bonoAntiguedad=salarioBasico*0.15;
		}
		else if(10<=antiguedad && antiguedad <15){
			bonoAntiguedad=salarioBasico*0.25;
		}
		else
			bonoAntiguedad=salarioBasico*0.5;
		
		totalGanado=salarioBasico+bonoAntiguedad;
		System.out.println("salario basico="+salarioBasico);
		System.out.println("bono antiguedad="+bonoAntiguedad);
		System.out.println("total ganado="+totalGanado);
	}
}
