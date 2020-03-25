package com.zs.auto.day06_1026.section2.login;

import org.testng.annotations.DataProvider;


public class LoginDataProvider {
   
    // 反向用例
    @DataProvider
    protected static Object[][] dataF(){
        return new Object[][]{
            new Object[] {"","","用户名不能为空"},
            new Object[] {"asdf","","非法的手机号"},
            new Object[] {"13566667777","","密码不能为空"},
            new Object[] {"13566667777","1234554658686","账号信息错误"},
            new Object[] {"13888888888","123456",""}
        };
    }
    // 正向用例
//    @DataProvider
//    protected static Object[][] dataZ(){
//        return new Object[][]{
//            new Object[] {"","","","","用户名不能为空"},
//            new Object[] {"abcd","","","","非法的手机号"},
//            new Object[] {"13566660000","","","","密码不能为空"},
//            new Object[] {"13566660000","12345","","","密码长度至少为6位"},
//            new Object[] {"13566660000","123456","","","重复密码不能为空"},
//            new Object[] {"13566660000","123456","22222","","密码不一致"},
//            new Object[] {"13566660000","123456","123456","","验证码不能为空"},
//        };
//    }
}
