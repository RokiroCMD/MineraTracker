package Conexionsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Semaforo;
import models.Vehiculo;

public class Conexion {
    public static Connection getConnection;
    
    public static Connection initConexion(){
        String cadena = "jdbc:sqlserver://localhost;"
                + "database=Minera;"
                + "user=sa;"
                + "password=123;"
                + "loginTimeout=10;";
        try{
            getConnection = DriverManager.getConnection(cadena);
            return getConnection;
        }
        catch(SQLException ex){
            System.out.println("Error: " + ex.toString());
            return null;
        }
    }
    
    public static void cambiarSemaforo(String id, String estado){
        try {
            PreparedStatement ps = getConnection.prepareStatement("UPDATE Semaforos Set Estado = ? where IDSemaforo = ?");
            ps.setString(1, estado);
            ps.setString(2, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Set<Semaforo> getSemaforos(){
        try {
            PreparedStatement ps = getConnection.prepareStatement("Select * from Semaforos");
            ResultSet rs = ps.executeQuery();
            
            Set<Semaforo> semaforos = new HashSet<Semaforo>();
            
            while(rs.next()){
                
                semaforos.add(new Semaforo(
                        rs.getInt("IDSemaforo"),
                        Double.parseDouble(rs.getString("Lat")),
                        Double.parseDouble(rs.getString("Lon")),
                        rs.getString("Estado")));
                
            }
            
            return semaforos;
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    public static Set<Vehiculo> getVehiculos(){
        try {
            PreparedStatement ps = getConnection.prepareStatement("Select * from Vehiculos");
            ResultSet rs = ps.executeQuery();
            
            Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
            
            while(rs.next()){
                
                vehiculos.add(new Vehiculo(
                        rs.getInt("IDVehiculo"),
                        Double.parseDouble(rs.getString("Lat")),
                        Double.parseDouble(rs.getString("Lon")),
                        rs.getString("Tipo")));
                
            }
            
            return vehiculos;
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
