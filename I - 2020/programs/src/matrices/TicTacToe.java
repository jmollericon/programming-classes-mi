package matrices;
import java.util.Scanner;
public class TicTacToe {
    public static class matriz{
        int f, c;
        String dato;
        matriz sgte;
    }
    public static Scanner teclado;
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        matriz A = null;
        int f=3, c=3, contador = 9;
        String nombre_jugador_1 = "", nombre_jugador_2 = "", estado_juego = "";
        boolean turno = true;   // para intercambiar los turnos entre los jugadores
        A = iniciar_juego(A, f, c); // Esta función permite inicialzar la matriz 3x3 que se la base del juego
        nombre_jugador_1 = leer("Ingrese el nombre del jugador 1: "); // Lectura del nombre del jugador 1
        nombre_jugador_2 = leer("Ingrese el nombre del jugador 2: "); // Lectura del nombre del jugador 2
        do {
            mostrar_tablero(A, f, c); // Esta función imprime el tablero en su respectivo estado (antes de cada jugada)
            if(turno) {
                A = leer_jugada_jugador(A, f, c, nombre_jugador_1, "X"); // Lectura de la jugada del jugador 1
                turno = false;  // indica que el siguiente turno le toca al otro jugador
            } else {
                A = leer_jugada_jugador(A, f, c, nombre_jugador_2, "O"); // Lectura de la jugada del jugador 2
                turno = true;   // indica que el siguiente turno le toca al otro jugador
            }
            contador--;         // Variable auxiliar que ayuda a verificar que ya se dieron los 9 turnos del juego, si nadie ganó entonces es empate
            estado_juego = verificar_ganador(A, nombre_jugador_1, nombre_jugador_2, contador); // Verificar si hay un ganador
        } while(estado_juego == "");
        mostrar_tablero(A, f, c);   // Se muestra el estado del tablero al final del trabajo
        if(estado_juego == "EMPATE") { // Verificar si el estado final del juego es EMPATE
            System.out.println("El juego terminó en EMPATE");
        } else { // Si nos es EMPATE entonces se imprime el nombre del ganador
            System.out.println("El ganador es: "+estado_juego);
        }
    }
    public static String verificar_ganador(matriz cab, String nj1, String nj2, int contador) {
        /*
        * Esta función se encarga de verificar después de cada jugada si
        * ya existe un jugador ganador, o si ya termino el juego y quedaron
        * en empate.
        * Se verifican todas las filas, columnas y la diagonal principal y secundaria.
        * Retorna un String con el resultado del juego (cadena vacia indica que continue el juego)
        * */

        // Verificar rayas horizontales
        /* Verificamos si existe alguna fila que tenga los mismo simbolos 'X' o 'O' */
        for (int i=1; i<=3; i++){
            if(buscar(cab,i,1)==buscar(cab,i,2) && buscar(cab,i,2)==buscar(cab,i,3)) {
                if(buscar(cab,i,1) == "X") {
                  return nj1;
                } else if(buscar(cab,i,1) == "O") {
                    return  nj2;
                }
            }
        }
        // Verificar rayas verticales
        /* Verificamos si existe alguna columna que tenga los mismo simbolos 'X' o 'O' */
        for (int c=1; c<=3; c++){
            if(buscar(cab,1, c)==buscar(cab,2, c) && buscar(cab,2, c)==buscar(cab,3, c)) {
                if(buscar(cab,1, c) == "X") {
                    return nj1;
                } else if(buscar(cab,1, c) == "O") {
                    return  nj2;
                }
            }
        }
        // Verificar rayas diagonales
        /* Verificación de la diagonal principal, que tenga los mismos simbolos 'X' o 'O' */
        if(buscar(cab,1, 1)==buscar(cab,2, 2) && buscar(cab,2, 2)==buscar(cab,3, 3)) {
            if(buscar(cab,1, 1) == "X") {
                return nj1; // si el simbolo es 'X' entonces gano el jugador 1
            } else if(buscar(cab,1, 1) == "O") {
                return  nj2; // si el simbolo es 'O' entonces gano el jugador 2
            }
        }
        /* Verificación de la diagonal secundaria, que tenga los mismos simbolos 'X' o 'O' */
        if(buscar(cab,3, 1)==buscar(cab,2, 2) && buscar(cab,2, 2)==buscar(cab,1, 3)) {
            if(buscar(cab,3, 1) == "X") {
                return nj1;  // si el simbolo es 'X' entonces gano el jugador 1
            } else if(buscar(cab,3, 1) == "O") {
                return  nj2; // si el simbolo es 'O' entonces gano el jugador 2
            }
        }
        // Verificar si es empate
        /* Si el contador llega a 0 y nadie gano aún, entonces es un empate */
        if(contador == 0) {
            return "EMPATE";
        }
        return "";
    }
    public static String buscar(matriz C, int i, int j) {
        /*
        * Esta función permite buscar un elemento de la posicion
        * i, j, de la matriz (lista)
        * Retorna el dato encontrado en la matriz de acuerdo a i y j.
        * */
        while(C != null) {
            if(i==C.f && j==C.c) {
                break;
            }
            C = C.sgte;
        }
        return(C.dato);
    }
    public static void mostrar_tablero(matriz cab, int f, int c) {
        /*
        * Esta función imprime el estado del tablero
        */
        System.out.println("\nEstado del TABLERO");
        for( int i=1; i<=f; i++) {
            for(int j=1; j<=c; j++) {
                System.out.print("\t"+buscar(cab, i, j));
            }
            System.out.println();
        }
        System.out.println();
    }
    public static matriz iniciar_juego(matriz cab, int f, int c) {
        /*
        * Esta función da la bienvenida e inicializa la
        * matriz 3x3 (3 en raya) con datos iniciales, el
        * simbolo '-' indica que esa casilla está disponible,
        * Esta función retorna la matriz inicializada.
        */
        System.out.println("Bienvenidos a Tic Tac Toe.");
        System.out.println("=========== = === === ====");
        matriz aux;
        // LLenar matriz de '-'
        for( int i=1;i<=f;i++) {
            for(int j=1;j<=c;j++) {
                // Llenado de la matriz de 3x3 con el simbolo '-'
                aux = new matriz();
                aux.f = i;
                aux.c = j;
                aux.dato = "-";
                aux.sgte = cab;
                cab = aux;
            }
        }
        return cab;
    }
    public static String leer(String t) {
        /*
        * Esta función permite leer datos tipo String
        * Retorna valor leido por teclado.
        * */
        String x;
        System.out.print(t);
        x = teclado.next();
        return(x);
    }
    public static matriz leer_jugada_jugador(matriz cab, int f, int c, String jugador, String ficha) {
        /*
        * Esta función permite leer la jugada el jugador x
        * El jugador debe ingresar la fila y la columna donde
        * desea poner su ficha ('X' o 'O').
        * Si el jugador ingresa una fila o columna superior a 3
        * o inferior a 1, se vuelve a solitar los valores, de igual
        * forma si la casilla seleccionada ya estpa siendo ocupada.
        * Esta función retorna la matriz actualizada despues
        * de la jugada realizada.
        * */
        matriz aux;
        System.out.println("Turno de "+jugador+".");
        System.out.println("Ingrese la posición donde pondrá su ficha '"+ficha+"':");
        int fila = 1, columna = 1;
        do {
            System.out.println("Fila (1-3), Columna (1-3).");
            System.out.print("Fila: ");
            fila = teclado.nextInt();       // Lectura de la fila donde el jugador x desea poner su ficha
            System.out.print("Columna: ");
            columna = teclado.nextInt();    // Lectura de la columna donde el jugador x desea poner su ficha
        } while(fila<1 || fila>3 || columna<1 || columna>3 || buscar(cab, fila, columna) != "-"); // Validación que los datos esten dentro del rando y no hay ya sido ocupada antes
        // Llenar ficha, actualización del estado del tablero (matriz 3x3)
        aux = new matriz();
        aux.f = fila;
        aux.c = columna;
        aux.dato = ficha;
        aux.sgte = cab;
        cab = aux;
        return cab;     // Retorno de la matriz (tablero) actualizado
    }
}