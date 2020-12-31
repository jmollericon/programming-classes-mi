package proFinal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

public class Main2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = 0;
		while(opcion != 3) {
			opcion = menu();
			switch(opcion) {
			case 1:
				alta();
				break;
			case 2:
				lista();
				break;
			}
		}
	}
	static int menu() {
		int ele=-1;
		while(ele<1 || ele>3) {
			String m = "MENU DE OPCIONES \n 1. Alta \n 2. Lista \n 3. Salir";
			ele = Integer.parseInt(JOptionPane.showInputDialog(m));
		}
		return ele;
	}
	static void alta() {
		try {
			
			String data = JOptionPane.showInputDialog("Ingrese nombre completo: ");
			
			FileOutputStream fout = new FileOutputStream("g:/daka/datos.txt",true);
			byte cb[];
			cb = data.getBytes();
			fout.write(cb);
			fout.write('\n');
			fout.close();
			System.out.println("el registro fue grabado exitosamente");
		}catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}

	static void lista() {
		try {
			FileInputStream fin = new FileInputStream("g:/daka/datos.txt");
			System.out.println("Listado del archivo");
			String regs = "";
			String reg = "";
			int c;
			while( (c=fin.read()) != -1 ) {
				if(c!='\n') {
					reg = reg + (char)c;
				}else {
					regs = regs + reg + "\n";
					reg = "";
				}
			}
			JOptionPane.showMessageDialog(null, regs);
			fin.close();
		}catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}

}
