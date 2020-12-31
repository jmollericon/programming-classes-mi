package ejercicio6;
public class mainEmpleado {
    public static void main(String[] args) {

        // CASO MANTENIMIENTO
        Mantenimiento man = new Mantenimiento("Juan Perez", "3465178 LP", "Economía", 5000, 4, 8);
        System.out.println("Salario Mantenimiento: ");
        man.mostrar();
        System.out.println("\tSalario: "+man.calcularSalario()+"Bs.");
        // CASO RECURSOS HUMANOS
        RecursosHumanos rrhh = new RecursosHumanos("Carla Chuquimia", "3456231 SC", "Ingeniería", 5000, "Secretaria");
        System.out.println("Salario Recursos Humanos: ");
        rrhh.mostrar();
        System.out.println("\tSalario: "+rrhh.calcularSalario()+"Bs.");
        // CASO PROFESOR TIEMPO COMPELTO
        ProfesorTiempoCompleto ptc = new ProfesorTiempoCompleto("Mario Fernandez", "2134567 CB", "Derecho", 5.8, 10000, 32); // licenciado
        System.out.println("Salario Profesor Tiempo Completo: ");
        ptc.mostrar();
        System.out.println("\tSalario: "+ptc.calcularSalario()+"Bs.");
        // CASO PROFESOR HORA CATEDRA
        ProfesorHoraCatedra phc = new ProfesorHoraCatedra("Luis Mendoza", "3678980 LP", "Ingenieria", 4.3, 320); // 320 horas
        System.out.println("Salario Profesor Hora Catedra: ");
        phc.mostrar();
        System.out.println("\tSalario: "+phc.calcularSalario()+"Bs.");        
    }
}
