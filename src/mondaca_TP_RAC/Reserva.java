package mondaca_TP_RAC;
import java.util.ArrayList;
import java.time.LocalDate;
public class Reserva {
    private Cliente cliente;
    private ArrayList<Auto> autos = new ArrayList();
    private LocalDate fechaInicio;
    private int tiempoAlquiler;
    
    public Reserva(){
    }
    public Reserva(Cliente c, LocalDate fi, int ta) {
        this.cliente = c;
        this.fechaInicio = fi;
        this.tiempoAlquiler = ta;
    }
    
    public void mostrarReserva() {
        System.out.println("------Reserva------");
        System.out.println("Inicio de la reserva: " + this.fechaInicio);
        System.out.println("Fin de la reserva: " + calcularFin());
        System.out.println("Precio total de la reserva: " + calcularPrecioTotal());
        this.cliente.mostrarCliente();
        for (Auto x: autos) {
            x.mostrarAuto();
            System.out.println("Precio total: " + (double)(x.getPrecio()*this.tiempoAlquiler));
        }
    }
    
    public double calcularPrecioTotal() {
        double p = 0;
        for (Auto x: autos) {
            p = p + x.getPrecio() * this.tiempoAlquiler;
        }
        return p;
    }
    
    public LocalDate calcularFin() {
        LocalDate ff;
        ff = this.fechaInicio.plusDays(this.tiempoAlquiler);
        return ff;
    }
    
    public void agregarAuto(Auto a) {
        this.autos.add(a);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Auto> getAutos() {
        return autos;
    }

    public void setAutos(ArrayList<Auto> autos) {
        this.autos = autos;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getTiempoAlquiler() {
        return tiempoAlquiler;
    }

    public void setTiempoAlquiler(int tiempoAlquiler) {
        this.tiempoAlquiler = tiempoAlquiler;
    }
    
}
