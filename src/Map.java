import java.awt.*;
import java.util.ArrayList;

public class Map {
    private static int map;
    public Map(){
    }

    public ArrayList<Rectangle> createMap(){
        ArrayList<Rectangle> walls = new ArrayList<Rectangle>();
        walls.add(new Rectangle(0,0,1920,100));
        walls.add(new Rectangle(0,0,100,1080));
        walls.add(new Rectangle (0,900,1920,200));
        walls.add(new Rectangle (1820,0,200,1080));
        if (map == 1){
            walls.add(new Rectangle(550,250, 100,100));
            walls.add(new Rectangle(500,400, 100,100));
            walls.add(new Rectangle(300,200, 100,100));
            walls.add(new Rectangle(1300,350, 100,100));
            walls.add(new Rectangle(800,150, 100,100));
            walls.add(new Rectangle(1300,600, 100,100));
            walls.add(new Rectangle(1000,300,100,100));
            walls.add(new Rectangle(1500,750, 100,100));
            walls.add(new Rectangle(200,700, 100,100));
            walls.add(new Rectangle(400,550,100,100));
            walls.add(new Rectangle(900,700,100,100));
            walls.add(new Rectangle(1600,200,100,100));
            walls.add(new Rectangle(1700,450,100,100));
            walls.add(new Rectangle(700,650,100,100));
            walls.add(new Rectangle(250,450,100,100));
            walls.add(new Rectangle(1200,200,100,100));
            walls.add(new Rectangle(650,500,100,100));
            walls.add(new Rectangle(850,400,100,100));
            walls.add(new Rectangle(1450,500,100,100));
            walls.add(new Rectangle(1050,550,100,100));
            walls.add(new Rectangle(1650,700,100,100));
            walls.add(new Rectangle(1100,700,100,100));
            walls.add(new Rectangle(1250,750,100,100));
        }
        if (map == 2){
            walls.add(new Rectangle(200,200,1525,200));
            walls.add(new Rectangle(200,600,1525,200));
        }
        if (map == 3){
            walls.add(new Rectangle(100,100,1800,325));
            walls.add(new Rectangle(100,475,1800,500));
        }
        if (map == 4){
            walls.add(new Rectangle(900,200,100,675));
            walls.add(new Rectangle(400,425,1145,100));
        }
        if (map == 5){
            walls.add(new Rectangle(100,300,190,25));
            walls.add(new Rectangle(300,100,25,190));
            walls.add(new Rectangle(1615,100,25,190));
            walls.add(new Rectangle(1645,300,200,25));
            walls.add(new Rectangle(1615,710,25,190));
            walls.add(new Rectangle(1645,675,300,25));
            walls.add(new Rectangle(100,625,190,25));
            walls.add(new Rectangle(300,675,25,300));
        }
        if (map == 6){
            outScreen();
        }
        return walls;
    }

    public String mapName(){
        if (map == 1) {
            return "\"Polka Dots\"";
        }
        if (map == 2) {
            return "\"Equal\"";
        }
        if (map == 3) {
            return "\"Minus\"";
        }
        if (map == 4) {
            return "\"Plus\"";
        }
        if (map == 5) {
            return "\"Four Corners\"";
        }
        return "\"Space\"";
    }
    public Rectangle outScreen(){
        return (new Rectangle(0,0,1920,1080));
    }



    public void nextRound(){
        map++;
    }

    public int getMap() {return map;}
    public void setMap(int mapNum) { map = mapNum;}
}
