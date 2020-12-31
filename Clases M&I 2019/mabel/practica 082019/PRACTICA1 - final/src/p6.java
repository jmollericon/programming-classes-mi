import java.util.Scanner;
public class p6 {
    public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
        int n;
        System.out.println("Ingrese numero de elementos de la serie:");
        System.out.println("(mientras sea mas grande mas se aproxima al valor de pi. )");
        n = entrada.nextInt();
        double se = calcularSerie(n);
        System.out.println("\npi = "+se);
    }
    public static double calcularSerie(int n){
        int i,s = 1;
	double serie = 4;
        System.out.print(serie);
	for (i=3;i<=n*2-1;i=i+2){
            serie = serie + Math.pow(-1,s)*(4.0/i*1.0);
            System.out.print(" +("+Math.pow(-1,s)+")*4/"+i);
            s++;
	}
        return serie;
    }
}