package com.gui.panel;


import com.gui.listener.BackupListener;
import com.until.ColorUtil;
import com.until.GUIUtil;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.gui.listener.BackupListener;



public class BackupPanel extends WorkingPanel {
    static{
        GUIUtil.useLNF();
    }

    public static BackupPanel instance = new BackupPanel();
    JButton bBackup =new JButton("备份");

    public BackupPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bBackup);
        this.add(bBackup);
        addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(BackupPanel.instance);
    }

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {
        BackupListener backupListener = new BackupListener();
        bBackup.addActionListener(backupListener);

    }
}
