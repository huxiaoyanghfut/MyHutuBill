package com.gui.panel;


import com.gui.page.SpendPage;
import com.until.CircleProgressBar;
import com.until.ColorUtil;
import com.until.GUIUtil;
import com.service.SpendService;

import javax.swing.JLabel;


import java.awt.*;

import javax.swing.JPanel;



public class SpendPanel extends WorkingPanel{
    static{
        GUIUtil.useLNF();
    }
    //单例模式
    public static SpendPanel instance = new SpendPanel();

    public JLabel lMonthSpend = new JLabel("本月消费");
    public JLabel lTodaySpend = new JLabel("今日消费");
    public JLabel lAvgSpendPerDay = new JLabel("日均消费");
    public JLabel lMonthLeft = new JLabel("本月剩余");
    public JLabel lDayAvgAvailable = new JLabel("日均可用");
    public JLabel lMonthLeftDay = new JLabel("距离月末");

    public JLabel vMonthSpend = new JLabel("￥2300");
    public JLabel vTodaySpend = new JLabel("￥25");
    public JLabel vAvgSpendPerDay = new JLabel("￥120");
    public JLabel vMonthAvailable = new JLabel("￥2084");
    public JLabel vDayAvgAvailable = new JLabel("￥389");
    public JLabel vMonthLeftDay = new JLabel("15天");

    CircleProgressBar bar;

    public SpendPanel() {
        this.setLayout(new BorderLayout());
        bar = new CircleProgressBar();
        bar.setBackgroundColor(ColorUtil.blueColor);

        GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
                lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
        GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);

        vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));

        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);

    }

    private JPanel center() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(west(), BorderLayout.WEST);
        p.add(east());

        return p;
    }

    private Component east() {
        return bar;
    }

    private Component west() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 1));
        p.add(lMonthSpend);
        p.add(vMonthSpend);
        p.add(lTodaySpend);
        p.add(vTodaySpend);
        return p;
    }

    private JPanel south() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 4));

        p.add(lAvgSpendPerDay);
        p.add(lMonthLeft);
        p.add(lDayAvgAvailable);
        p.add(lMonthLeftDay);
        p.add(vAvgSpendPerDay);
        p.add(vMonthAvailable);
        p.add(vDayAvgAvailable);
        p.add(vMonthLeftDay);

        return p;
    }

    public static void main(String[] args) {

        GUIUtil.showPanel(SpendPanel.instance);
    }

    @Override
    public void updateData() {
        SpendPage spendPage= new SpendService().getSpendPage();

        vMonthSpend.setText(spendPage.monthSpend);
        vTodaySpend.setText(spendPage.todaySpend);
        vAvgSpendPerDay.setText(spendPage.avgSpendPerDay);
        vMonthAvailable.setText(spendPage.monthAvailable);
        vDayAvgAvailable.setText(spendPage.dayAvgAvailable);
        vMonthLeftDay.setText(spendPage.monthLeftDay);
        bar.setProgress(spendPage.usagePercentage);
        if(spendPage.isOverSpend){
            GUIUtil.setColor(Color.red, vMonthSpend, vTodaySpend, vMonthAvailable);
            GUIUtil.setColor(Color.red, bar);
        }
        bar.setForegroundColor(ColorUtil.getByPercentage(spendPage.usagePercentage));



    }

    @Override
    public void addListener() {

    }
}