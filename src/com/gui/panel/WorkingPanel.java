package com.gui.panel;

import javax.swing.*;

public abstract class WorkingPanel extends JPanel {
    //面板在显示的时候，都需要从数据库中读取信息，并显示在界面上
    public abstract void updateData();
    //
    public abstract void addListener();
}
