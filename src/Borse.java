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
    private int speed = (int)(Math.random()*2) + 1;
    private Color color;
    private int points;

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
    public void addPoints(){points++;}
    public int getPoints(){return points;}
    public void borseMap(int map){
        borse.x = 100;
        borse.y = 100;
        if (map == 2){
            borse.x = 500;
            borse.y = 600;
        }
        if (map == 3){
            borse.x = 450;
            borse.y = 450;
        }
    }
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
                 else if (borse.y >= y && borse.y <= y+(height/2) && borse.x >= x && borse.x <= x + width){
                    borse.y = borse.y-1;
                    move = "NORTH";
                }
                 else if (borse.y <= y+height && borse.y >= y + (height/2) && borse.x >= x+1 && borse.x <= x + width){
                    borse.y = borse.y+1;
                    move = "SOUTH";
                }
                else if (borse.y <= y+height && borse.y >= y && borse.x <= x){
                    borse.x = borse.x-1;
                    move = "WEST";
                }
                else if (borse.y <= y+height && borse.y >= y && borse.x >= x + width){
                    borse.x = borse.x+1;
                    move = "EAST";
                }
                direction = (int)(Math.random()*2);
                speed = (int)(Math.random()*2) + 1;
        System.out.println(move);
            }

        public void move(){
            if (move.equals("NORTH")) {
                moveRectangleNorth();
            }
            if (move.equals("SOUTH")) {
                moveRectangleSouth();
            }
            if (move.equals("EAST")) {
                moveRectangleEast();
            }
            if (move.equals("WEST")) {
                moveRectangleWest();
            }
        }
    public void moveRectangleNorth(){
        borse.y = borse.y - speed;
        if (direction == 0) {
            borse.x = borse.x + speed;
        }
        else {
            borse.x = borse.x - speed;
        }
    }

    public void moveRectangleSouth(){
        borse.y = borse.y + speed;
        if (direction == 0) {
            borse.x = borse.x + speed;
        }
        else {
            borse.x = borse.x - speed;
        }
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
