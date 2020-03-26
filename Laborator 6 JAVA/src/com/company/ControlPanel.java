package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton LoadBtn = new JButton("Load");
    JButton ResetBtn = new JButton("Reset");
    JButton ExitBtn = new JButton("Exit");
    //create all buttons (Load, Reset, Exit)
    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...TODO
        //configure listeners for all buttons

        add(saveBtn);
        add(LoadBtn);
        add(ResetBtn);
        add(ExitBtn);

        saveBtn.addActionListener(this::save);
        LoadBtn.addActionListener(this::load);
        ResetBtn.addActionListener(this::reset);
        ExitBtn.addActionListener(this::exit);

    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("E:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void load(ActionEvent e) {
        try {
            BufferedImage image = ImageIO.read(new File("E:/test.png"));
            frame.canvas.image = image;
            frame.canvas.graphics =  frame.canvas.image.createGraphics();
            frame.repaint();
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void reset(ActionEvent e) {
            final int W = 800, H = 600;
            frame.canvas.image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
            frame.canvas.graphics = frame.canvas.image.createGraphics();
            frame.canvas.graphics.setColor(Color.WHITE); //fill the image with white
            frame.canvas.graphics.fillRect(0, 0, W, H);
            frame.repaint();
    }
    private void exit(ActionEvent e) {
        frame.dispose();
        System.exit(0);
    }

}