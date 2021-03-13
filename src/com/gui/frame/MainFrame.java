package com.gui.frame;


import com.gui.panel.MainPanel;

import javax.swing.JFrame;



public class MainFrame extends JFrame{
    public static MainFrame instance = new MainFrame();

    private MainFrame(){
        this.setSize(500,450);
        this.setTitle("一本糊涂账");
        this.setContentPane(MainPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        instance.setVisible(true);
    }

}

