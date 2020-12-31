package matrices2;
import java.util.Scanner;
public class MatrizInversaFadeva {
    public static class dispersa_m {
        int fi, col;
        float dato;
        dispersa_m sgte;
    }
    public static Scanner entrada;
    public static void main(String[] args) {
        entrada=new Scanner(System.in);
        int opcion, f = 0, c = 0;
        dispersa_m A = null, A_inv = null, C = null, B = null;
        do {
            menu();
            opcion = (int) leer("Su opción es: ");
            switch(opcion) {
                case 1:
                    /* Lectura de la matriz A */
                    System.out.println("----------------------------");
                    System.out.println("Lectura de la matriz A.");
                    do {
                        f = (int) leer("Número de filas: "); /* Numero de filas de la matriz A */
                    }while(f<=0);
                    do {
                        c = (int) leer("Número de columnas: "); /* Numero de columnas de la matriz A */
                    }while(c<=0);
                    A = crear_matrizD(A, f, c); /* Leer-Crear matriz A */
                    break;
                case 2:
                    /* Mostrar Matriz A */
                    System.out.println("----------------------------");
                    mostrar_matriz("La matriz A (disperssa) es:", A, f, c); /* Método mostrar matriz */
                    break;
                case 3:
                    /* Invertir Matriz */
                    System.out.println("----------------------------");
                    if(f != c){ /* Verificacion que la matriz sea cuadrada */
                        System.out.println("Error en las dimensiones de la matriz (la matriz debe ser cuadrada).");
                    } else {
                        invertir_matriz_metodo_fadeva(A, f, c); /* Invertir Matriz A */
                    }
                    break;
            }
        }while(opcion!=4);
    }

