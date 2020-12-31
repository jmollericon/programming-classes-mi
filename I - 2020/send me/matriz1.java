package matrices;
//Alexander Sosa
import java.util.Scanner;
public class matriz1 {
public static class matriz{
	int f,c;
	float dato;
	matriz sgte;
}
public static Scanner teclado;
	public static void main(String[] args) {
		teclado=new Scanner(System.in);
		matriz A=null;
		int fa=0,ca=0,opcion;
		do {
			menu();
			opcion=(int)leer("Su opcion es ");
			switch(opcion) {
			case 1: //Aracely Torrez
				do {
				    fa=(int)leer("Total de filas?");
				}while(fa<=0);
				do {
				    ca=(int)leer("Total de columnas?");
				}while(ca<=0);
				A=leer_matriz(A,fa,ca);
				break;
			case 2:
				//recorrido(A);
				System.out.println("--------------");
				listado_matriz("la matriz A es:",A,fa,ca);
				break;
			}
		}while(opcion!=10);
 }

public static float buscar(matriz C, int ii, int jj)
{
	while(C!=null )
	{
		if(ii==C.f && jj==C.c)
		{
			break;
		}
		C=C.sgte;
	}
	return(C.dato);
}
public static void listado_matriz(String t, matriz cab, int fi, int co)
{
	for( int i=1;i<=fi;i++)
	{
		for(int j=1;j<=co;j++)
		{
			System.out.print("\t"+buscar(cab,i,j));//Sara Salazar
		}
		System.out.println();
	}
}
public static matriz leer_matriz(matriz cab, int fi, int ci)
{
	matriz aux;
	cab=null;
	for( int i=1;i<=fi;i++)
	{
		for(int j=1;j<=ci;j++)
		{
			aux=new matriz();
			aux.f=i;
			aux.c=j;
			aux.dato=leer("dato ["+i+"]["+j+"]?");
			aux.sgte=cab;//Moises Quispe
			cab=aux;
		}//Valeria Aguirre
	}//Juan Carranza
	return(cab);
}

public static void menu()
{
	System.out.println("***matrices***");
	System.out.println("1. lectura");
	System.out.println("2. listado");
	System.out.println("3. Traza");
	System.out.println("4. sumatoria diagonal secundaria");
	System.out.println("5. sumatoria diagonal fila x");
	System.out.println("6. sumatoria diagonal columna x");
	System.out.println("7. Verifica Identidad");
	System.out.println("8. Suma de matrices ");
	System.out.println("10. Salir");//Aracely Torrez
}
//Sara Salazar
public static float leer(String t)
{
	float x;
	System.out.println(t);
	x=teclado.nextFloat();
	return(x);
}
}
