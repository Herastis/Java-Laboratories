package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }
    protected void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    //...NEXT SLIDE
    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }
    private void drawShape(int x, int y) {
        Random rand = new Random();
        int radius = rand.nextInt(360); //generate a random number
        int sides = (int)frame.configPanel.sidesField.getValue(); //get the value from UI (in ConfigPanel)

        Object shape =frame.configPanel.cb.getSelectedItem();
        //AM INCERCAT SA IMPLEMENTEZ SELECTAREA UNUI SHAPE DAR NU AM REUSIT :(
        Color color;
        if(shape.equals("REGULAR POLYGON"))
            {sides=6;   color = new Color(150,0, 13, 105);
                graphics.setColor(color);
                graphics.fill(new RegularPolygon(x, y, radius, sides));} //create a transparent random Color.}
        else if(shape.equals("TRIANGLE"))
            {sides=3;    color = new Color(33,0, 150, 105);
                graphics.setColor(color);
                graphics.fill(new RegularPolygon(x, y, radius, sides));} //create a transparent random Color.}
        else if(shape.equals("SQUARE"))
            {sides=4;    color = new Color(24, 255, 0, 105);
                graphics.setColor(color);
                graphics.fill(new RegularPolygon(x, y, radius, sides));} //create a transparent random Color.}
        else if(shape.equals("CIRCLE"))
            {sides=100;  color = new Color(150, 131, 0, 79);
                graphics.setColor(color);
                graphics.fill(new RegularPolygon(x, y, radius, sides));} //create a transparent random Color.}
        //Color color = new Color(150,0, 13, 105);; //create a transparent random Color.
        //graphics.setColor(color);
        //graphics.fill(new RegularPolygon(x, y, radius, sides));
        //graphics.fill(new Rectangle(x, y, radius, sides));
        //graphics.fill(new Triangle(x, y, radius, sides));
        //graphics.drawPolygon(new int[] {x+rand.nextInt(100), x+rand.nextInt(100), x+rand.nextInt(100)}, new int[] {y+100, rand.nextInt(100), y+100}, 3);
    }
    @Override
    public void update(Graphics g) { } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}



