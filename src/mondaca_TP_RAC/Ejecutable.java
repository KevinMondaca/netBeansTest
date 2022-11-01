package mondaca_TP_RAC;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class Ejecutable {
    static ArrayList<Cliente> listClien = new ArrayList();
    static ArrayList<Auto> listAuto = new ArrayList();
    static ArrayList<Reserva> listReser = new ArrayList();
    static Scanner tec = new Scanner(System.in);
    public static void main(String[] args) {
        objetos();
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
                case 1: reservas();
                break;
                case 2: clientes();
                break;
                case 3: autos();
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
                case 1: nuevoReserva();
                break;
                case 2: nuevoCliente();
                break;
                case 3: nuevoAuto();
                break;
                default: System.out.println("Seleccione una opcion.");
                break;
            }
        }
    }
    
    public static void reservas() {
        boolean a = true;
        while(a) {
            int r;
            System.out.println("----------RESERVAS----------");
            for (Reserva x: listReser) {
                System.out.println((listReser.indexOf(x)+1) + " | " + x.getCliente().getNombre() + ":");
                for (Auto y: x.getAutos()) {
                    System.out.println("        " + y.getMarca() + " " + y.getModelo());
                }
            }
            System.out.println("0 - SALIR");
            System.out.println("----------------------------");
            r = tec.nextInt();
            tec.nextLine();
            if (r == 0) {
                a = false;
            } else if (r > 0 && r <= listReser.size()) {
                listReser.get(r-1).mostrarReserva();
            } else {
                System.out.println("----------------------------");
                System.out.println("Seleccione una opcion.");
            }
        }
    }
    public static void clientes() {
        boolean a = true;
        while(a) {
            int c;
            System.out.println("-------CLIENTES-------");
            for (Cliente x: listClien) {
                System.out.println((listClien.indexOf(x)+1) + " | " + x.getNombre() + " - " + x.getDni());
            }
            System.out.println("0 - SALIR");
            System.out.println("----------------------");
            c = tec.nextInt();
            tec.nextLine();
            if (c == 0) {
                a = false;
            } else if (c > 0 && c <= listClien.size()) {
                System.out.println("----------------------");
                listClien.get(c-1).mostrarCliente();
            } else {
                System.out.println("----------------------");
                System.out.println("Seleccione una opcion.");
            }
        }
    }
    public static void autos() {
        boolean b = true;
        while(b) {
            int a;
            System.out.println("-------------Autos-------------");
            for (Auto x: listAuto) {
                if (x.isReservado()) {
                    System.out.println((listAuto.indexOf(x)+1) + " | " + x.getMarca() + " " + x.getModelo() + " - " + x.getMatricula() + " (RESERVADO)");
                } else {
                    System.out.println((listAuto.indexOf(x)+1) + " | " + x.getMarca() + " " + x.getModelo() + " - " + x.getMatricula());
                }
            }
            System.out.println("0 - SALIR");
            System.out.println("-------------------------------");
            a = tec.nextInt();
            tec.nextLine();
            if (a == 0) {
                b = false;
            } else if (a > 0 && a <= listAuto.size()) {
                System.out.println("-------------------------------");
                listAuto.get(a-1).mostrarAuto();
            } else {
                System.out.println("-------------------------------");
                System.out.println("Seleccione una opcion.");
            }
        }
    }
    
    public static Reserva nuevoReserva() {
        Reserva r1 = new Reserva();
        boolean b1 = true;
        while (b1) {
            int x;
            System.out.println("1 - Seleccionar cliente");
            System.out.println("2 - Ingresar nuevo cliente");
            x = tec.nextInt();
            tec.nextLine();
            if (x == 1) {
                boolean bc = true;
                while(bc) {
                    int c;
                    System.out.println("-------CLIENTES-------");
                    for (Cliente y: listClien) {
                        System.out.println((listClien.indexOf(y)+1) + " | " + y.getNombre() + " - " + y.getDni());
                    }
                    System.out.println("0 - CANCELAR");
                    System.out.println("----------------------");
                    c = tec.nextInt();
                    tec.nextLine();
                    if (c == 0) {
                        bc = false;
                    } else if (c > 0 && c <= listClien.size()) {
                        System.out.println("----------------------");
                        r1.setCliente(listClien.get(c-1));
                        bc = false;
                        b1 = false;
                    } else {
                        System.out.println("----------------------");
                        System.out.println("Seleccione una opcion.");
                    }
                }
            } else if (x == 2) {
                r1.setCliente(nuevoCliente());
                b1 = false;
            } else {
                System.out.println("----------------------");
                System.out.println("Seleccione una opcion.");
            }
        }
        boolean b2 = true;
        while (b2) {
            int x;
            System.out.println("1 - Seleccionar auto");
            System.out.println("2 - Ingresar nuevo auto");
            x = tec.nextInt();
            tec.nextLine();
            if (x == 1) {
                boolean ba = true;
                while(ba) {
                    int y;
                    System.out.println("-------------Autos-------------");
                    for (Auto a: listAuto) {
                        if (!a.isReservado()) {
                            System.out.println((listAuto.indexOf(a)+1) + " | " + a.getMarca() + " " + a.getModelo() + " - " + a.getMatricula());
                        }
                    }
                    System.out.println("0 - CANCELAR");
                    System.out.println("-------------------------------");
                    y = tec.nextInt();
                    tec.nextLine();
                    if (y == 0) {
                        ba = false;
                    } else if (y > 0 && y <= listAuto.size()) {
                        System.out.println("-------------------------------");
                        listAuto.get(y-1).setReservado(true);
                        r1.agregarAuto(listAuto.get(y-1));
                        ba = false;
                    } else {
                        System.out.println("-------------------------------");
                        System.out.println("Seleccione una opcion.");
                    }
                }
            } else if (x == 2) {
                r1.agregarAuto(nuevoAuto());
            } else {
                System.out.println("-------------------------------");
                System.out.println("Seleccione una opcion.");
            }
            int z;
            System.out.println("¿Agregar otro Auto?");
            System.out.println("1 - SI");
            System.out.println("2 - NO");
            System.out.println("-------------------------------");
            z = tec.nextInt();
            tec.nextLine();
            if (z == 1) {
                b2 = true;
            } else if (z == 2) {
                b2 = false;
            } else {
                System.out.println("-------------------------------");
                System.out.println("Seleccione una opcion.");
            }
        }
        for (Auto a: r1.getAutos()) {
            for (Auto v: listAuto) {
                if (a.getMatricula().equals(v.getMatricula())){
                    listAuto.get(listAuto.indexOf(v)).setReservado(true);
                }
            }
        }
        r1.setFechaInicio(LocalDate.now());
        System.out.println("-------------------------------");
        System.out.println("Ingrese los dias de la reserva:");
        r1.setTiempoAlquiler(tec.nextInt());
        tec.nextLine();
        listReser.add(r1);
        return r1;
    }
    public static Cliente nuevoCliente() {
        Cliente c1 = new Cliente();
        System.out.println("Ingrese los datos del cliente");
        System.out.println("Nombre:");
        c1.setNombre(tec.nextLine());
        System.out.println("DNI:");
        c1.setDni(tec.nextInt());
        tec.nextLine();
        System.out.println("Telefono:");
        c1.setTelefono(tec.nextLong());
        tec.nextLine();
        System.out.println("-Direccion-");
        System.out.println("Calle:");
        c1.getDireccion().setCalle(tec.nextLine());
        System.out.println("Altura:");
        c1.getDireccion().setAltura(tec.nextInt());
        tec.nextLine();
        System.out.println("Barrio:");
        c1.getDireccion().setBarrio(tec.nextLine());
        System.out.println("Piso del departamento:");
        c1.getDireccion().setPisoDto(tec.nextLine());
        listClien.add(c1);
        return c1;
    }
    public static Auto nuevoAuto() {
        Auto a1 = new Auto();
        System.out.println("Ingrese los datos del auto");
        System.out.println("Matrucula:");
        a1.setMatricula(tec.nextLine());
        System.out.println("Marca:");
        a1.setMarca(tec.nextLine());
        System.out.println("Modelo:");
        a1.setModelo(tec.nextLine());
        System.out.println("Color:");
        a1.setColor(tec.nextLine());
        System.out.println("Precio/dia:");
        a1.setPrecio(tec.nextDouble());
        tec.nextLine();
        a1.setReservado(false);
        listAuto.add(a1);
        return a1;
    }
    
    public static void objetos() {
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
        listClien.add(c1);
        listClien.add(c2);
        listClien.add(c3);
        listClien.add(c4);
        listAuto.add(a1);
        listAuto.add(a2);
        listAuto.add(a3);
        listAuto.add(a4);
        listAuto.add(a5);
        listAuto.add(a6);
        listAuto.add(a7);
        listAuto.add(a8);
        listReser.add(r1);
        listReser.add(r2);
    }
}
