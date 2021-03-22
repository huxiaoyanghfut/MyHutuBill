package com.gui.panel;


import com.gui.listener.RecoverListener;
import com.until.ColorUtil;
import com.until.GUIUtil;

import javax.swing.JButton;
import javax.swing.JPanel;



public class RecoverPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }
    public static RecoverPanel instance = new RecoverPanel();

    JButton bRecover =new JButton("恢复");

    public RecoverPanel() {

        GUIUtil.setColor(ColorUtil.blueColor, bRecover);
        this.add(bRecover);
        addListener();

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {
        RecoverListener  recoverListener= new RecoverListener();
        bRecover.addActionListener(recoverListener);

    }
}
