import java.util.Scanner;
public class p1 {
	public static void main(String[] args) {
		
		int hora,minutos,segundos;
		Scanner entrada=new Scanner (System.in);
		System.out.println("ingrese horas");
		hora=entrada.nextInt();
		System.out.println("ingrese minutos");
		minutos=entrada.nextInt();
		System.out.println("ingrese segundos");
		segundos=entrada.nextInt();
		System.out.println(hora+"h " +minutos+"m "+segundos+"s");
		convertir(hora,minutos, segundos);
	}
public static void convertir(int hora, int minutos, int segundos){
	int segConvertido, minConvertido, horaConvertido;
	
	segConvertido=segundos%60;
	minutos=minutos+(segundos/60);
	minConvertido=minutos%60;
	horaConvertido=hora+(minutos/60);
	
	System.out.println(horaConvertido+"h " +minConvertido+"m "+segConvertido+"s");
}
}
