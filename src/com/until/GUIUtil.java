package com.until;

import com.gui.panel.CenterPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GUIUtil {
    private static String imageFolder = "src/img";

    //设置按钮图标
    public static void setImageIcon(JButton b, String fileName, String tip){

        ImageIcon i = new ImageIcon(new File(imageFolder,fileName).getPath());
        b.setIcon(i);
        b.setPreferredSize(new Dimension(61, 81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }
    //设置组件前景色
    public static void setColor(Color color, JComponent... cs){
        for(JComponent c: cs){
            c.setForeground(color);
        }
    }
    /**
     * @param p
     */
    public static void showPanel(JPanel p, double stretchRate){
        GUIUtil.useLNF();
        JFrame f = new JFrame();
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(stretchRate);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        cp.show(p);

    }

    public static void showPanel(JPanel p) {
        showPanel(p,0.85);
    }
    //校验一个输入框内容是否为空
    private static boolean checkEmpty(JTextField tf, String input) {
        String text = tf.getText().trim();
        if(0 == text.length()){
            JOptionPane.showMessageDialog(null,input + "不能为空");
            tf.grabFocus();
            return false;
        }
        return true;
    }
    //校验一个组件内容是否是数字格式
    public static boolean checkNumber(JTextField tf, String input) {
        if (!checkEmpty(tf, input))
            return false;
        String text = tf.getText().trim();
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(null, input + " 需要是整数");
            tf.grabFocus();
            return false;
        }
    }
    public static boolean checkZero(JTextField tf, String input) {
        if (!checkNumber(tf, input))
            return false;
        String text = tf.getText().trim();

        if (0 == Integer.parseInt(text)) {
            JOptionPane.showMessageDialog(null, input + " 不能为零");
            tf.grabFocus();
            return false;
        }
        return true;
    }

    public static int getInt(JTextField tf) {
        return Integer.parseInt(tf.getText());
    }


    //使用水晶界面
    public static void useLNF() {
        try{
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
