package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    public JComboBox<String> cb;
    //   JLabel label; // we’re drawing regular polygons
    JLabel sidesLabel; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape
    //
    JLabel shapes = new JLabel("Select one of the possible choices:");
    //shapes.setVisible(true);

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        Color a1[]={Color.WHITE,Color.BLACK};
        colorCombo = new JComboBox(a1) ;
        //create the colorCombo, containing the values: Random and Black

        String[] sh = { "REGULAR POLYGON", "TRIANGLE", "SQUARE", "CIRCLE"};
        cb = new JComboBox<String>(sh);

        System.out.println(cb.getSelectedItem());

        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
        add(shapes);
        add(cb);

    }
}
