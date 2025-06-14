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
    private static Borse chosenBorse;
    private static int correct;
    private static int incorrect;

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
    public int getCorrect(){ return correct;}
    public int getIncorrect(){ return incorrect;}
    public String getMove(){return move;}
    public Color getColor(){return color;}
    public int getNumber(){return number;}
    public void addPoints(){points++;}
    public int getPoints(){return points;}
    public void resetPoints(){points = 0;}
    public void setChosen(Borse borse){chosenBorse = borse;}
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
    public int winner(ArrayList<Borse> stables){
        int max = 0;
        Borse winner = new Borse(0,0,0,0,0,Color.RED);
        for (Borse borse : stables){
            if (max < borse.getPoints()){
                max = borse.getPoints();
                winner = borse;
            }
        }
        if (winner == chosenBorse){
            correct++;
        }
        else{
            incorrect++;
        }
        for (Borse borse: stables){
            borse.resetPoints();
        }
        return winner.getNumber();
    }
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