    public static dispersa_m multiplicar_matrices(dispersa_m ma, dispersa_m mb, dispersa_m mc, int fc, int cc, int kc) {
        /* Método que permite multiplicar dos matrices (AxB)*/
        float acumulador; /* variable auxiliar para acumular las sumas */
        dispersa_m aux;
        for (int i=0; i<fc; i++) {
            for (int j=0; j<cc; j++) {
                /* Se crean elementos auxiliar para cada datos de l matriz C */
                aux = new dispersa_m();
                aux.fi = i;
                aux.col = j;
                acumulador = 0;
                for (int k=0; k<kc; k++) {
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
    public static float traza_matriz(dispersa_m mx, int f, int c, int orden) {
        /* Metodo para calcular la traza de una matriz (suma de los elementos de la diagonal principal) */
        float res=0;
        for (int i=0; i<f; i++) {
            for (int j=0; j<c; j++) {
                if(i == j) {
                    /* Cáclulo de la traza (suma de los elementos de la diagonal principal) */
                    res += buscar(mx, i, j);
                }
            }
        }
        return res/orden;
    }
    public static  dispersa_m calcular_Bn(dispersa_m an, dispersa_m bn,  float qn, int f, int c) {
        /* Método que calcula el elemento Bn para el método de fadeva */
        dispersa_m aux;
        float dato_aux = 0;
        for (int i=0; i<f; i++) {
            for (int j=0; j<c; j++) {
                aux = new dispersa_m();
                aux.fi = i;
                aux.col = j;
                if(i == j) { /* con i=j se trabaja con la matriz identidad */
                    dato_aux = buscar(an, i, j) - qn; /* Calculo del metodo de fadeva */
                } else {
                    dato_aux = buscar(an, i, j);
                }
                aux.dato = dato_aux;
                aux.sgte = bn;
                bn = aux;
            }
        }
        return bn;
    }
    public static dispersa_m generarMatrizInversa(dispersa_m bn_1, float qn, dispersa_m A_inv, int f, int c) {
        /* Método que genera la matriz inversa */
        dispersa_m aux;
        for (int i=0; i<f; i++) {
            for (int j=0; j<c; j++) {
                /* Proceso de contrucción de la matriz inversa con el método de fadeva */
                /* A^-1 = (1/qn)*Bn-1 */
                aux = new dispersa_m();
                aux.fi = i;
                aux.col = j;
                aux.dato = buscar(bn_1, i, j)/qn;
                aux.sgte = A_inv;
                A_inv = aux;
            }
        }
        return A_inv;
    }
    public static boolean verificar_inversa(dispersa_m bn_v, int f, int c){
        /* Metodo que verifica que la matriz Bn sea nula (0)*/
        for(int i=0;i<f;i++) {
            for(int j=0;j<c;j++) {
                if(buscar(bn_v,i,j) != 0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void invertir_matriz_metodo_fadeva(dispersa_m ma, int f, int c) {
        dispersa_m bn_1 = new dispersa_m();
        dispersa_m A_inv = new dispersa_m();
        dispersa_m an = ma;
        float qn = traza_matriz(ma, f, c, 1);
        dispersa_m bn = new dispersa_m();
        bn = calcular_Bn(an, bn, qn, f, c);
        bn_1 = bn;
        for(int d=2;d<=f;d++) {
            /* Proceso de contrucción de la matriz inversa con el método de fadeva */
            /* An = A*Bn-1 */
            /* qn = tr(An)/n */
            /* Bn = An - qn*I */
            an = multiplicar_matrices(ma, bn, an, f, c, f); /* An */
            qn = traza_matriz(an, f, c, d); /* qn */
            bn = calcular_Bn(an, bn, qn, f, c); /* Bn */
            if(d == f-1){
                bn_1 = bn;
            }
        }
        if(verificar_inversa(bn, f, c) && qn!=0) { /* Se verifica que la matriz si sea inversible */
            A_inv = generarMatrizInversa(bn_1, qn, A_inv, f, c); /* Generar la matriz inversa -> A^-1 = (1/qn)*Bn_1 */
            mostrar_matriz("La inversa de la matriz A es:", A_inv, f, c);
        } else {
            System.out.println("La matriz ingresada no es inversible!");
        }
    }
    public static void mostrar_matriz(String x, dispersa_m ca, int f, int c) {
        /* Metodo que muestra un matriz* ca, con f filas y c columnas */
        System.out.println(x);
        for(int i=0;i<f;i++) {
            for(int j=0;j<c;j++) {
                System.out.print("\t"+buscar(ca,i,j));
            }
            System.out.println();
        }
    }
    public static dispersa_m crear_matrizD(dispersa_m c, int f, int co) {
        /* Metodo que permite crear un Matriz */
        c = null;
        int r;
        dispersa_m nuevo;
        do {
            r = (int) leer("Total de elementos diferentes de cero: ");
        }while(r<=0 || r>(co*f));

        for(int i=1; i<=r; i++) {
            System.out.println("Dato para el elenento "+i);
            nuevo = new dispersa_m();
            do {
                nuevo.fi = (int) leer("Fila del elemento: ");
            }while(nuevo.fi<0 || nuevo.fi>=f); //Victor nina
            do {
                nuevo.col=(int)leer("Columna del elemento: ");
            }while(nuevo.col<0 || nuevo.col>=co);//Alexander Sosa
            nuevo.dato=leer("Dato, A["+nuevo.fi+"]["+nuevo.col+"] = ");
            if(buscar(c,nuevo.fi,nuevo.col)==0) {
                nuevo.sgte=c;
                c=nuevo;
            } else {
                System.out.println("Ese elemento ya fué registrado");
                i--;
            }
        }
        return(c);
    }
    public static float buscar(dispersa_m ca, int f,int c) {
        /* Método que permite encontrar un elemento especifico (A[f][c]) de la matriz ca */
        while(ca!=null) {
            if(ca.fi==f && ca.col==c)
                return(ca.dato);
            ca = ca.sgte;
        }
        return(0);
    }
    public static void menu() {
        /* Método que despliega el menu del programa */
        System.out.println("*** Inversa de una matriz (matrices dispersas) ***");
        System.out.println("1. Leer matriz A");
        System.out.println("2. Mostrar matriz A");
        System.out.println("3. Invertir matriz A (método Fadeva)");
        System.out.println("4. Salir");
    }
    public static float leer(String x) {
        /* Método que permite leer los datos de entrada desde teclado */
        float w;
        System.out.print(x);
        w = entrada.nextFloat();
        return(w);
    }
}