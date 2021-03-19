package com.service;

import com.dao.RecordDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.entity.Record;
import com.until.DateUtil;

public class ReportService {
    RecordDAO recordDAO = new RecordDAO();
    public int getDaySpend(Date date){
        List<Record> recordList = recordDAO.list(date);
        int daySpend = 0;
        for(Record r: recordList){
            daySpend += r.getSpend();
        }
        return daySpend;
    }

    public List<Record> listThisMonthRecords(){
        List<Record> records = new ArrayList<Record>();
        Calendar cal = Calendar.getInstance();
        Date monthBegin = DateUtil.monthBegin();
        cal.setTime(monthBegin);
        for (int i = 0; i < DateUtil.thisMonthTotalDay(); i++, cal.add(Calendar.DATE, 1)){
            Record record = new Record();
            Date date = cal.getTime();
            int spend = getDaySpend(date);
            record.setDate(date);
            record.setSpend(spend);
            records.add(record);
        }
        return records;
    }

}
