import java.util.Scanner;
public class p9 {
    public static void main(String[] args) {
        double totalProduccion;
        totalProduccion = leerProduccion();
        System.out.println("Total de produccion: "+totalProduccion+" toneladas.");
    }    
    public static double leerProduccion(){
        Scanner entrada = new Scanner(System.in);
        double toneladasTrigo, toneladasQuinua, toneladasMaiz,total;
        double sumaTrigo=0, sumaQuinua=0, sumaMaiz=0;
        for(int i=1;i<=10;i++){
            System.out.println("COMUNIDAD "+i+": ");
            System.out.println("Ingrese la produccion de Trigo en toneladas: ");
            toneladasTrigo = entrada.nextInt();
            sumaTrigo = sumaTrigo + toneladasTrigo;
            System.out.println("Ingrese la produccion de Quinua en toneladas: ");
            toneladasQuinua = entrada.nextInt();
            sumaQuinua = sumaQuinua + toneladasQuinua;
            System.out.println("Ingrese la produccion de Maíz en toneladas: ");
            toneladasMaiz = entrada.nextInt();
            sumaMaiz = sumaMaiz + toneladasMaiz;
        }
        System.out.println("\nSe debe contruir una bodega para: ");
        System.out.println("\t"+sumaTrigo+" toneladas de Trigo.");
        System.out.println("\t"+sumaQuinua+" toneladas de Quinua.");
        System.out.println("\t"+sumaMaiz+" toneladas de Maíz.");

        total = sumaTrigo + sumaQuinua + sumaMaiz;
        return total;
    }    
}