import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Borse extends Sprite{
    private int number;
    private Rectangle borse;
    BufferedImage image;
    private String imageFile = "images/borse_"+number+".png";
    private String move = "NORTH";
    private int direction = (int)(Math.random()*2);
    private int speed = (int)(Math.random()*1) + 1;
    private Color color;

    public Borse(int x, int y, int w, int h, int number, Color color) {
        super(x,y,w,h);
        borse = getSprite();
        this.number = number;
        this.color = color;
        image = readImage(imageFile);
    }
    public String getImageFile() {
        return imageFile;
    }
    public Rectangle getBorse(){ return borse;}
    public String getMove(){return move;}
    public Color getColor(){return color;}
    public int getNumber(){return number;}
// X Y TP THERE WHEN INTERSECT AND TRY AGAIN
    public void detectCollision(int x, int y, int width, int height){
                if (borse.x <= 100){
                    move = "EAST";
                    borse.x = 101;
                }
                else if (borse.x >= 1800){
                    move = "WEST";
                    borse.x = 1799;
                }
                else if (borse.y >= 900){
                    move = "NORTH";
                    borse.y = 899;
                }
                else if (borse.y <= 100){
                    move = "SOUTH";
                    borse.y = 101;
                }
                else if (borse.y >= y && borse.x >= x && borse.x <= x + width){
                    move = "NORTH";
                    borse.y = y-1;
                }
                else if (borse.y >= y+height && borse.x >= x && borse.x <= x + width){
                    move = "SOUTH";
                    borse.y = y+1;
                }
                else if (borse.y <= y+height && borse.y >= y && borse.x <= x){
                    move = "WEST";
                    borse.x = x-1;
                }
                else if (borse.y <= y+height && borse.y >= y && borse.x <= x + width){
                    move = "EAST";
                    borse.x = x+1;
                }
                /*else if (move.equals("NORTH")){
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
                }*/
                direction = (int)(Math.random()*2);
                speed = (int)(Math.random()*1) + 1;
                //borse.x = getX();
                // borse.y = getY();
            }
    public void moveRectangleNorth(){
        if (direction == 0) {
            borse.x = borse.x + speed;
        }
        else{
            borse.x = borse.x - speed;
        }
        borse.y = borse.y - speed;
    }

    public void moveRectangleSouth(){
        if (direction == 0) {
            borse.x = borse.x + speed;
        }
        else {
            borse.x = borse.x - speed;
        }
        borse.y = borse.y + speed;
    }

    public void moveRectangleEast(){
        borse.x = borse.x+speed;
        if (direction == 0) {
            borse.y = borse.y + speed;
        }
        else {
            borse.y = borse.y - speed;
        }
    }

    public void moveRectangleWest(){
        borse.x = borse.x-speed;
        if (direction == 0) {
            borse.y = borse.y + speed;
        }
        else {
            borse.y = borse.y - speed;
        }
    }
}
