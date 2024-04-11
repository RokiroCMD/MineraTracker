
package models;

public class Vehiculo {
    int id;
    double lat, lon;
    String tipo;

    public Vehiculo(int id, double lat, double lon, String tipo) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
