package com.example.awtSample;

// press command + hover over an item: to see info on that item
import java.awt.*; // the * like in SQL indicates to grab "all" static objects from java.awt
                    // java.awt.event is a separate package from java.awt

// be weary of using *, because it's implicit and can confuse packages

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindow extends Frame { // Frame allows drawing of screen

    @Override
    public void paint(Graphics g) { // abstract window toolkit
        super.paint(g);
        Font sansSerifLarge = new Font("SansSerif", Font.BOLD, 18);
        Font sansSerifSmall = new Font("SansSerif", Font.BOLD, 12);
        g.setFont(sansSerifLarge);
        g.drawString("The Complete Java Developer Course", 60, 60);
        g.setFont(sansSerifSmall);
        g.drawString("By Bruno Reyes", 60, 100);
    }

    public MyWindow(String title){
        super(title);
        setSize(500, 140);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
