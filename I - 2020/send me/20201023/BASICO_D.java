import java.util.Scanner;
public class BASICO_D {//Alexander Sosa
public static class dispersa_m{
	int fi,col;
	float dato;
	dispersa_m sgte;
}
    public static Scanner entrada;
	public static void main(String[] args) {
		entrada=new Scanner(System.in);
		int opcion, n=0,m=0;
		dispersa_m cab=null;
		do {
			menu();
			opcion=(int)leer("Sun opcion es "); //Alexander Sosa
			switch(opcion) {
			case 1: 
				//Stephanie Saavedra
				do {
					n=(int)leer("total de filas?");
				}while(n<=0);
				do {
					m=(int)leer("total de columnas?");
				}while(m<=0);
				cab=crear_matrizD(cab,n,m);
			  //Aracely Torrez
				break;
			case 2:
				listado(" la matriz disperssa es:",cab,n,m);
				break;
				
			}
		}while(opcion!=10);
	}
public static void listado(String x, dispersa_m ca, int f, int c)//fabio Vaquera
{
	System.out.println(x);//Natalia Mendez
		for(int i=0;i<f;i++)
		{
			for(int j=0;j<c;j++)
			{
				System.out.print(buscar(ca,i,j)+"\t");
			}
			System.out.println();
		}
}
public static dispersa_m crear_matrizD(dispersa_m c, int f, int co)	
{   c=null;
	int r;
	dispersa_m nuevo;
	do {
		r=(int)leer("total de elementos diferentes de cero?");
	}while(r<=0 || r>(co*f));
	//Alexander Sosa
	for(int i=1;i<=r;i++)
	{   System.out.println("dato para el elenento "+i);
		nuevo=new dispersa_m();
		do {
			nuevo.fi=(int)leer("Fila del elemento?");
		}while(nuevo.fi<0 || nuevo.fi>=f); //Victor nina
		do {
			nuevo.col=(int)leer("Fcolumna del elemento?");
		}while(nuevo.col<0 || nuevo.col>=co);//Alexander Sosa
		nuevo.dato=leer("Dato?");
		if(buscar(c,nuevo.fi,nuevo.col)==0)
		{
			nuevo.sgte=c; // Ronaldo Rojas
			c=nuevo;
		}
		else
		{
			System.out.println("Ese elemento ya fue registrado ");
			i--; //Natalia Mendez
		}	
		//Alexander Sosa
	}
	return(c);
}
public static float buscar(dispersa_m ca, int f,int c)
{ //Valeria Aguirre, Ronaldo Rojas
	while(ca!=null)
	{
		if(ca.fi==f && ca.col==c)
			return(ca.dato);
		ca=ca.sgte;
	}
	return(0);
}
public static void menu()
{
	System.out.println("*** matrices dispersas ***");
	System.out.println("1. lectura");
	System.out.println("2. listado");
	System.out.println("10.Salir");
}
public static float leer(String x)
{
	float w;//Stephanie Saavedra, 
	System.out.println(x);
	w=entrada.nextFloat();
	return(w);
}
}
