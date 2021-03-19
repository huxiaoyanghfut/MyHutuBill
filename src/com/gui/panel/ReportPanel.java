package com.gui.panel;


import com.entity.Record;
import com.service.ReportService;
import com.until.ChartUtil;
import com.until.GUIUtil;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ReportPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }

    public static ReportPanel instance = new ReportPanel();

    public JLabel l = new JLabel();

    public ReportPanel() {
        updateData();
        this.add(l);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ReportPanel.instance);
    }

    @Override
    public void updateData() {
        List<Record> rs = new ReportService().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs,400, 300);
        ImageIcon icon= new ImageIcon(i);
        l.setIcon(icon);

    }

    @Override
    public void addListener() {

    }
}
