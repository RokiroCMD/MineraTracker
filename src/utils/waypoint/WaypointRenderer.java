package utils.waypoint;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import javax.swing.JButton;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.WaypointPainter;

public class WaypointRenderer extends WaypointPainter<MineraWaypoint>{

    @Override
    protected void doPaint(Graphics2D g, JXMapViewer map, int width, int height) {
        for (MineraWaypoint wp : getWaypoints()) {
            Point2D p = map.getTileFactory().geoToPixel(wp.getPosition(), map.getZoom());
            Rectangle rec = map.getViewportBounds();
            int x = (int)(p.getX() - rec.getX());
            int y = (int)(p.getY() - rec.getY());
            JButton cmd = wp.getBtn();
            cmd.setLocation(x - cmd.getWidth() /2 , y - cmd.getHeight());
        }
    }
    
    
    
}
