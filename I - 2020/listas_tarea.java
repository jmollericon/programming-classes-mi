//package listas_g;
import java.util.Scanner;
public class listas_tarea {
	public static class nodo {
		int dato;
		nodo sgte;
	}
    public static Scanner teclado;
	public static void main(String[] args) {
		teclado = new Scanner(System.in);
		nodo cab=null;
		int op=0;
		do {
			op=menu();
			switch(op) {
			case 1:
				cab=agregar_cabecera(cab);
				break;
			case 2:
				listado("La lista es: ", cab);
				break;
			case 3:
				numero_mayor(cab);
				break;
			case 4:
				suma_lista(cab);
				break;
			}			
		}while(op!=10);
		System.out.println("Programa terminado.");
	}
	public static void listado(String p, nodo w) {
		System.out.println(p);
		while(w!=null) {
			System.out.println(w.dato);
			w = w.sgte;
		}
	}
	public static nodo agregar_cabecera(nodo c) {
		nodo nu;
		nu = new nodo();
		nu.dato = leer("Ingrese el dato para el nuevo nodo: ");
		nu.sgte = c;
		c = nu;
		return(c);
	}
	public static void numero_mayor(nodo w) { 
		int mayor = 0;
		while(w!=null) {
			if(w.dato > mayor) {
				mayor = w.dato;
            }
			w = w.sgte;
		}
		System.out.println("El número mayor es: "+mayor);
	}
	public static void suma_lista(nodo w) {
		int suma = 0;
		while(w!=null) {
			suma += w.dato;
			w = w.sgte;
		}
		System.out.println("La suma es: "+suma);
	}
	public static int leer(String p) {
		int r;
		System.out.println(p);
		r=teclado.nextInt();
		return(r);
	}
    public static int menu() {
		System.out.println("Listas simples\nEliga una opción:\n=================");
		System.out.println("1.  Crear");
		System.out.println("2.  Listado");
		System.out.println("3.  Número mayor");
		System.out.println("4.  Sumar lista");
		System.out.println("10. Salir");
		int u = leer("opcion?");
		return(u);
    }
}
