package matrices2;
import java.util.Scanner;

public class MatricesMultiplicacion {
    public static class matriz{
        int f, c;
        float dato;
        matriz sgte;
    }
    public static Scanner teclado;
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        matriz A = null, B = null, C = null;
        int fa = 0, ca = 0, fb = 0, cb = 0, fc = 0, cc = 0, opcion;
        do {
            menu();
            opcion = (int) leer("Su opción es: ");
            switch(opcion) {
                case 1:
                    /* Lectura de la matriz A*/
                    System.out.println("----------------------------");
                    System.out.println("Ingrese los datos de la matriz A.");
                    do {
                        fa = (int) leer("Número de filas: "); /* Lectura del nro de filas matriz A */
                    }while(fa<=0);
                    do {
                        ca = (int) leer("Número de columnas: "); /* Lectura del nro de columnas matriz A */
                    }while(ca<=0);
                    A = leer_matriz(A, fa, ca, "A"); /* Lectura de los datos de la matriz A */
                    break;
                case 2:
                    System.out.println("----------------------------");
                    System.out.println("Ingrese los datos de la matriz B.");
                    do {
                        fb = (int) leer("Número de filas: "); /* Lectura del nro de filas matriz B */
                    }while(fb<=0);
                    do {
                        cb = (int) leer("Número de columnas: "); /* Lectura del nro de columnas matriz B */
                    }while(cb<=0);
                    B = leer_matriz(B, fb, cb, "B"); /* Lectura de los datos de la matriz B */
                    break;
                case 3:
                    System.out.println("----------------------------");
                    listado_matriz("La matriz A es:", A, fa, ca); /* Mostrar contenido matriz A */
                    break;
                case 4:
                    System.out.println("----------------------------");
                    listado_matriz("La matriz B es:", B, fb, cb); /* Mostrar contenido matriz B */
                    break;
                case 5:
                    /* Multiplicación  A x B */
                    System.out.println("----------------------------");
                    if(fa == 0 || ca ==0) {
                        System.out.println("Ingrese la matriz A");
                    } else if(fb == 0 || cb ==0) {
                        System.out.println("Ingrese la matriz B");
                    } else if(ca != fb) { /* Se verifica que ambas matrices cumplan con la condición en la dimensiones (ca == fb) */
                        System.out.println("No es posible realizar la multiplicación (Error en dimensiones)");
                    } else {
                        fc = fa; cc = cb; /* dimensiones de la matriz C (filas y columnas) */
                        C = multiplicar_matrices(A, B, C, fc, cc, ca); /* Multiplicación de A x B */
                        listado_matriz("La matriz C=AxB es:", C, fc, cc); /* Mostrar contenido matriz C */
                    }
                    break;
                case 6:
                    /* Multiplicación  B x A */
                    System.out.println("----------------------------");
                    if(fa == 0 || ca ==0) {
                        System.out.println("Ingrese la matriz A");
                    } else if(fb == 0 || cb ==0) {
                        System.out.println("Ingrese la matriz B");
                    } else if(cb != fa) { /* Se verifica que ambas matrices cumplan con la condición en la dimensiones (cb == fa) */
                        System.out.println("No es posible realizar la multiplicación (Error en dimensiones)");
                    } else {
                        fc = fb; cc = ca; /* dimensiones de la matriz C (filas y columnas) */
                        C = multiplicar_matrices(B, A, C, fc, cc, cb); /* Multiplicación de B x A */
                        listado_matriz("La matriz C=BxA es:", C, fc, cc); /* Mostrar contenido matriz C */
                    }
                    break;
            }
        }while(opcion != 7);
    }
    public static matriz multiplicar_matrices(matriz ma, matriz mb, matriz mc, int fc, int cc, int kc) {
        /* Método que permite multiplicar dos matrices (AxB|BxA)*/
        float acumulador; /* variable auxiliar para acumular las sumas */
        matriz aux;
        for (int i=1; i<=fc; i++) {
            for (int j=1; j<=cc; j++) {
                /* Se crean elementos auxiliar para cada datos de l matriz C */
                aux = new matriz();
                aux.f = i;
                aux.c = j;
                acumulador = 0;
                for (int k=1; k<=kc; k++) {
                    /* Proceso de multiplicación de acuerdo a la fila y columna */
                    acumulador += buscar(ma, i, k) * buscar(mb, k, j);
                }
                aux.dato = acumulador;
                aux.sgte = mc;
                mc = aux;
            }
        }
        return mc;
    }
    public static float buscar(matriz C, int ii, int jj) {
        /* Método que permite buscar el contenido de exacto de una matrix (fila, columna) */
        while(C!=null ) {
            if(ii==C.f && jj==C.c) {
                break;
            }
            C = C.sgte;
        }
        return(C.dato);
    }
    public static void listado_matriz(String t, matriz cab, int fi, int co) {
        /* Método que permite mostrar el contenido de una matriz (A|B|C) */
        System.out.println(t);
        for( int i=1;i<=fi;i++) {
            for(int j=1;j<=co;j++) {
                /* Recorrido de toda la matriz de acuerdo al numero de filas y columnas */
                System.out.print("\t"+buscar(cab,i,j));
            }
            System.out.println();
        }
    }
    public static matriz leer_matriz(matriz cab, int fi, int ci, String nom) {
        /* Método que permite leer la matriz (A|B) */
        matriz aux;
        cab = null;
        for( int i=1;i<=fi;i++) {
            for(int j=1;j<=ci;j++) {
                /* Lectura de datos de acuerdo al número de filas y columnas */
                aux = new matriz();
                aux.f = i;
                aux.c = j;
                aux.dato = leer(nom+"["+i+"]["+j+"] = ");
                aux.sgte = cab;
                cab = aux;
            }
        }
        return(cab);
    }
    public static void menu() {
        /* Método que despliega el menu del programa */
        System.out.println("*** Matrices ***");
        System.out.println("1. Leer Matriz A");
        System.out.println("2. Leer Matriz B");
        System.out.println("3. Mostrar Matriz A");
        System.out.println("4. Mostrar Matriz B");
        System.out.println("5. Multiplicar AxB");
        System.out.println("6. Multiplicar BxA");
        System.out.println("7. Salir");
    }
    public static float leer(String t) {
        /* Método que permite leer numeros flotantes desde teclado */
        float x;
        System.out.print(t);
        x = teclado.nextFloat();
        return(x);
    }
}