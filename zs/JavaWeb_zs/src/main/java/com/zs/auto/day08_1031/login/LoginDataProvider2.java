package com.zs.auto.day08_1031.login;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;

import com.zs.auto.day07_1029.utils.ExcalTools;


public class LoginDataProvider2 {
   
    // 反向用例
    @DataProvider
    protected static Object[][] data_fail(){
        /*return new Object[][]{
            new Object[] {"","","用户名不能为空"},
            new Object[] {"asdf","","非法的手机号"},
            new Object[] {"13566667777","","密码不能为空"},
            new Object[] {"13566667777","1234554658686","账号信息错误"}
        };*/
        //反射获取Excel数据,保存在ArrayList中
        ArrayList<Object> read = ExcalTools.readExcal("/testcase/login.xlsx", 0, LoginFailData.class);
        // 创建一个二维数组,索引是读取到数据的size(有几行数据,就是几条用例)
        Object[][] datas = new Object[read.size()][];
        // 1. 遍历每条用例(即一个LoginFailData对象),
        // 2.每个对象保存在一个一维数组中,
        // 3.再放在数据提供者(@DataProvider)的二维数组中
        for (int i = 0; i < read.size(); i++) {
            LoginFailData loginFailData = (LoginFailData) read.get(i);//这句是废话
            Object[] itemArray = { loginFailData };
            datas[i] = itemArray;
        }
        return datas;
    }
    // 正向用例
   @DataProvider
    protected static Object[][] data_success(){
     //反射获取Excel数据,保存在ArrayList中
       ArrayList<Object> read = ExcalTools.readExcal("/testcase/login.xlsx", 1, LoginSuccessData.class);
       // 创建一个二维数组,索引是读取到数据的size(有几行数据,就是几条用例)
       Object[][] datas = new Object[read.size()][];
       // 1. 遍历每条用例(即一个LoginFailData对象),
       // 2.每个对象保存在一个一维数组中,
       // 3.再放在数据提供者(@DataProvider)的二维数组中
       for (int i = 0; i < read.size(); i++) {
           LoginSuccessData loginSuccessData = (LoginSuccessData) read.get(i);
           Object[] itemArray = { loginSuccessData };
           datas[i] = itemArray;
       }
       return datas;
   }
}