package Lc;

import javax.swing.JOptionPane;

public class BasicoCircularDoble {
	public static class circular{
		int dato;
		circular sgte, ant;
	}
	public static void main(String[] args) {
		circular cab=null;
		int op;
		do {
			op=menu();
			switch(op){
			case 1:
				cab=agregar_circular(cab);
				break;
			case 2:
				listado("Listado:",cab);
				break;
			}
		}while(op!=3);
	}

	public static void listado(String string, circular cab) {
		System.out.println(string);
		if(cab!=null) {
			circular copia=cab;
			do {
				System.out.println(copia.dato+"\t");
				copia=copia.sgte;
			}while(copia.sgte!=cab.ant.sgte);
		}else {
			System.out.println("lista vacioa");
		}
		
	}	
	public static circular agregar_circular(circular cab) {
		circular copia;
		circular nuevo= new circular();
		nuevo.dato=Integer.parseInt(JOptionPane.showInputDialog("Dato del nodo"));
		nuevo.sgte=nuevo;
		nuevo.ant=nuevo;
		if(cab==null) {
			cab=nuevo;
		}else {
			copia=cab;
			while(copia.sgte!=cab.ant) {
				copia=copia.sgte;
			}
			nuevo.sgte=cab.ant;
			copia.sgte=nuevo.ant;
			copia.ant=nuevo.sgte;
		}
		return cab;
	}

	public static int menu() {
		int n;
		String m="Listas circulares dobles \n1. Agregar nodo \n2. Listar \n3. Salir";
		n=Integer.parseInt(JOptionPane.showInputDialog(m));
		return n;
	}
}
