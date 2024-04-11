
package utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class ImageRescaler {
    
    
    public static Image scaleImage(Image image, int width, int height) {
        // Crea una imagen BufferedImage con el tamaño deseado
        BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        
        // Obtiene el Graphics2D de la imagen escalada para dibujar en ella
        Graphics2D g2d = scaledImage.createGraphics();
        
        // Dibuja la imagen original escalada en la imagen BufferedImage
        g2d.drawImage(image, 0, 0, width, height, null);
        
        // Libera los recursos del Graphics2D
        g2d.dispose();
        
        return scaledImage.getScaledInstance(scaledImage.getWidth(), scaledImage.getHeight(), Image.SCALE_DEFAULT);
    }
    
}
