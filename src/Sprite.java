import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {
    private int width;
    private int height;
    private int x;
    private int y;
    private Rectangle sprite;

    public Sprite(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        sprite = new Rectangle(x,y,width,height);
    }
    // a BufferedImage object is an object that represents an image file to be
    // drawn on the screen
    public BufferedImage readImage(String imageFile) {
        try {
            BufferedImage image;
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

    public Rectangle getSprite(){
        return sprite;
    }

    public BufferedImage getImage(BufferedImage image) {
        return image;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public int getWidth(){return width;}
    public int getHeight(){return height;}
}
