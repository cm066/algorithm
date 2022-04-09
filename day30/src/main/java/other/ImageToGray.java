package other;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author cm
 * @create 2022/4/9-11:50 上午
 */
public class ImageToGray {
    public static void main(String[] args) {

    }

    public static void imageToGray(String src, String dest,String type){
        try {
            BufferedImage srcImage = ImageIO.read(new File(src));
            BufferedImage scaleImage = new BufferedImage(8,8,BufferedImage.TYPE_INT_RGB);
            scaleImage.getGraphics().drawImage(srcImage.getScaledInstance(8,8,Image.SCALE_SMOOTH),0,0,null);
            BufferedImage  destImage = new BufferedImage(8,8,BufferedImage.TYPE_BYTE_GRAY);
            for (int i = 0; i < scaleImage.getWidth(); i++) {
                for (int j = 0; j < scaleImage.getHeight(); j++) {
                    int rgb = scaleImage.getRGB(i, j);
                    destImage.setRGB(i,j,rgb);
                }
            }
            ImageIO.write(destImage,type,new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
