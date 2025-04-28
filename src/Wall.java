import java.awt.*;
import java.util.ArrayList;

public class Wall {
    private static int map;
    private Rectangle test;
    public Wall(){
    }

    public ArrayList<Rectangle> createMap(){
        ArrayList<Rectangle> walls = new ArrayList<Rectangle>();
        if (map == 1){
            walls.add(new Rectangle(100,100, 100,100));
            walls.add(new Rectangle(500,400, 100,100));
            walls.add(new Rectangle(300,200, 100,100));
            walls.add(new Rectangle(10,10, 100,100));
            walls.add(new Rectangle(800,90, 100,100));
        }
        return walls;
    }



    public void nextRound(){
        map++;
    }
}
