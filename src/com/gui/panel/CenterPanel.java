package com.gui.panel;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    //拉伸比例
    private double rate;
    //显示的组件
    private JComponent c;
    //是否拉伸
    private boolean stretch;

    public CenterPanel(double rate, boolean stretch) {
        this.setLayout(null);
        this.rate = rate;
        this.stretch = stretch;
    }

    public CenterPanel(double rate) {
        this(rate, true);
    }

    public void repaint() {
        if (null != c) {
            Dimension containerSize = this.getSize();
            Dimension componentSize = c.getPreferredSize();
            if (stretch) {
                c.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
            } else {
                c.setSize(componentSize);
            }
            c.setLocation(containerSize.width / 2 - c.getSize().width / 2, containerSize.height / 2 - c.getSize().height / 2);
            super.repaint();
        }
    }

    public void show(JComponent p){
        this.c = p;
        Component[] cs = getComponents();
        for (Component c:cs){
            remove(c);
        }
        add(p);
        if(p instanceof WorkingPanel){
            ((WorkingPanel) p).updateData();
        }
        this.updateUI();
    }
}

