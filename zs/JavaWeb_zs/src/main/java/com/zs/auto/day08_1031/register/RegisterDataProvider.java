package com.zs.auto.day08_1031.register;

import org.testng.annotations.DataProvider;


public class RegisterDataProvider {
   
    // 反向用例
    @DataProvider
    protected static Object[][] dataF(){
        return new Object[][]{
            new Object[] {"","","","","用户名不能为空"},
            new Object[] {"abcd","","","","非法的手机号"},
            new Object[] {"13555550000","","","","密码不能为空"},
            new Object[] {"13555550000","12345","","","密码长度至少为6位"},
            new Object[] {"13555550000","123456","","","重复密码不能为空"},
            new Object[] {"13555550000","123456","22222","","密码不一致"},
            new Object[] {"13555550000","123456","123456","","验证码不能为空"},
        };
    }
    // 正向用例
    @DataProvider
    protected static Object[][] dataZ(){
        return new Object[][]{
            new Object[] {"","","","","用户名不能为空"},
            new Object[] {"abcd","","","","非法的手机号"},
            new Object[] {"13566660000","","","","密码不能为空"},
            new Object[] {"13566660000","12345","","","密码长度至少为6位"},
            new Object[] {"13566660000","123456","","","重复密码不能为空"},
            new Object[] {"13566660000","123456","22222","","密码不一致"},
            new Object[] {"13566660000","123456","123456","","验证码不能为空"},
        };
    }
}
