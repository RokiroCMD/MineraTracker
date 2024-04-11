
package utils.waypoint;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import utils.ImageRescaler;
import utils.waypoint.MineraWaypoint.MINERA_WAYPOINT_TYPE;

public class DompeWaypoint extends JButton{

    
    public DompeWaypoint() {
        
        setContentAreaFilled(false);
        
        setIcon(new ImageIcon(ImageRescaler.scaleImage(new ImageIcon(MINERA_WAYPOINT_TYPE.DOMPE.img).getImage(),
                32, 32)));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setSize(new Dimension(32, 32));
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
    }   
    
    
}
