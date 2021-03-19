package com.service;

import com.dao.RecordDAO;
import com.entity.Category;
import com.entity.Record;

import java.util.Date;

public class RecordService {
    RecordDAO recordDAO = new RecordDAO();

    public void add(int spend, Category c, String comment, Date date){
        Record record = new Record();
        record.setSpend(spend);
        record.setCid(c.id);
        record.setComment(comment);
        record.setDate(date);
        recordDAO.add(record);
    }
}
