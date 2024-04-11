
package utils.waypoint;

import Conexionsql.Conexion;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import utils.ImageRescaler;
import utils.waypoint.MineraWaypoint.MINERA_WAYPOINT_TYPE;

public class SemaforoWaypoint extends JButton{

    private String color = "Verde";
    String id;
    
    public SemaforoWaypoint(String id) {
        this.id = id;
        setContentAreaFilled(false);
        
        setIcon(new ImageIcon(ImageRescaler.scaleImage(new ImageIcon(MINERA_WAYPOINT_TYPE.SEMAFORO.img).getImage(),
                64, 64)));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setSize(new Dimension(64, 64));
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarColor();
            }
        });
        
    }   
    
    public void setColor(String color){
        this.color = color;
        switch (color) {
            case "Verde":
                setIcon(new ImageIcon(ImageRescaler.scaleImage(new ImageIcon("src/resources/semaforo_verde.png").getImage(),
                64, 64)));
                break;
            case "Rojo":
                setIcon(new ImageIcon(ImageRescaler.scaleImage(new ImageIcon("src/resources/semaforo_rojo.png").getImage(),
                64, 64)));
                break;
        }
        repaint();
        revalidate();
    }
    
    public void cambiarColor(){
        switch (color) {
            case "Verde":
                setIcon(new ImageIcon(ImageRescaler.scaleImage(new ImageIcon("src/resources/semaforo_rojo.png").getImage(),
                64, 64)));
                color = "Rojo";
                Conexion.cambiarSemaforo(id, color);
                break;
            case "Rojo":
                setIcon(new ImageIcon(ImageRescaler.scaleImage(new ImageIcon("src/resources/semaforo_verde.png").getImage(),
                64, 64)));
                color = "Verde";
                Conexion.cambiarSemaforo(id, color);
                break;
        }
        repaint();
        revalidate();
    }
    
}
