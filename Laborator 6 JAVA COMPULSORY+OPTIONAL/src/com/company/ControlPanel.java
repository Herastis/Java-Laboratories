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
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showDialog(frame, "Save");
            ImageIO.write(frame.canvas.image, "PNG", new File("E:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void load(ActionEvent e) {
        try {
            final JFileChooser fc = new JFileChooser();

            //In response to a button click:
            int returnVal = fc.showOpenDialog(frame);
            BufferedImage image = ImageIO.read(new File("E:/test.png"));
            frame.canvas.image = image;
            frame.canvas.graphics = (Graphics2D) frame.canvas.image.getGraphics();
            frame.repaint();
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void reset(ActionEvent e) {
             frame.canvas.createOffscreenImage();
             frame.repaint();
    }
    private void exit(ActionEvent e) {
        frame.dispose();
        System.exit(0);
    }

}