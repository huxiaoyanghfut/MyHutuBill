package com.test;

import com.service.CategoryService;
import com.service.ConfigService;

public class Test {
    public static void main(String[] args) {
        ConfigService cs= new ConfigService();
        System.out.println(cs.getIntBudget());
        CategoryService cs2 = new CategoryService();
        cs2.delete(1);

    }
}
