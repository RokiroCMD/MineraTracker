
package utils.waypoint;

import javax.swing.JButton;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

public class MineraWaypoint extends DefaultWaypoint{
    
    private String nombre;
    private JButton btn;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public JButton getBtn() {
        return btn;
    }

    public void setBtn(JButton btn) {
        this.btn = btn;
    }

    public MineraWaypoint(String nombre, JButton btn, GeoPosition coord) {
        super(coord);
        this.nombre = nombre;
        this.btn = btn;
    }
    public MineraWaypoint(String nombre, JButton btn, GeoPosition coord, String extra) {
        super(coord);
        this.nombre = nombre;
        this.btn = btn;
        if (btn instanceof SemaforoWaypoint) {
            ((SemaforoWaypoint)btn ).setColor(extra);
        }
    }

    public MineraWaypoint() {
    }
    
    public static enum MINERA_WAYPOINT_TYPE{
        SEMAFORO("src/resources/semaforo_verde.png"),
        DOMPE("src/resources/dompe.png"),
        EXCAVADORA("src/resources/excavadora.png");
        
        public String img;

        private MINERA_WAYPOINT_TYPE(String img) {
            this.img = img;
        }
        
    }
    
    
}
