package examen;
import java.util.Scanner;
public class JuegoFichas {
    public static class doble {
        int dato;
        doble sgte, ant;
    }
    public static Scanner entrada;
    static doble lista_jugador_1i = null, lista_jugador_1d = null; /* Lista jugador 1 */
    static doble lista_jugador_2i = null, lista_jugador_2d = null; /* Lista jugador 2 */
    static int v1 = 0, v2 = 0;	/* Contadores de 1's de 2's para las respectivas listas */
    public static void main(String[] args) {
        entrada = new Scanner(System.in);
        String resultado = ""; 	/* Se indica el ganador del juego */
        boolean jugar = true;	/* Para intercalar el turno entre los jugadores */

        iniciar_juego(); /* Función Iniciar el juego (condiciones iniciales) */
        controlar_estado_juego(); /* Función Mostrar estado del juego */

        while(resultado == "") {/* Mientras 'resultado' no indique quien es el ganador se continua con el juego */
            if(jugar) { /* variable jugar permite intercalar los turnos en ambos jugadores */
                jugar = false;
                System.out.println("\n\nTurno JUGADOR 1:");
            } else {
                jugar = true;
                System.out.println("\n\nTurno JUGADOR 2:");
            }
            ejecutar_turno(); /* Función para ejecutar el turno (borrar dos numeros) */
            controlar_estado_juego(); /* Función Mostrar estado del juego */

            /* Verificar Ganador */
            if(v1 == 1) { /* Si solo queda un 1 entonces el ganador es el jugador 1 */
                resultado = "El ganador es el JUGADOR 1"; /* Describe al ganador */
            }
            if(v2 == 1) { /* Si solo queda un 2 entonces el ganador es el jugador 2 */
                resultado = "El ganador es el JUGADOR 2"; /* Describe al ganador */
            }
            System.out.println();
        }
        System.out.println("\nRESULTADO: " + resultado); /* Termina el juego y se muestra al ganador */
    }
    public static void ejecutar_turno() {
        /* Función que permite ejecutar el turno (borrar dos numeros cualesquiera) */
        int op;
        doble aux;
        do {
            opciones_turno(); /* Función que despliega las opciones de eliminar */
            op = leer("Su opción es: "); /* Se lee la opción a ejecutar */
            switch (op){
                case 1: /* CASO: Eliminar dos 1's */
                    /*if(v1 == 2) {
                        System.out.println("No se puede ejecutar la jugada, solo quedan dos 1's");
                        op = 0; /* Otra vez su turno */
                        /*break;
                    }*/
                    lista_jugador_1d = borrar_cabecera_derecha(lista_jugador_1d); /* Se elimina un 1 de la lista de 1's */
                    lista_jugador_1d = borrar_cabecera_derecha(lista_jugador_1d); /* Se elimina un 1 de la lista de 1's */
                    if(lista_jugador_1d == null) {
                        lista_jugador_1i = null;
                    }
                    /* Números identicos, entonces se agrega un 2 en la lista de 2's */
                    aux = nuevo_valor(2);
                    if (lista_jugador_2i == null) { /* Si la lista está vacia, se agrega como primer elemento */
                        lista_jugador_2i = aux;
                        lista_jugador_2d = aux;
                    } else { /* Si la lista no está vacia, se agrega a la derecha el elemento correspondiente */
                        lista_jugador_2d = add_der(lista_jugador_2d, aux);
                    }
                    break;
                case 2: /* CASO: Eliminar dos 2's */
                    lista_jugador_2d = borrar_cabecera_derecha(lista_jugador_2d); /* Se elimina un 2 de la lista de 2's */
                    lista_jugador_2d = borrar_cabecera_derecha(lista_jugador_2d); /* Se elimina un 2 de la lista de 2's */
                    if(lista_jugador_2d == null) {
                        lista_jugador_2i = null;
                    }
                    /* Números identicos, entonces se agrega un 2 en la lista de 2's */
                    aux = nuevo_valor(2);
                    if (lista_jugador_2i == null) { /* Si la lista está vacia, se agrega como primer elemento */
                        lista_jugador_2i = aux;
                        lista_jugador_2d = aux;
                    } else { /* Si la lista no está vacia, se agrega a la derecha el elemento correspondiente */
                        lista_jugador_2d = add_der(lista_jugador_2d, aux);
                    }
                    break;
                case 3: /* CASO: Eliminar un 1 y un 2 */
                    lista_jugador_1d = borrar_cabecera_derecha(lista_jugador_1d); /* Se elimina un 1 de la lista de 1's */
                    lista_jugador_2d = borrar_cabecera_derecha(lista_jugador_2d); /* Se elimina un 2 de la lista de 2's */
                    /* Números diferentes, entonces se agrega un 1 en la lista de 1's */
                    aux = nuevo_valor(1);
                    if (lista_jugador_1i == null) { /* Si la lista está vacia, se agrega como primer elemento */
                        lista_jugador_1i = aux;
                        lista_jugador_1d = aux;
                    } else { /* Si la lista no está vacia, se agrega a la derecha el elemento correspondiente */
                        lista_jugador_1d = add_der(lista_jugador_1d, aux);
                    }
                    break;
            }
        } while(op<1 || op>3); /* Se deben ingreser valores entre 1 y 3 */
    }
    public static void opciones_turno() {
	/* Funció que despliega las opciones de borrar que están permitido en el juego */
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
            aux = nuevo_valor(1); /* 2 -> valor para inicializar la lista de 1's */
            if (lista_jugador_1i == null) { /* Si la lista está vacia, se agrega como primer elemento */
                lista_jugador_1i = aux;
                lista_jugador_1d = aux;
            } else { /* Si la lista no está vacia, se agrega a la derecha el elemento correspondiente */
                lista_jugador_1d = add_der(lista_jugador_1d, aux);
            }
            /* Diez números 2's - Jugador 2 */
            aux = nuevo_valor(2);/* 2 -> valor para inicializar la lista de 2's */
            if (lista_jugador_2i == null) { /* Si la lista está vacia, se agrega como primer elemento */
                lista_jugador_2i = aux;
                lista_jugador_2d = aux;
            } else { /* Si la lista no está vacia, se agrega a la derecha el elemento correspondiente */
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
	/* Función que va contando la cantidad de lementos de una lista 
	conteo de izquierda a derecha */
        int c=0;
        while(ca!=null) { /* Mientras no se llegue al final de la lista se avanza al siguiente */
            c++;	/* Contador de cantidad de elementos en la lista */
            ca = ca.sgte;
        }
        return c;
    }
    public static doble borrar_cabecera_derecha(doble cabd) {
	/* Función que permite borrar la cabecera derecha de una lista */
        if(cabd==null || cabd.ant==null){ /* Si no hay elemento se retorna null */
            return null;
        }
        cabd = cabd.ant; /* proceso de eliminar cabecera derecha */
        cabd.sgte = null;
        return cabd;
    }
    public static void listado_der_iz(String texto, doble ca) {
	/* Función que permite listar toda la lista de derecha a izquierda */
        System.out.println("\n"+texto);
        while(ca!=null) { /* Mientras no se llegue al final de la lista se avanza al siguiente */
            System.out.print(ca.dato+"\t");
            ca = ca.ant;
        }
    }
    public static void listado_iz_der(String texto, String cantidad, doble ca) {
	/* Función que permite listar toda la lista de izquierda a derecha */
        System.out.println("\n"+texto);
        System.out.print("Hay "+cantidad+":\t");
        while(ca!=null) { /* Mientras no se llegue al final de la lista se avanza al siguiente */
            System.out.print(ca.dato+"\t");
            ca = ca.sgte;
        }
    }
    public static doble add_iz(doble c, doble nue) {
	/* Función que adiciona un elemento a la izquierda */
        nue.sgte = c;
        c.ant = nue;
        c = nue;
        return(c);
    }
    public static doble add_der(doble c, doble nue) {
	/* Función que adiciona un elemento a la derecha */
        c.sgte = nue;
        nue.ant = c;
        c = nue;
        return(c);
    }
    public static doble nuevo_valor(int valor) {
	/* Función que crear el primer elemento de la lista con 'valor' */
        doble n = new doble();
        n.dato = valor;
        n.sgte = null;
        n.ant = null;
        return(n);
    }
    public static doble nuevo() {
	/* Función que crear el primer elemento de la lista con valor introducido por teclado */
        doble n = new doble();
        n.dato = leer("dato para el nuevo nodo ");
        n.sgte = null;
        n.ant = null;
        return(n);
    }
    public static int leer(String f) {
	/* Función que permite leer datos de teclado */
        int j;
        System.out.print(f);
        j = entrada.nextInt();
        return(j);
    }
}
