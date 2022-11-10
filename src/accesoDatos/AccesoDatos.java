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
            Class.forName("com.mysql.cj.jbdc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_a_car", "root", "");
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
    
}
