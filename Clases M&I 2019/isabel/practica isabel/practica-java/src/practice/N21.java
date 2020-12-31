package practice;
import javax.swing.JOptionPane;
public class N21 {
	public static void main(String[] args) {
		int n;
		n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de n"));
		int v[] = new int[n];
		generarArreglo(n, v);
		System.out.println("");
		subArreglos(n, v);
	}
	public static void generarArreglo(int n, int v[]) {
		System.out.println("Array generado: ");
		for (int i = 0; i < n; i++) {
			v[i] = (int)(Math.random()*9);
			System.out.print(v[i]+" ");
		}
	}
	public static void subArreglos(int n, int v[]) {
		System.out.println("Sub-Arreglos: ");
		int s=0, h;
		h = n - 2; 
		for (int i = 0; i < n; i++) {
			s += v[i];
			for (int j = i; j < n; j++) {
				if(Math.abs(i-j) <= h || i==j) {
					s += sumarSubArreglos(i,j,v);
					mostrarSubArreglos(i,j,v);
				}
			}
		}
		// mostrar arreglo como sub arreglo
		System.out.print("{");
		for (int i = 0; i < n; i++) {
			System.out.print(v[i]+"");
			if(i<n-1) System.out.print(", ");
		}
		System.out.println("}");
		System.out.println("suma = "+s);
	}
	public static int sumarSubArreglos(int a, int b, int v[]) {
		int suma = 0;
		for (int i = a; i <= b; i++) {
			suma += v[i]; 
		}
		return suma;
	}
	public static void mostrarSubArreglos(int a, int b, int v[]) {
		System.out.print("{");
		for (int i = a; i <= b; i++) {
			System.out.print(v[i]+"");
			if(i<b) System.out.print(", ");
		}
		System.out.print("}, ");
	}
}
