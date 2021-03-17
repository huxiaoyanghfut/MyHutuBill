package com.gui.panel;


import com.entity.Category;
import com.gui.listener.CategoryListener;
import com.gui.model.CategoryTableModel;
import com.service.CategoryService;
import com.until.ColorUtil;
import com.until.GUIUtil;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CategoryPanel extends WorkingPanel{
    static{
        GUIUtil.useLNF();
    }
    public static CategoryPanel instance = new CategoryPanel();

    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");
    String[] columnNames = new String[]{"分类名称","消费次数"};

    public CategoryTableModel ctm = new CategoryTableModel();
    public JTable t =new JTable(ctm);

    public CategoryPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bAdd,bEdit,bDelete);
        JScrollPane sp =new JScrollPane(t);
        JPanel pSubmit = new JPanel();
        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);

        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);
        addListener();
    }

    public void addListener() {
        CategoryListener listener = new CategoryListener();
        bAdd.addActionListener(listener);
        bEdit.addActionListener(listener);
        bDelete.addActionListener(listener);

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(CategoryPanel.instance);
    }
    //在对分类数据进行增删改查之后更新面板
    public void updateData(){
        //
        ctm.cs = new CategoryService().list();
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);

        //如果消费分类表中无数据，则不允许删除和修改
        if(0 == ctm.cs.size()){
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        }else{
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }

    }
    public Category getSelectedCategory() {
        int index = t.getSelectedRow();
        return ctm.cs.get(index);

    }
}
