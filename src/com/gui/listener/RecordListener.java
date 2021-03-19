package com.gui.listener;

import com.entity.Category;
import com.gui.panel.CategoryPanel;
import com.gui.panel.MainPanel;
import com.gui.panel.RecordPanel;
import com.gui.panel.SpendPanel;
import com.service.RecordService;
import com.until.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class RecordListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        RecordPanel r = RecordPanel.instance;
        //如果combox框中为空，则提示添加消费分类
        if(0==r.cbModel.cs.size()){
            JOptionPane.showMessageDialog(r, "请添加消费分类！");
            MainPanel.instance.workingPanel.show(CategoryPanel.instance);
            return;
        }
        if(!GUIUtil.checkNumber(r.tfSpend, "消费金额")){
            return;
        }
        if(!GUIUtil.checkZero(r.tfSpend,"输入金额")){
            return;
        }
        int spend = Integer.parseInt(r.tfSpend.getText());
        Category c = r.getSelectedCategory();
        String comment = r.tfComment.getText();
        Date date = r.datePicker.getDate();
        new RecordService().add(spend, c, comment, date);
        JOptionPane.showMessageDialog(r, "添加成功!");

        MainPanel.instance.workingPanel.show(SpendPanel.instance);


    }
}
