package listas_circulares;

import java.util.Scanner;

public class CirculoMonedas {

    public static class circular {
        String dato;
        circular sgte, ant;
    }

    public static Scanner entrada; /* Para leer las entradas desde teclado */
    public static circular lista_juego = null; /* Lista Circular, Base del juego */
    public static boolean jugar = true;	/* Para intercalar el turno entre los jugadores */

    public static void main(String[] args) {
        entrada = new Scanner(System.in);
        String resultado = ""; 	/* Se indica el ganador del juego */

        iniciar_juego(); /* Función Iniciar el juego (condiciones iniciales) */
        listar_monedas("\nBIENVENIDOS AL JUEGO 'EL CIRCULO DE MONEDAS'\n=========== == ===== === ======= == ========", lista_juego); /* Función Mostrar estado del juego, despliega la lista circular */

        while(resultado == "") { /* Mientras 'resultado' no indique quien es el ganador se continua con el juego */
            if(jugar) { /* La variable 'jugar' permite intercalar los turnos entre ambos jugadores */
                /* Tuno del JUGADOR 1 */
                ejecutar_turno("Turno JUGADOR 1:"); /* Función para ejecutar el turno (sacar una o dos monedas) */
            } else {
                /* Tuno del JUGADOR 2 */
                ejecutar_turno("Turno JUGADOR 2:"); /* Función para ejecutar el turno (sacar una o dos monedas) */
            }
            jugar = !jugar;
            listar_monedas("\nESTADO DEL JUEGO\n====== === =====", lista_juego); /* Función Mostrar estado del juego, despliega la lista circular */
            System.out.println();
            resultado = verificar_ganador(); /* Función que verifica si ya existe un ganador */
        }
        System.out.println("\nRESULTADO: El ganador es el " + resultado); /* Termina el juego y se muestra al ganador */
    }
    public static void iniciar_juego() {
        /* Se ponen 12 monedas en un círculo, dato por defecto "m" */
        for(int i=0; i<12; i++) {
            circular copia;
            circular nuevo = new circular();
            //nuevo.dato = "m"+(i+1); /* Dato por defecto (m: moneda)*/
            nuevo.dato = "m"; /* Dato por defecto (m: moneda)*/
            nuevo.sgte = nuevo;
            nuevo.ant = nuevo;
            if(lista_juego == null) {
                lista_juego = nuevo;
            }else {
                copia = lista_juego;
                while (copia.sgte != lista_juego.ant) {
                    copia = copia.sgte;
                }

                nuevo.sgte = lista_juego;
                nuevo.ant = copia;

                //copia.sgte = nuevo.ant;
                //copia.ant = nuevo.sgte;
                copia.sgte = nuevo;
                if(i==11)
                    copia.sgte.ant = copia;
                    //lista_juego.ant = copia.sgte.sgte;

                //System.out.println("i = " + i);
                //System.out.println("Data anterior " + copia.ant.dato);
                //System.out.println("Data actual " + copia.dato);
                //System.out.println("Data siguiente " + copia.sgte.dato);
                //System.out.println("Data siguiente  sig " + copia.sgte.sgte.dato);
            }
        }

        //System.out.println("Data anterior " + aux.ant.dato);
        //System.out.println("Data actual " + aux.dato);
        //System.out.println("Data siguiente " + aux.sgte.dato);
        //System.out.println("Data siguiente  sig " + copia.sgte.sgte.dato);
    }

    public static void ejecutar_turno(String m) {
        /* Función que permite ejecutar el turno (sacar una o dos monedas) */
        int op;
        circular cab = null;
        do {
            op = menu_ejecutar_turno(m);
            switch(op){
                case 1:
                    /* Sacar una moneda */
                    sacar_una_moneda(); /* Función que permite que el jugador saque una moneda */
                    break;
                case 2:
                    /* Sacar dos monedas */
                    sacar_dos_monedas(); /* Función que permite que el jugador saque dos monedas */
                    break;
            }
        }while(op<1 || op>2);
    }

    public static void sacar_una_moneda() {
        int pos_moneda = 0;
        do {
            System.out.println("Ingrese la posición de la moneda a sacar.");
            System.out.print("Posición: ");
            pos_moneda = entrada.nextInt(); /* Lectura la posición de la moneda a sacar */
        } while(pos_moneda<1 || pos_moneda>12); /* Debe estar entre 1 y 12 (posición) */

        if(verificar_estado_moneda_posicion(pos_moneda)) { /* Se verifica que en la posición elejida si exista una moneda */
            /* La moneda está disponible para sacar */
            sacar_moneda_posicion(pos_moneda); /* Función que saca la moneda ubicada en la posición pos_moneda */
            System.out.println("La moneda se saco correctamente!");
        } else {
            /* La moneda ya fué sacada */
            System.out.println("LA MONEDA SELECCIONADA YA FUÉ SACADA.\nElija otra opción!");
            jugar = !jugar; /* Para que el jugador repita su turno, hasta que haga una jugada válida */
        }
    }

