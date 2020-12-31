import java.util.Scanner;
public class p3 {
	public static void main(String[] args) {
		
		int productos;
		Scanner entrada=new Scanner(System.in);
		System.out.println("ingrese productos");
		productos=entrada.nextInt();
		
		calcular(productos);
		
	}
public static void calcular (int productos){
	double precio,suma=0,pagoIVA;
	Scanner entrada=new Scanner(System.in);
	for(int i=1; i<=productos;i++){
		System.out.println("precio producto"+i+"= ");
		precio=entrada.nextDouble();
		suma =suma + precio;
		}
	if(suma>2500){
		suma=suma-(0.05*suma);
	}
	pagoIVA=suma*0.13;
	System.out.println("el pago por IVA es:"+pagoIVA);
	System.out.println("total de ventas es:"+suma);
}
}
