import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

class DrawPanel extends JPanel implements MouseListener {

    // Rectangle object represents ....... a rectangle.
    private Rectangle button;
    private Rectangle button1;
    private ArrayList<Rectangle> test = new ArrayList<Rectangle>();
    private Map map;
    private BufferedImage image;
    private Rectangle yes;
    private boolean bounce = false;

    public DrawPanel() {
        button = new Rectangle(167, 300, 160, 26);
        button1 = new Rectangle(360, 10, 160, 26);
        this.addMouseListener(this);
        map = new Map();
        map.nextRound();
        yes = new Rectangle(600, 600, 10, 10);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 300;
        int y = 300;
        Borse borse = new Borse(x,y,10,10,0);
        image = borse.getImage(borse.readImage(borse.getImageFile()));
        g.drawImage(image,x,y,this);
        for (Rectangle rec : test) {
            if(borse.getBorse().intersects(rec)){
                bounce = !bounce;
            }
        }
        for (int i = 0; i<100;i++){
            x++;
            g.drawImage(image, x, y, this);
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
        g.setColor(Color.BLACK);
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
        }


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

        // drawing the bottom button
        // with my favorite font (not comic sans)
        g.setFont(new Font("Courier New", Font.BOLD, 20));
        g.drawString("PLAY AGAIN", 180, 320);
        g.drawRect((int)button.getX(), (int)button.getY(), (int)button.getWidth(), (int)button.getHeight());
        g.drawString("REPLACE CARDS", 363, 30);
        g.drawRect((int)button1.getX(), (int)button1.getY(), (int)button1.getWidth(), (int)button1.getHeight());
        g.drawString("Cards left: ", 0, 525);
    }

    public void mousePressed(MouseEvent e) {

        Point clicked = e.getPoint();

        // left click
        if (e.getButton() == 1) {
            // if "clicked" is inside the button rectangle
            // aka --> did you click the button?
            if (button.contains(clicked)) {
            }
        }
    }

            // go through each card
            // check if any of them were clicked on
            // if it was clicked, flip the card
            /* for (int i = 0; i < hand.size(); i++) {
                Rectangle box = hand.get(i).getCardBox();
                if (box.contains(clicked)) {
                    hand.get(i).flipCard();
                }
            } */
            // right click
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