package com.zs.auto.day07_1029.login;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;

import com.zs.auto.day07_1029.utils.DataproviderUtils;
import com.zs.auto.day07_1029.utils.ExcalTools;
/**
 * 可以去设计约束、规则
 *      excel名称和测试用例方法名称形成一定的关系
 *      反向测试用例方法名：login_failure_test_case
 *      正向测试用例方法名：login_success_test_case
 * 
 * login_failure_test_case:按照_进行分割--Array
 * 设计方法一：
 * Array[0] -->login  -->功能对应的测试用例文件夹名和测试用例数据的文件的名称
 * Array[1] --> failure  -->表单的名称
 * 
 * 设计方法二：
 * Array[0] -->login  -->功能对应的测试用例文件夹名
 * Array[1] --> failure  -->Excel的名称
 * @author Administrator
 *
 */
public class LoginDataProvider {
    // 反向用例
    @DataProvider
    protected static Object[][] login_fail_case(Method method) {
        System.out.println(method.getName()+":反向");
        return DataproviderUtils.getData("/testcase/login/login.xlsx", 0, LoginFailData.class);
    }

    // 正向用例
    @DataProvider
    protected static Object[][] login_success_case(Method method) {
        System.out.println(method.getName()+":正向");
        return DataproviderUtils.getData("/testcase/login/login.xlsx", 1, LoginSuccessData.class);
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        String methodName = "login_fail_case";
        String[] split = methodName.split("_");//得到测试用例对应的目录名称  也是测试用例数据对应的类型  (LoginTest)

        String folderName = split[0];
        String excelName = split[1];
        String excelPath = "/testcase/"+folderName+"/"+excelName+"/login.xlsx";
        System.out.println(excelPath);
        ArrayList<Object> read = ExcalTools.readExcal(excelPath, 0, LoginFailData.class);
        
        //测试用例的方法名称的设计是有讲究的
        //我们可以通过方法名去获得测试用例的excel路径，要封装到的类型
        String className ="com.zs.auto.day07_1029.login.LoginTest";
        Class<?> clazz = Class.forName(className);
        ArrayList<Object> read1 = ExcalTools.readExcal(excelPath, 0, clazz);

    }
}