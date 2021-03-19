package com.service;

import com.dao.RecordDAO;
import com.entity.Record;
import com.gui.page.SpendPage;
import com.until.DateUtil;

import java.util.List;

public class SpendService {
    public SpendPage getSpendPage(){
        //消费记录
        RecordDAO recordDAO = new RecordDAO();
        //本月数据
        List<Record> thisMonthRecords = recordDAO.listThisMonth();
        //今日数据
        List<Record> todayRecords = recordDAO.listToday();
        //本月总天数
        int thisMonthTotalDay = DateUtil.thisMonthTotalDay();

        int monthSpend = 0;
        int todaySpend = 0;
        int avgSpendPerDay ;
        int monthAvailable ;
        int dayAvgAvailable ;
        int monthLeftDay;
        int usagePercentage;

        //预算
        int monthBudget = new ConfigService().getIntBudget();
        //统计本月消费
        for (Record record : thisMonthRecords){
            monthSpend += record.getSpend();

        }
        //统计本日消费
        for(Record record : todayRecords){
            todaySpend += record.getSpend();
        }
        //日均消费
        avgSpendPerDay = monthSpend/thisMonthTotalDay;
        //计算本月剩余
        monthAvailable = monthBudget - monthSpend;
        //
        dayAvgAvailable = monthAvailable/DateUtil.thisMonthLeftDay();
        //
        monthLeftDay = DateUtil.thisMonthLeftDay();
        //使用比例
        usagePercentage = monthSpend*100 / monthBudget;

        return new SpendPage(monthSpend,todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay,usagePercentage);
    }


}
