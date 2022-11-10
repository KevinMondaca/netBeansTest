package accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Auto;
import modelo.Cliente;
import modelo.Direccion;
import modelo.Registro;
import modelo.Reserva;

public class AccesoDatos {
    private Connection conn;
    private Statement comandos;
    
    public AccesoDatos(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_a_car", "root", "");
            comandos = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: No se encontro la BD");
        } catch (SQLException ex) {
            System.out.println("Error: Usuario o pass incorrecto");
        }
    }
    
    public void insertarCliente(Cliente c){
        String sql = "insert into cliente values(" + c.getDni() + ", '" + c.getNombre() + "', '" + c.getDireccion().toString() + "', " + c.getTelefono()+ ")";
        System.out.println(sql);
        try {
            comandos.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error en la sintaxis SQL");
        }
    }
    public void insertarAuto(Auto a){
        String sql = "insert into auto values('" + a.getMatricula() + "', '" + a.getModelo() + "', '" + a.getMarca() + "', '" + a.getColor() + "', " + a.getPrecio() + ", NULL)";
        System.out.println(sql);
        try {
            comandos.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error en la sintaxis SQL");
        }
    }
    public void insertarReserva(Reserva r){
        String sql = "insert into reserva values(" + r.getIdReserva() + ", " + r.getCliente().getDni() + ", '" + r.getFechaInicio() + "', " + r.getTiempoAlquiler() + ")";
        System.out.println(sql);
        try {
            comandos.executeUpdate(sql);
            for (Auto x: r.getAutos()) {
                comandos.executeUpdate("update auto set reserva = " + r.getIdReserva() + " where matricula = '" + x.getMatricula() + "'");
            }
        } catch (SQLException ex) {
            System.out.println("Error en la sintaxis SQL");
        }
    }
}
