package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class Focus extends JFrame
{
    JButton jb;
    JTextField jt;

    public Focus()
    {
        createAndShowGUI();
    }

    private void createAndShowGUI()
    {
        setTitle("grabFocus() vs requestFocusInWindow()");
        setLayout(new FlowLayout());
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jb=new JButton("Open Dialog");
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae)
            {
                showDialog();
            }
        });

        add(jb);

        jt=new JTextField(20);

        add(jt);
    }

    private void showDialog()
    {
        JDialog jd=new JDialog();
        jd.setLayout(new GridLayout(2,2));
        jd.setVisible(true);


        JLabel l1=new JLabel("Label 1");
        JLabel l2=new JLabel("Label 2");

        JTextField jt1=new JTextField(20);
        JTextField jt2=new JTextField(20);

        jd.add(l1);
        jd.add(jt1);
        jd.add(l2);
        jd.add(jt2);

        jt.requestFocusInWindow();
//        jt.grabFocus();

        jd.pack();
    }

    public static void main(String args[])
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                new Focus();
            }
        });
    }
}