import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Borse extends Sprite{
    private int number;
    private Rectangle borse;
    BufferedImage image;
    private String imageFile = "images/borse_"+number+".png";
    private ArrayList<Rectangle> stables;
    private ArrayList<Rectangle> race;

    public Borse(int x, int y, int h, int w, int number) {
        super(x,y,h,w);
        borse = new Rectangle(x,y,h,w);
        this.number = number;
        image = readImage(imageFile);
    }
    public String getImageFile() {
        return imageFile;
    }
    public Rectangle getBorse(){ return borse;}

}
