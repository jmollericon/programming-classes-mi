//package listas_g;
import java.util.Scanner;
public class listas_tarea {
	public static class nodo
	{
		int dato;
		nodo sgte;
	}
    public static Scanner teclado;
	public static void main(String[] args) {
		teclado=new Scanner(System.in);
		nodo cab=null;
		int op=0;
		do {
			op=menu();
			switch(op) {
			case 1:
				cab=agregar_cabecera(cab);
				break;
			case 2:
				listado("la lista es ",cab);
				break;
			}			
		}while(op!=10);
	}
	public static void listado(String p, nodo w)
	{
		System.out.println(p);
		while(w!=null)
		{
			System.out.println(w.dato);
			w=w.sgte;
		}
	}
	public static nodo agregar_cabecera(nodo c)
	{
		nodo nu;
		nu=new nodo();
		nu.dato=leer("dato para el nuevo nodo ");
		nu.sgte=c;
		c=nu;
		return(c);
	}
	public static int leer(String p)
	{
		int r;
		System.out.println(p);
		r=teclado.nextInt();
		return(r);
	}
    public static int menu()
    {
    	System.out.println("   lista simples  ");
    	System.out.println("1.  crear  ");
    	System.out.println("2.  listado  ");
    	System.out.println("10. salir ");
    	int u=leer("opcion?");
    	return(u);
    }
}
