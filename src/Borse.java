import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Borse extends Sprite{
    private int number;
    private Rectangle borse;
    BufferedImage image;
    private String imageFile = "images/borse_"+number+".png";
    private static ArrayList<Rectangle> stables;
    private static ArrayList<Rectangle> race;
    private String move = "NORTH";
    private int direction = (int)(Math.random()*2);

    public Borse(int x, int y, int w, int h, int number) {
        super(x,y,w,h);
        borse = getSprite();
        stables.add(borse);
        this.number = number;
        image = readImage(imageFile);
    }
    public String getImageFile() {
        return imageFile;
    }
    public Rectangle getBorse(){ return borse;}
    public String getMove(){return move;}
    public ArrayList<Rectangle> getStables(){return stables;}
    public ArrayList<Rectangle> getRace(){return race;}

    public void detectCollision(){
                if (borse.x <= 100){
                    move = "EAST";
                }
                else if (borse.x >= 1820){
                    move = "WEST";
                }
                else if (borse.y >= 900){
                    move = "NORTH";
                }
                else if (borse.y <= 100){
                    move = "SOUTH";
                }
                else if (move.equals("NORTH")){
                    move = "SOUTH";
                }
                else if (move.equals("SOUTH")){
                    move = "NORTH";
                }
                else if (move.equals("EAST")){
                    move = "WEST";
                }
                else if (move.equals("WEST")){
                    move = "EAST";
                }
                direction = (int)(Math.random()*2);
            }
    public void moveRectangleNorth(){
        int speed = (int)(Math.random() * 5) + 1;
        if (direction == 0) {
            borse.x = borse.x + speed;
        }
        else{
            borse.x = borse.x - speed;
        }
        borse.y = borse.y - speed;
    }

    public void moveRectangleSouth(){
        int speed = (int)(Math.random() * 5) + 1;
        if (direction == 0) {
            borse.x = borse.x + speed;
        }
        else {
            borse.x = borse.x - speed;
        }
        borse.y = borse.y + speed;
    }

    public void moveRectangleEast(){
        int speed = (int)(Math.random() * 5) + 1;
        borse.x = borse.x+speed;
        if (direction == 0) {
            borse.y = borse.y + speed;
        }
        else {
            borse.y = borse.y - speed;
        }
    }

    public void moveRectangleWest(){
        int speed = (int)(Math.random() * 5) + 1;
        borse.x = borse.x-speed;
        if (direction == 0) {
            borse.y = borse.y + speed;
        }
        else {
            borse.y = borse.y - speed;
        }
    }
}
