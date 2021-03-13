package com.test;

import com.until.GUIUtil;

import javax.swing.*;

public class showPanelTest {
    public static void main(String[] args) {
        JPanel p = new JPanel();
        p.add(new JButton("按钮1"));
        p.add(new JButton("按钮2"));
        GUIUtil.showPanel(p);
        GUIUtil.showPanel(p, 0.2);
    }
}
