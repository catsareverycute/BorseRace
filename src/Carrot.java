import java.awt.*;
public class Carrot extends Sprite{
    private Rectangle carrot;
    public Carrot(int x, int y, int width, int height){
        super(x,y,width,height);
        carrot = getSprite();
    }
    public Rectangle getCarrot(){return carrot;}
    public void carrotMap(int map){
        if (map == 0){
            carrot.x = 1775;
            carrot.y = 800;
        }
        if (map == 1){
            carrot.x = 950;
            carrot.y = 800;
        }
        if (map == 3){
            carrot.x = 1775;
            carrot.y = 425;
        }
        if (map == 4){
            carrot.x = 1200;
            carrot.y = 325;
        }
        if (map == 5){
            //carrot.x = 1770;
            carrot.x = 500;
            carrot.y = 100;
        }
    }
}
