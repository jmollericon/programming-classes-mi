package examen_copy;
import java.util.Scanner;
public class JuegoFichas {
    public static class doble {
        int dato;
        doble sgte, ant;
    }
    public static Scanner entrada;
    static doble lista_jugador_1i = null, lista_jugador_1d = null;
    static doble lista_jugador_2i = null, lista_jugador_2d = null;
    static int v1 = 0, v2 = 0;
    public static void main(String[] args) {
        entrada = new Scanner(System.in);
        String resultado = "";
        boolean jugar = true;

        iniciar_juego(); /* Iniciar el juego (condiciones iniciales) */
        controlar_estado_juego(); /* Mostrar estado del juego */

        while(resultado == "") {
            if(jugar) { /* variable jugar permite intercalar los turnos en ambos jugadores */
                jugar = false;
                System.out.println("\n\nTurno JUGADOR 1:");
            } else {
                jugar = true;
                System.out.println("\n\nTurno JUGADOR 2:");
            }
            ejecutar_turno(); /* Ejecuta el turno (borrar dos numeros) */
            controlar_estado_juego(); /* Mostrar estado del juego */

            /* Verificar Ganador */
            if(v1 == 1) { /* Si solo queda un 1 entonces el ganador es el jugador 1 */
                resultado = "El ganador es el JUGADOR 1";
            }
            if(v2 == 1) { /* Si solo queda un 2 entonces el ganador es el jugador 2 */
                resultado = "El ganador es el JUGADOR 2";
            }
            System.out.println();
        }
        System.out.println("\nRESULTADO: " + resultado);
    }
    public static void ejecutar_turno() {
        /* Función que permite ejecutar el turno (borrar dos numeros cualesquiera) */
        int op;
        doble aux;
        do {
            opciones_turno(); /* Función que despliega las opciones de eliminar */
            op = leer("Su opción es: ");
            switch (op){
                case 1: /* Eliminar dos 1's */
                    /*if(v1 == 2) {
                        System.out.println("No se puede ejecutar la jugada, solo quedan dos 1's");
                        op = 0; /* Otra vez su turno */
                        /*break;
                    }*/
                    lista_jugador_1d = borrar_cabecera_derecha(lista_jugador_1d);
                    lista_jugador_1d = borrar_cabecera_derecha(lista_jugador_1d);
                    if(lista_jugador_1d == null) {
                        lista_jugador_1i = null;
                    }
                    /* Números identicos, entonces se agrega un 2 en la lista de 2's */
                    aux = nuevo_valor(2);
                    if (lista_jugador_2i == null) {
                        lista_jugador_2i = aux;
                        lista_jugador_2d = aux;
                    } else {
                        lista_jugador_2d = add_der(lista_jugador_2d, aux);
                    }
                    break;
                case 2: /* Eliminar dos 2's */
                    lista_jugador_2d = borrar_cabecera_derecha(lista_jugador_2d);
                    lista_jugador_2d = borrar_cabecera_derecha(lista_jugador_2d);
                    if(lista_jugador_2d == null) {
                        lista_jugador_2i = null;
                    }
                    /* Números identicos, entonces se agrega un 2 en la lista de 2's */
                    aux = nuevo_valor(2);
                    if (lista_jugador_2i == null) {
                        lista_jugador_2i = aux;
                        lista_jugador_2d = aux;
                    } else {
                        lista_jugador_2d = add_der(lista_jugador_2d, aux);
                    }
                    break;
                case 3: /* Eliminar un 1 y un 2 */
                    lista_jugador_1d = borrar_cabecera_derecha(lista_jugador_1d);
                    lista_jugador_2d = borrar_cabecera_derecha(lista_jugador_2d);
                    /* Números diferentes, entonces se agrega un 1 en la lista de 1's */
                    aux = nuevo_valor(1);
                    if (lista_jugador_1i == null) {
                        lista_jugador_1i = aux;
                        lista_jugador_1d = aux;
                    } else {
                        lista_jugador_1d = add_der(lista_jugador_1d, aux);
                    }
                    break;
            }
        } while(op<1 || op>3);
    }
    public static void opciones_turno() {
        System.out.println("*** Eliminar dos numeros ***");
        System.out.println("\t1. Eliminar dos 1's");
        System.out.println("\t2. Eliminar dos 2's");
        System.out.println("\t3. Eliminar un 1 y un 2");
    }
    public static void iniciar_juego() {
        /* Se escriben diez números 1's y diez números 2's representados
        en dos listas doblemente enlazadas (Condición inicial del juego) */
        doble aux;
        System.out.println("Bienvenido al JUEGO DE FICHAS");
        System.out.println("========== == ===== == ======");
        for(int i=0; i<10; i++) {
            /* Diez números 1's - Jugador 1 */
            aux = nuevo_valor(1);
            if (lista_jugador_1i == null) {
                lista_jugador_1i = aux;
                lista_jugador_1d = aux;
            } else {
                lista_jugador_1d = add_der(lista_jugador_1d, aux);
            }
            /* Diez números 2's - Jugador 2 */
            aux = nuevo_valor(2);
            if (lista_jugador_2i == null) {
                lista_jugador_2i = aux;
                lista_jugador_2d = aux;
            } else {
                lista_jugador_2d = add_der(lista_jugador_2d, aux);
            }
        }
    }
    public static void controlar_estado_juego() {
        /* Función que permite control el estado del juego en cada turno */
        System.out.println("\nESTADO DEL JUEGO");
        System.out.print("====== === =====");
        v1 = verificar_lista_izq_der(lista_jugador_1i); /* Verifica cuantos 1's hay en la lista del jugador 1 */
        v2 = verificar_lista_izq_der(lista_jugador_2i); /* Verifica cuantos 2's hay en la lista del jugador 2 */
        listado_iz_der("Lista Jugador 1 (Izd a der):", v1+" 1's", lista_jugador_1i); /* Mostrar cantidad de 1's y la lista del jugador 1 */
        listado_iz_der("Lista Jugador 2 (Izd a der):", v2+" 2's", lista_jugador_2i); /* Mostrar cantidad de 2's y la lista del jugador 2 */
    }
    public static int verificar_lista_izq_der(doble ca) {
        int c=0;
        while(ca!=null) {
            c++;
            ca = ca.sgte;
        }
        return c;
    }
    public static doble borrar_cabecera_derecha(doble cabd) {
        if(cabd==null || cabd.ant==null){
            return null;
        }
        cabd = cabd.ant;
        cabd.sgte = null;
        return cabd;
    }
    public static void listado_der_iz(String texto, doble ca) {
        System.out.println("\n"+texto);
        while(ca!=null) {
            System.out.print(ca.dato+"\t");
            ca = ca.ant;
        }
    }
    public static void listado_iz_der(String texto, String cantidad, doble ca) {
        System.out.println("\n"+texto);
        System.out.print("Hay "+cantidad+":\t");
        while(ca!=null) {
            System.out.print(ca.dato+"\t");
            ca = ca.sgte;
        }
    }
    public static doble add_iz(doble c, doble nue) {
        nue.sgte = c;
        c.ant = nue;
        c = nue;
        return(c);
    }
    public static doble add_der(doble c, doble nue) {
        c.sgte = nue;
        nue.ant = c;
        c = nue;
        return(c);
    }
    public static doble nuevo_valor(int valor) {
        doble n = new doble();
        n.dato = valor;
        n.sgte = null;
        n.ant = null;
        return(n);
    }
    public static doble nuevo() {
        doble n = new doble();
        n.dato = leer("dato para el nuevo nodo ");
        n.sgte = null;
        n.ant = null;
        return(n);
    }
    public static int leer(String f) {
        int j;
        System.out.print(f);
        j = entrada.nextInt();
        return(j);
    }
}