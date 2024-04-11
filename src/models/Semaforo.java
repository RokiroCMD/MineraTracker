
package models;

public class Semaforo {

    int id;
    double lat, lon;
    String estado;

    public Semaforo(int id, double lat, double lon, String estado) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getEstado() {
        return estado;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
