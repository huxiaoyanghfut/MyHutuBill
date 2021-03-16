package com.gui.listener;

import com.entity.Category;
import com.gui.panel.CategoryPanel;
import com.service.CategoryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        CategoryPanel cp = CategoryPanel.instance;
        JButton b = (JButton) e.getSource();
        //
        if(b== cp.bAdd){
            //弹出文本输入框
            String name = JOptionPane.showInputDialog(null);
            //如果文本框为空，则弹出提醒框
            if(null == name){
                return;
            }
            if(0 == name.length()){
                JOptionPane.showMessageDialog(cp,"分类名称不能为空");
                return;
            }

            //调用CategoryService中add方法
            new CategoryService().add(name);
            cp.updateData();

        }
        if(b == cp.bEdit){
            //首先获取当前被选择的Category
            Category c = cp.getSelectedCategory();
            int id = c.id;
            //弹出文本输入框,初始框为
            String name = JOptionPane.showInputDialog("修改分类名称", c.name);
            //如果文本框为空，则弹出提醒框
            if(null == name){
                return;
            }
            if(0 == name.length()){
                JOptionPane.showMessageDialog(cp,"分类名称不能为空");
                return;
            }
            //调用CategoryService中update方法
            new CategoryService().update(id, name);
            cp.updateData();


        }
        if(b == cp.bDelete){
            Category c = cp.getSelectedCategory();
            if(0 != c.recordNumber){
                JOptionPane.showMessageDialog(cp,"本消费记录下有信息，拒绝删除！");
                return;
            }
            if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(cp,"确认要删除？"))
                return;

            int id = c.id;
            new CategoryService().delete(id);
            cp.updateData();

        }
    }
}
