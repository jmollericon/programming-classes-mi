import java.util.Scanner;
public class p4 {
	public static void main(String[] args) {
		
		int n,a,b;
		Scanner entrada=new Scanner(System.in);
		System.out.println("ingrese limite inferior");
		a=entrada.nextInt();
		System.out.println("ingrese limite superior");
		b=entrada.nextInt();
		System.out.println("ingrese numero de intentos");
		n=entrada.nextInt();
		adivinar(a,b,n);
	}
public static void adivinar(int a, int b, int n){
	Scanner entrada=new Scanner(System.in);
	int limInferior=a, limSuperior=b,mio;
	int r;
	do{
		r = (int)(Math.random()*100);
		//System.out.println("r = "+r);
	}
	while(r<a||r>b);
	for (int i = 1; i <=n; i++) {
		System.out.println("el numero esta entre "+limInferior+" y "+limSuperior);
		System.out.println("intento"+i);
		mio=entrada.nextInt();
		if(mio==r){
			System.out.println("ganaste!!!!!");
			break;
		}
		else if(mio<r){
			limInferior=mio;
		}
		else
		limSuperior=mio;
	
		if(i==n) System.out.println("perdiste!!!!! vuelve a intentarlo");
	}
}
}
