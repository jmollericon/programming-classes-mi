import java.util.Scanner;
public class p10 {
    public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
        int n;
        System.out.println("Ingrese numero n = ");
        n = entrada.nextInt();
        calcularBilletes(n);
    }    
    public static void calcularBilletes(int n){
	int n200,n100,n50,n20;
	n200=n / 200;
	n = n % 200;
	n100 = n / 100;
	n = n % 100;
	n50 = n / 50;
	n = n % 50;
	n20 = n / 20;
        System.out.println("billetes de 200 : "+n200);
        System.out.println("billetes de 100 : "+n100);
        System.out.println("billetes de 50 : "+n50);
        System.out.println("billetes de 20 : "+n20);
    }    
}