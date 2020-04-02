package com.company;


import java.awt.*;
// NU am terminat de implementat
public class Rectangle extends java.awt.Rectangle {
    public Rectangle(int x0, int y0, int radius, int sides) {
        double alpha = 2 * Math.PI / sides;
        for (int i = 0; i < sides; i++) {
            double x = x0 ;
            double y = y0 ;
            this.add((int) x, (int) y);
        }
    }
}