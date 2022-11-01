package modelo;
import modelo.Reserva;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import modelo.Auto;
import modelo.Cliente;
public class Registro {
    private ArrayList<Cliente> listCliente = new ArrayList();
    private ArrayList<Auto> listAuto = new ArrayList();
    private ArrayList<Reserva> listReserva = new ArrayList();
    private static Scanner tec = new Scanner(System.in);
    
    public Registro(){
    }
    
    public void agregarCliente(Cliente c) {
        this.listCliente.add(c);
    }
    public void agregarAuto(Auto a) {
        this.listAuto.add(a);
    }
    public void agregarReserva(Reserva r) {
        this.listReserva.add(r);
    }
    
    public void mostrarReservas() {
        boolean a = true;
        while(a) {
            int r;
            System.out.println("----------RESERVAS----------");
            for (Reserva x: this.listReserva) {
                System.out.println((this.listReserva.indexOf(x)+1) + " | " + x.getCliente().getNombre() + ":");
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
            } else if (r > 0 && r <= this.listReserva.size()) {
                this.listReserva.get(r-1).mostrarReserva();
            } else {
                System.out.println("----------------------------");
                System.out.println("Seleccione una opcion.");
            }
        }
    }
    public void mostrarClientes() {
        boolean a = true;
        while(a) {
            int c;
            System.out.println("-------CLIENTES-------");
            for (Cliente x: this.listCliente) {
                System.out.println((this.listCliente.indexOf(x)+1) + " | " + x.getNombre() + " - " + x.getDni());
            }
            System.out.println("0 - SALIR");
            System.out.println("----------------------");
            c = tec.nextInt();
            tec.nextLine();
            if (c == 0) {
                a = false;
            } else if (c > 0 && c <= this.listCliente.size()) {
                System.out.println("----------------------");
                this.listCliente.get(c-1).mostrarCliente();
            } else {
                System.out.println("----------------------");
                System.out.println("Seleccione una opcion.");
            }
        }
    }
    public void mostrarAutos() {
        boolean b = true;
        while(b) {
            int a;
            System.out.println("-------------Autos-------------");
            for (Auto x: this.listAuto) {
                if (x.isReservado()) {
                    System.out.println((this.listAuto.indexOf(x)+1) + " | " + x.getMarca() + " " + x.getModelo() + " - " + x.getMatricula() + " (RESERVADO)");
                } else {
                    System.out.println((this.listAuto.indexOf(x)+1) + " | " + x.getMarca() + " " + x.getModelo() + " - " + x.getMatricula());
                }
            }
            System.out.println("0 - SALIR");
            System.out.println("-------------------------------");
            a = tec.nextInt();
            tec.nextLine();
            if (a == 0) {
                b = false;
            } else if (a > 0 && a <= this.listAuto.size()) {
                System.out.println("-------------------------------");
                this.listAuto.get(a-1).mostrarAuto();
            } else {
                System.out.println("-------------------------------");
                System.out.println("Seleccione una opcion.");
            }
        }
    }
    
    public Reserva crearReserva() {
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
                    for (Cliente y: this.listCliente) {
                        System.out.println((this.listCliente.indexOf(y)+1) + " | " + y.getNombre() + " - " + y.getDni());
                    }
                    System.out.println("0 - CANCELAR");
                    System.out.println("----------------------");
                    c = tec.nextInt();
                    tec.nextLine();
                    if (c == 0) {
                        bc = false;
                    } else if (c > 0 && c <= this.listCliente.size()) {
                        System.out.println("----------------------");
                        r1.setCliente(this.listCliente.get(c-1));
                        bc = false;
                        b1 = false;
                    } else {
                        System.out.println("----------------------");
                        System.out.println("Seleccione una opcion.");
                    }
                }
            } else if (x == 2) {
                r1.setCliente(crearCliente());
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
                    for (Auto a: this.listAuto) {
                        if (!a.isReservado()) {
                            System.out.println((this.listAuto.indexOf(a)+1) + " | " + a.getMarca() + " " + a.getModelo() + " - " + a.getMatricula());
                        }
                    }
                    System.out.println("0 - CANCELAR");
                    System.out.println("-------------------------------");
                    y = tec.nextInt();
                    tec.nextLine();
                    if (y == 0) {
                        ba = false;
                    } else if (y > 0 && y <= this.listAuto.size()) {
                        System.out.println("-------------------------------");
                        this.listAuto.get(y-1).setReservado(true);
                        r1.agregarAuto(this.listAuto.get(y-1));
                        ba = false;
                    } else {
                        System.out.println("-------------------------------");
                        System.out.println("Seleccione una opcion.");
                    }
                }
            } else if (x == 2) {
                r1.agregarAuto(crearAuto());
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
        agregarReserva(r1);
        return r1;
    }
    public Cliente crearCliente() {
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
        agregarCliente(c1);
        return c1;
    }
    public Auto crearAuto() {
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
        agregarAuto(a1);
        return a1;
    }
}