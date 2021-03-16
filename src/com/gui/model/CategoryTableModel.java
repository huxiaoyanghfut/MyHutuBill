package com.gui.model;

import com.entity.Category;
import com.service.CategoryService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class CategoryTableModel implements TableModel {

    String[] columnNames = new String[]{"分类名称", "消费次数"};
    // 使用从Service返回的List作为TableModel的数据
    public List<Category> cs = new CategoryService().list();

    public CategoryTableModel(){

    }

    @Override
    public int getRowCount() {
        return cs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    //第一列返回消费类别名称，第二列返回消费记录数
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category h= cs.get(rowIndex);
        if(0==columnIndex){
            return h.name;
        }
        if(1==columnIndex){
            return h.getRecordNumber();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
