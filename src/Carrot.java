import java.awt.*;
public class Carrot extends Sprite{
    private Rectangle carrot;
    public Carrot(int x, int y, int width, int height){
        super(x,y,width,height);
        carrot = getSprite();
    }
    public Rectangle getCarrot(){return carrot;}
}
