import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

class DrawPanel extends JPanel implements MouseListener {
    private Rectangle button;
    private Rectangle button1;
    private Rectangle button2;
    private Rectangle button3;
    private ArrayList<Rectangle> test = new ArrayList<Rectangle>();
    private ArrayList<Borse> stables = new ArrayList<>();
    private static ArrayList<Rectangle> race = new ArrayList<>();
    private Map map;
    private BufferedImage image;
    private boolean outScreen = true;
    private boolean gamble = false;
    private boolean clear = false;

    private Rectangle carrot;
    Borse borse1 = new Borse(100,100,10,10,1,Color.RED);
    Borse borse2 = new Borse(100,100,10,10,2,Color.GREEN);
    Borse borse3 = new Borse(100,100,10,10,3,Color.BLUE);
    //Carrot carrot1 = new Carrot(1775,850,50,50);
    Carrot carrot1 = new Carrot(1770,900,50,50);

    public DrawPanel() {
        button = new Rectangle(880, 700, 160, 40);
        button1 = new Rectangle (10000,700,160,40);
        button2 = new Rectangle(10000, 700, 160, 40);
        button3 = new Rectangle (10000,700,160,40);
        this.addMouseListener(this);
        map = new Map();
        carrot = carrot1.getCarrot();
        stables.add(borse1);
        stables.add(borse2);
        stables.add(borse3);
        for (Borse borse : stables){
            race.add(borse.getBorse());
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        outScreen(g);
        if (clear){
            g.clearRect(0,0,getWidth(),getHeight());
            clear = false;
        }
        test = map.createMap();
        if (!outScreen) {
            g.setColor(Color.BLACK);
            g.drawRect(carrot.x,carrot.y,carrot.width,carrot.height);
            g.setColor(Color.ORANGE);
            g.fillRect(carrot.x,carrot.y,carrot.width,carrot.height);
            for (Rectangle rectangle : test) {
                g.setColor(Color.BLACK);
                g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
                g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            }
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.BOLD, 50));
            g.drawString("BORSE 1 POINTS:" + borse1.getPoints(),100,50);
            g.drawString("BORSE 2 POINTS:" + borse2.getPoints(),700,50);
            g.drawString("BORSE 3 POINTS:" + borse3.getPoints(),400,100);
            g.drawString(map.mapName(),100,950);
            for (int i = 0; i < race.size(); i++){
                g.setColor(Color.BLACK);
                g.drawRect((int)race.get(i).getX(),(int)race.get(i).getY(),(int)race.get(i).getWidth(),(int)race.get(i).getHeight());
                g.setColor(stables.get(i).getColor());
                g.fillRect((int)race.get(i).getX(),(int)race.get(i).getY(),(int)race.get(i).getWidth(),(int)race.get(i).getHeight());
            }
            try{Thread.sleep(10);}catch(Exception e){}
            for (int i = 0; i < race.size(); i++){
                for (Rectangle rectangle : test){
                    if (race.get(i).intersects(rectangle)) {
                        stables.get(i).detectCollision(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
                    }
                    if (race.get(i).intersects(carrot)){
                        nextMap(g, i);
                    }
                    stables.get(i).move();
                }

            }
            if (map.getMap() == 6){
                int win = borse1.winner(stables);
                g.setFont(new Font("Brush Script MT", Font.BOLD, 100));
                g.drawString("Borse " + win + " won!", 500, 200);
            }
            }
    }
    protected void outScreen(Graphics g) {
        Rectangle full = map.outScreen();
        if (outScreen) {
            if (!gamble){
            button.x = 880; //bandage fix
            g.setColor(Color.BLACK);
            g.drawRect((int) full.getX(), (int) full.getY(), (int) full.getWidth(), (int) full.getHeight());
            g.fillRect((int) full.getX(), (int) full.getY(), (int) full.getWidth(), (int) full.getHeight());
            Sprite amazing = new Sprite(650, 200, 10, 10);
            image = amazing.getImage(amazing.readImage(amazing.getImageFile("images/woodrow-rearing-square.jpg")));
            g.drawImage(image, 755, 250, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Brush Script MT", Font.BOLD, 100));
            g.drawString("BORSE RACE", 650, 200);
            g.setFont(new Font("Courier New", Font.BOLD, 50));
            g.drawString("PLAY", 900, 735);
            g.drawRect((int) button.getX(), (int) button.getY(), (int) button.getWidth(), (int) button.getHeight());
            }
            else{
                g.setColor(Color.BLACK);
                g.drawRect((int) full.getX(), (int) full.getY(), (int) full.getWidth(), (int) full.getHeight());
                g.fillRect((int) full.getX(), (int) full.getY(), (int) full.getWidth(), (int) full.getHeight());
                g.setColor(Color.WHITE);
                button.x = 100000;
                button1.x = 500;
                button2.x = 1000;
                button3.x = 1500;
                g.setFont(new Font("Brush Script MT", Font.BOLD, 100));
            g.drawString("CHOOSE THE WINNER", 500, 200);
                g.setFont(new Font("Courier New", Font.BOLD, 30));
                g.drawString("BORSE 2", 1020, 735);
                g.drawString("BORSE 1", 520, 735);
                g.drawString("BORSE 3", 1520, 735);
                g.drawRect((int) button1.getX(), (int) button1.getY(), (int) button1.getWidth(), (int) button1.getHeight());
                g.drawRect((int) button2.getX(), (int) button2.getY(), (int) button2.getWidth(), (int) button2.getHeight());
                g.drawRect((int) button3.getX(), (int) button3.getY(), (int) button3.getWidth(), (int) button3.getHeight());
            }
        }
        else{
            button.x = 100000;
            button1.x = 100000;
            button2.x = 100000;
            button3.x = 100000;
        }
    }
    protected void nextMap(Graphics g,int i){
        try{Thread.sleep(1000);}catch(Exception e){}
        stables.get(i).addPoints();
        map.nextRound();
        carrot1.carrotMap(map.getMap());
        for (Borse borse : stables) {
        borse.borseMap(map.getMap());
        }
        test = map.createMap();
        for (Rectangle n : test) {
            g.setColor(Color.BLACK);
            g.drawRect(n.x, n.y, n.width, n.height);
            g.fillRect(n.x, n.y, n.width, n.height);
        }
        try{Thread.sleep(100);}catch(Exception e){}
    }

    public void clear(Graphics g){
        g.clearRect(0,0,getWidth(),getHeight());
        clear = false;
    }

    public void mousePressed(MouseEvent e) { // placeholder code

        Point clicked = e.getPoint();

        if (e.getButton() == 1) {
            if (button.contains(clicked)) {
                clear = true;
                gamble = true;
            }
            if (button1.contains(clicked) || button2.contains(clicked) || button3.contains(clicked)){
                gamble = false;
                outScreen = false;
                if (button1.contains(clicked)){
                    borse1.setChosen(borse1);
                }
                if (button2.contains(clicked)){
                    borse1.setChosen(borse2);
                }
                if (button3.contains(clicked)){
                    borse1.setChosen(borse3);
                }
                clear = true;
            }
        }
    }

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
}