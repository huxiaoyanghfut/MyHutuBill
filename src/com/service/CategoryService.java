package com.service;

import com.dao.CategoryDAO;
import com.dao.RecordDAO;
import com.entity.Category;
import com.entity.Record;

import java.util.Collections;
import java.util.List;

public class CategoryService {
    CategoryDAO categoryDAO = new CategoryDAO();
    RecordDAO recordDAO = new RecordDAO();
    public List<Category> list(){
        List<Category> cs = categoryDAO.list();
        for(Category c:cs){
            List<Record> rs = recordDAO.list(c.getId());
            c.recordNumber = rs.size();
        }
        cs.sort((c1, c2) -> c2.recordNumber - c1.recordNumber);
        return cs;
    }
    public void add(String name){
        Category category = new Category();
        category.setName(name);
        categoryDAO.add(category);
    }
    public void update(int id, String name){
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        categoryDAO.update(category);
    }
    public void delete(int id){
        categoryDAO.delete(id);
    }
}
