package com.zs.auto.day07_1029.utils;

import java.util.ArrayList;

import com.zs.auto.day07_1029.pojo.Excel;

public class DataproviderUtils {
    /**
     * 获取数据的公共方法
     * @param excelPath 
     * @param sheet
     * @param class1
     * @return
     */
    // 类型要是基于继承于Excel类型
    public static Object[][] getData(String excelPath, int sheet, Class<? extends Excel> class1) {
        // 反射获取Excel数据,保存在ArrayList中
        ArrayList<Object> read = ExcalTools.readExcal(excelPath, sheet, class1);
        // 创建一个二维数组,索引是读取到数据的size(有几行数据,就是几条用例)
        Object[][] datas = new Object[read.size()][];
        // 1. 遍历每条用例(即一个LoginFailData对象),
        // 2.每个对象保存在一个一维数组中,
        // 3.再放在数据提供者(@DataProvider)的二维数组中
        for (int i = 0; i < read.size(); i++) {
            Object[] itemArray = { read.get(i) };
            datas[i] = itemArray;
        }
        return datas;
    }

}
