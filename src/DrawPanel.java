import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.nio.Buffer;
import java.util.ArrayList;

class DrawPanel extends JPanel implements MouseListener {
    private Rectangle button;
    private Rectangle button1;
    private ArrayList<Rectangle> test = new ArrayList<Rectangle>();
    private ArrayList<Borse> stables = new ArrayList<>();
    private static ArrayList<Rectangle> race = new ArrayList<>();
    private Map map;
    private BufferedImage image;
    private boolean outScreen = true;
    private boolean pause = false;
    private boolean clear = false;

    private Rectangle carrot;
    Borse borse1 = new Borse(600,600,10,10,1,Color.RED);
    Borse borse2 = new Borse(100,100,10,10,2,Color.GREEN);
    Carrot carrot1 = new Carrot(1775,850,50,50);

    public DrawPanel() {
        button = new Rectangle(880, 700, 160, 40);
        this.addMouseListener(this);
        map = new Map();
        carrot = carrot1.getCarrot();
        stables.add(borse1);
        stables.add(borse2);
        for (Borse borse : stables){
            race.add(borse.getBorse());
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 300;
        int y = 300;
        /* Borse borse = new Borse(x,y,10,10,0);
        image = borse.getImage(borse.readImage(borse.getImageFile()));
        g.drawImage(image,x,y,this);
        for (Rectangle rec : test) {
            if(borse.getBorse().intersects(rec)){
                bounce = !bounce;
            }
        }

        for (int i = 0; i<100;i++){
            x++;
            try {
                Thread.sleep(1);
            }
            catch (Exception e) {
            }
            repaint();
        }

        if (!bounce) {
            if(x==100){
                x = x + 2;
            }
            x++;
            y++;
        }
        else{
            if(x==100){
                x = x + 2;
            }
            else {
                x = x -2;
            }
            y--;
        }
        test = map.createMap();
        Rectangle ttttt = map.outScreen();
        g.setColor(Color.BLACK);
        g.drawRect(ttttt.x,ttttt.y,ttttt.width,ttttt.height);
        g.fillRect(ttttt.x,ttttt.y,ttttt.width,ttttt.height);
        for (Rectangle rec : test) {
            g.drawRect(rec.x,rec.y,rec.width,rec.height);
            g.fillRect(rec.x,rec.y,rec.width,rec.height);
        }
        g.drawRect(yes.x,yes.y,yes.width,yes.height);
        g.setColor(Color.RED);
        g.fillRect(yes.x,yes.y,yes.width,yes.height);

        for (Rectangle rec : test) {
            if(yes.intersects(rec)){
                bounce = !bounce;
            }
        }
        if (!bounce) {
            if(yes.x==100){
                yes.x = yes.x + 2;
            }
            yes.x++;
            yes.y++;
        }
        else{
            if(yes.x==100){
                yes.x = yes.x + 2;
            }
            else {
                yes.x = yes.x -2;
            }
            yes.y--;
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } */


        /* for (int i = 0; i < hand.size(); i++) {
            if (i % 3 == 0 && i != 0) {
                y = y + 100;
                x = 140;
            }
            Card c = hand.get(i);
            if (c.getHighlight()) {
                // draw the border rectangle around the card
                g.drawRect(x, y, c.getImage().getWidth(), c.getImage().getHeight());
            }

            // establish the location of the rectangle "hitbox"
            c.setRectangleLocation(x, y);

            g.drawImage(c.getImage(), x, y, null);
            x = x + c.getImage().getWidth() + 10;
        }
             */
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
            for (int i = 0; i < race.size(); i++){
                g.setColor(Color.BLACK);
                g.drawRect((int)race.get(i).getX(),(int)race.get(i).getY(),(int)race.get(i).getWidth(),(int)race.get(i).getHeight());
                g.setColor(stables.get(i).getColor());
                g.fillRect((int)race.get(i).getX(),(int)race.get(i).getY(),(int)race.get(i).getWidth(),(int)race.get(i).getHeight());
            }
            try{Thread.sleep(1);}catch(Exception e){}
            for (int i = 0; i < race.size(); i++){
                for (Rectangle rectangle : test){
                    if (race.get(i).intersects(rectangle)) {
                        stables.get(i).detectCollision(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
                    }
                    if (race.get(i).intersects(carrot)){
                        /*race.get(i).x = 1775;
                        carrot.x = 1775;
                        g.setColor(Color.blue);
                        g.setFont(new Font("Courier New", Font.BOLD, 100));
                        g.drawString("borse" + stables.get(i).getNumber() + " won!",650,500); */
                        try{Thread.sleep(1000);}catch(Exception e){}
                        map.nextRound();
                        carrot.x = 1000;
                        System.out.println(map.getMap());
                        if (map.getMap() == 2) {
                            System.out.println("work");
                            test = map.createMap();
                            borse1.setX(100);
                            borse2.setX(100);
                            for (Rectangle n : test) {
                                g.setColor(Color.BLACK);
                                g.drawRect(n.x, n.y, n.width, n.height);
                                g.fillRect(n.x, n.y, n.width, n.height);
                            }
                        }
                        try{Thread.sleep(100);}catch(Exception e){}
                    }
                    if (stables.get(i).getMove().equals("NORTH")) {
                        stables.get(i).moveRectangleNorth();
                    }
                    if (stables.get(i).getMove().equals("SOUTH")) {
                        stables.get(i).moveRectangleSouth();
                    }
                    if (stables.get(i).getMove().equals("EAST")) {
                        stables.get(i).moveRectangleEast();
                    }
                    if (stables.get(i).getMove().equals("WEST")) {
                        stables.get(i).moveRectangleWest();
                    }
                }

            }
            }
    }
    protected void outScreen(Graphics g) {
        Rectangle full = map.outScreen();
        if (outScreen) {
            button.x = 880; //bandage fix
            g.setColor(Color.BLACK);
            g.drawRect((int) full.getX(), (int) full.getY(), (int) full.getWidth(), (int) full.getHeight());
            g.fillRect((int) full.getX(), (int) full.getY(), (int) full.getWidth(), (int) full.getHeight());
            Sprite amazing = new Sprite(650, 200, 10, 10);
            image = amazing.getImage(amazing.readImage(amazing.getImageFile("images/woodrow-rearing-square.jpg")));
            g.drawImage(image, 755, 250, this);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Brush Script MT", Font.BOLD, 100));
            if (!pause) {
                g.drawString("BORSE RACE", 650, 200);
            } else {
                g.drawString("PAUSED", 755, 200);
            }
            g.setFont(new Font("Courier New", Font.BOLD, 50));
            g.drawString("PLAY", 900, 735);
            g.drawRect((int) button.getX(), (int) button.getY(), (int) button.getWidth(), (int) button.getHeight());
        }
        else{
            button.x = 100000;
        }
    }


    public void moveImage(int x, int y){
        x++;
        y++;
        repaint();
    }

    public void clear(Graphics g){
        g.clearRect(0,0,getWidth(),getHeight());
        clear = false;
    }

    public void mousePressed(MouseEvent e) { // placeholder code

        Point clicked = e.getPoint();

        if (e.getButton() == 1) {
            if (button.contains(clicked)) {
                outScreen = false;
                clear = true;
                if (!pause){
                    map.nextRound();
                }
            }
        }
    }
            /* if (e.getButton() == 1 || e.getButton() == 3) {
                for (int i = 0; i < hand.size(); i++) {
                    Rectangle box = hand.get(i).getCardBox();
                    if (box.contains(clicked)) {

                        }
                    } */

    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
}