    public static void sacar_dos_monedas() {
        int pos_moneda_uno = 0;
        int pos_moneda_dos = 0;

        /* Leer posición de la primera moneda a sacar */
        do {
            System.out.println("Ingrese la posición de la PRIMERA moneda a sacar.");
            //System.out.println("(considerar: pos_moneda_dos = pos_moneda_uno + 1)");
            System.out.print("Posición: ");
            pos_moneda_uno = entrada.nextInt();  /* Lectura la posición de la primera moneda a sacar */
        } while(pos_moneda_uno<1 || pos_moneda_uno>12); /* Debe estar entre el 1 y 12 (posición) */

        /* Leer posición de la segunda moneda a sacar */
        int izq_der = 0;
        do {
            System.out.println("La posición de la segunda moneda es ?\n1. Izquierda\n2. Derecha");
            System.out.print("Opción: ");
            izq_der = entrada.nextInt();  /* Lectura la posición de la primera moneda a sacar */
        } while(izq_der<1 || izq_der>2); /* Debe estar entre el 1 y 2 (opción izq o der) */
        if(izq_der == 1) {
            pos_moneda_dos = pos_moneda_uno - 1;
            if(pos_moneda_uno == 1){
                pos_moneda_dos = 12;
            }
        } else {
            pos_moneda_dos = pos_moneda_uno + 1;
            if(pos_moneda_uno == 12) {
                pos_moneda_dos = 1;
            }
        }

        if(verificar_estado_moneda_posicion(pos_moneda_uno)) {
            if(verificar_estado_moneda_posicion(pos_moneda_dos)) {
                /* La moneda está disponible para sacar */
                sacar_dos_monedas_posicion(pos_moneda_uno, izq_der);
                //sacar_moneda_posicion(pos_moneda_uno); /* Función que saca la moneda ubicada en la posición pos_moneda_uno */
                //sacar_moneda_posicion(pos_moneda_dos); /* Función que saca la moneda ubicada en la posición pos_moneda_dos */
                System.out.println("Las monedas se sacaron correctamente!");
            } else {
                /* La segunda moneda seleccionada ya fué sacada */
                System.out.println("LA SEGUNDA MONEDA SELECCIONADA YA FUÉ SACADA.\nElija otra opción!");
                jugar = !jugar; /* Para que el jugador repita su turno, hasta que haga una jugada válida */
            }
        } else {
            /* La primer moneda seleccionada ya fué sacada */
            System.out.println("LA PRIMERA MONEDA SELECCIONADA YA FUÉ SACADA.\nElija otra opción!");
            jugar = !jugar; /* Para que el jugador repita su turno, hasta que haga una jugada válida */
        }
    }

    public static boolean verificar_estado_moneda_posicion(int p) {
        /* La función verifica si existe una moneda en la posicion p */
        int c = 1;
        if(lista_juego != null) {
            circular copia = lista_juego;
            do {
                if(c == p) {
                    if(copia.dato == "m") {
                        return true;
                    } else {
                        return false;
                  }
                }
                copia = copia.sgte;
                c++;
            }while(copia.sgte != lista_juego.ant.sgte);
        }else {
            return false;
        }
        return true;
    }
    public static boolean sacar_moneda_posicion(int p) {
        /* La función saca la moneda de la posicion p */
        int c = 1;
        if(lista_juego != null) {
            circular copia = lista_juego;
            do {
                if(c == p) {
                    copia.dato = "-";
                }
                copia = copia.sgte;
                c++;
            }while(copia.sgte != lista_juego.ant.sgte);
        }else {
            return false;
        }
        return true;
    }

    public static boolean sacar_dos_monedas_posicion(int p, int izq_der) {
        /* La función saca la moneda de la posicion p */
        int c = 1;
        if(lista_juego != null) {
            circular copia = lista_juego;
            do {
                if(c == p) {
                    copia.dato = "-";
                    if(izq_der == 1) { /* eliminar de la IZQUIERDA */
                        copia.ant.dato = "-";
                    } else { /* eliminar de la DERECHA */
                        copia.sgte.dato = "-";
                    }
                }
                copia = copia.sgte;
                c++;
            }while(copia.sgte != lista_juego.ant.sgte);
        }else {
            return false;
        }
        return true;
    }

    public static void listar_monedas(String string, circular cab) {
        /* La función lista todas las monedas ("m": existe la moneda ó "-": la moneda ya fué sacada )*/
        System.out.println(string);
        System.out.print("MONDEDAS\nEstado:\t\t");
        if(cab!=null) {
            circular copia = cab;
            do {
                System.out.print(copia.dato+"\t");
                copia = copia.sgte;
            } while(copia.sgte != cab.ant.sgte);
        }else {
            System.out.println("Lista Circular Vacía");
        }
        System.out.println();
        System.out.print("Posición:\t");
        for(int i=1; i<=12; i++){
            System.out.print(i+"\t");
        }
    }

    public static int menu_ejecutar_turno(String m) {
        System.out.println("\n"+m+"\n==== ====== ==\nElija una opción:\n  1. Sacar una moneda.\n  2. Sacar dos monedas.");
        System.out.print("Opcion: ");
        return entrada.nextInt();
    }

    public static String verificar_ganador() {
        /* La función verifica si existe un ganador */
        int c = 0;
        if(lista_juego != null) {
            circular copia = lista_juego;
            do {
                if(copia.dato == "m") {
                     c++;
                }
                copia = copia.sgte;
            }while(copia.sgte != lista_juego.ant.sgte);
        }
        /* Si no hay ya ni una moneda (ya no hay "m") entonces sacaron todas la monedas
        * Y el ultimo jugador que saco la/s moneda/s es el ganador */
        if(c==0){
            if(!jugar){
                return "JUGADOR 1.";
            } else {
                return "JUGADOR 2.";
            }
        }
        return "";
    }
}