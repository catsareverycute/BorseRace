import java.awt.*;
public class Carrot extends Sprite{
    private Rectangle carrot;
    public Carrot(int x, int y, int width, int height){
        super(x,y,width,height);
        carrot = getSprite();
    }
    public Rectangle getCarrot(){return carrot;}
    public void carrotMap(int map){
        if (map == 1){}
        carrot.x = 950;
        carrot.y = 850;
        if (map == 3){
            carrot.x = 1775;
            carrot.y = 425;
        }
        if (map == 4){
            carrot.x = 300;
            carrot.y = 375;
        }
    }
}
