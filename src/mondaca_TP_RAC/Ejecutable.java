package mondaca_TP_RAC;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class Ejecutable {
    static ArrayList<Cliente> listClien = new ArrayList();
    static ArrayList<Auto> listAuto = new ArrayList();
    static ArrayList<Reserva> listReser = new ArrayList();
    static Scanner tec = new Scanner(System.in);
    static Registro reg = new Registro();
    public static void main(String[] args) {
        cargaObjetos();
        menu();
    }
    
    public static void menu() {
        boolean a = true;
        while (a) {
            int x;
            System.out.println("------------MENU------------");
            System.out.println("1 - Ver datos actuales");
            System.out.println("2 - Ingresar nuevos datos");
            System.out.println("0 - CERRAR");
            System.out.println("----------------------------");
            x = tec.nextInt();
            tec.nextLine();
            switch (x) {
                case 0: a = false;
                break;
                case 1: menuDatos();
                break;
                case 2: menuNuevo();
                break;
                default: System.out.println("Seleccione una opcion.");
                break;
            }
        }
    }
    public static void menuDatos() {
        boolean a = true;
        while (a) {
            int x;
            System.out.println("------Datos------");
            System.out.println("1 - Reservas");
            System.out.println("2 - Clientes");
            System.out.println("3 - Autos");
            System.out.println("0 - SALIR");
            System.out.println("-----------------");
            x = tec.nextInt();
            tec.nextLine();
            switch (x) {
                case 0: a = false;
                break;
                case 1: reg.mostrarReservas();
                break;
                case 2: reg.mostrarClientes();
                break;
                case 3: reg.mostrarAutos();
                break;
                default: System.out.println("Seleccione una opcion.");
                break;
            }
        }
    }
    public static void menuNuevo() {
        boolean a = true;
        while (a) {
            int x;
            System.out.println("------INGRESAR------");
            System.out.println("1 - Reserva");
            System.out.println("2 - Cliente");
            System.out.println("3 - Auto");
            System.out.println("0 - SALIR");
            System.out.println("--------------------");
            x = tec.nextInt();
            tec.nextLine();
            System.out.println("--------------------");
            switch (x) {
                case 0: a = false;
                break;
                case 1: reg.crearReserva();
                break;
                case 2: reg.crearCliente();
                break;
                case 3: reg.crearAuto();
                break;
                default: System.out.println("Seleccione una opcion.");
                break;
            }
        }
    }
    
    public static void cargaObjetos() {
        Direccion d1 = new Direccion("Bolivar", 751, "San Francisco", "");
        Cliente c1 = new Cliente("Rodrigo Ramirez", 41851756, d1, 1145839157L);
        Direccion d2 = new Direccion("Mitre", 1395, "California", "3P");
        Cliente c2 = new Cliente("Gaston Escobar", 39954816, d2, 3364951486L);
        Direccion d3 = new Direccion("Av. Sabio", 348, "San Francisco", "7P");
        Cliente c3 = new Cliente("Franco Deatriz", 43951785, d3, 1754858912L);
        Direccion d4 = new Direccion("Juncal", 984, "San Martin", "");
        Cliente c4 = new Cliente("Julieta Tijeras", 41984298, d4, 2874158268L);
        Auto a1 = new Auto("Civic", "Honda", "Blanco", 23000, false);
        Auto a2 = new Auto("Fiesta", "Ford", "Rojo", 21000, true);
        Auto a3 = new Auto("Versa", "Nissan", "Azul", 18000, true);
        Auto a4 = new Auto("Onix", "Chevrolet", "Negro", 20000, false);
        Auto a5 = new Auto("Ranger", "Ford", "Azul Marino", 27000, false);
        Auto a6 = new Auto("Golf", "Volkswagen", "Gris", 19000, false);
        Auto a7 = new Auto("Civic", "Honda", "Negro", 24000, true);
        Auto a8 = new Auto("Cruze", "Chevrolet", "Blanco", 22000, false);
        Reserva r1 = new Reserva(c1, LocalDate.of(2022, 10, 20), 7);
        r1.agregarAuto(a7);
        Reserva r2 = new Reserva(c2, LocalDate.of(2022, 11, 1), 14);
        r2.agregarAuto(a4);
        r2.agregarAuto(a3);
        reg.agregarCliente(c1);
        reg.agregarCliente(c2);
        reg.agregarCliente(c3);
        reg.agregarCliente(c4);
        reg.agregarAuto(a1);
        reg.agregarAuto(a2);
        reg.agregarAuto(a3);
        reg.agregarAuto(a4);
        reg.agregarAuto(a5);
        reg.agregarAuto(a6);
        reg.agregarAuto(a7);
        reg.agregarAuto(a8);
        reg.agregarReserva(r1);
        reg.agregarReserva(r2);
    }
}