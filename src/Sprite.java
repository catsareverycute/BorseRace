import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {
    private int height;
    private int width;
    private int x;
    private int y;

    public Sprite(int x, int y, int height, int width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    // a BufferedImage object is an object that represents an image file to be
    // drawn on the screen
    public BufferedImage readImage(String imageFile) {
        try {
            BufferedImage image;
            // if show is true, show the front
            // otherwise show the back of the card
            image = ImageIO.read(new File(imageFile));
            return image;
        }
        catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }

    public String getImageFile(String imageFile) {
        return imageFile;
    }

    public BufferedImage getImage(BufferedImage image) {
        return image;
    }
    public int getX(){return x;}
    public int getY(){return y;}
}
