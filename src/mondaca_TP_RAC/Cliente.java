package mondaca_TP_RAC;
import java.util.ArrayList;
public class Cliente {
    private static int nroCliente = 0;
    private int id;
    private String nombre;
    private int dni;
    private Direccion direccion;
    private long telefono;
    
    public Cliente() {
        this.direccion = new Direccion();
    }
    public Cliente(String n, int d, Direccion dir, long t){
        nroCliente++;
        this.id = nroCliente;
        this.nombre = n;
        this.dni = d;
        this.direccion = dir;
        this.telefono = t;
    }
    
    public void mostrarCliente() {
        System.out.println("    |-CLIENTE-|");
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Dni: " + this.dni);
        this.direccion.mostrarDireccion();
        System.out.println("Telefono: " + this.telefono);
    }

    public static int getNroCliente() {
        return nroCliente;
    }

    public static void setNroCliente(int nroCliente) {
        Cliente.nroCliente = nroCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    
}
