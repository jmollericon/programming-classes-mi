import java.util.Scanner;
public class p12 {
    public static void main(String[] args) {
	Scanner entrada = new Scanner(System.in);
        int n;
        System.out.println("Ingrese numero n = ");
        n = entrada.nextInt();
	System.out.println("numero ordenado ascendentemente : "+ordenaAscendente(n));
    }    
    public static int ordenaAscendente(int n){
	int p = 0; // patron
	int numeroOrdenado = 0, np = n;
	while(p<=9){
            while (n>0){
                if (n%10==p){
                    numeroOrdenado = (numeroOrdenado*10)+ n%10;
		}
		n= (int)(n/10);
            }
            n = np;
            p++;
	}
	return numeroOrdenado;
    }    
}