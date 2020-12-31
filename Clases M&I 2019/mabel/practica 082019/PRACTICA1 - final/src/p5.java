import java.util.Scanner;
public class p5 {
    public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
        int n;
        System.out.println("Ingrese numero n = ");
        n = entrada.nextInt();
        System.out.print(n+" ");
        calcular(n);
        System.out.println(" ");
    }    
    public static void calcular(int n){
	while (n>1){
            if (n % 2 == 0){
                n=n/2;
            }
            else {
		n = n*3 +1;
            }
            System.out.print(n+" ");
	}	
    }    
}