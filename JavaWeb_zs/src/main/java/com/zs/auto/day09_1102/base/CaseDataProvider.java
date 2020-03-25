package com.zs.auto.day09_1102.base;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;

import com.zs.auto.day09_1102.utils.ExcalTools;

/**
 * 所有测试用例的数据提供者
 * @author Administrator
 */
public class CaseDataProvider {

    @DataProvider
    public static Object[][] dp(Method method) {
        //得到执行测试用例的方法名
        String methodName = method.getName();
        // 得到测试用例对应的目录名,功能名,文件夹名,测试用例数据对应的类名(LoginFailData)
        String[] split = methodName.split("_");
        String folderName = split[0];// 文件夹名字
        String excelName = split[1];// 检查点,Excel名称,类名的第二部分
        // 得到Excel的路径
        String excelPath = "/testcase/" + folderName + "/" + excelName + ".xlsx";
        // 测试用例的方法名称的设计是有讲究的
        // 我们可以通过方法名去获得测试用例的excel路径，要封装到的类型
        // 得到类名的两个部分(首字母大写)
        String classNameFirst = (folderName.charAt(0) + "").toUpperCase() + folderName.substring(1);
        String classNameSecond = (excelName.charAt(0) + "").toUpperCase() + excelName.substring(1);
        String totalClassName = classNameFirst + classNameSecond + "Data";
        // clazz-->LoginFailData
        String classPath = "com.zs.auto.day09_1102.testcase." + folderName + "." + totalClassName;
        Class<?> clazz = null;
        try {
            clazz = Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();//路径不存在
        }
        // 得到数据LIst
        ArrayList<Object> readExcal = ExcalTools.readExcal(excelPath, 0, clazz);
        // 组装成返回类型的二维数组
        // 创建一个二维数组,索引是读取到数据的size(有几行数据,就是几条用例)
        Object[][] datas = new Object[readExcal.size()][];
        // 1. 遍历每条用例(即一个LoginFailData对象),
        // 2.每个对象保存在一个一维数组中,
        // 3.再放在数据提供者(@DataProvider)的二维数组中
        for (int i = 0; i < readExcal.size(); i++) {
            Object[] itemArray = { readExcal.get(i) };
            datas[i] = itemArray;
        }
        return datas;
    }

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
     */
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 测试用例方法:login_fail_case  ---->LoginFailData
         * 测试用例方法:login_success_case  ---->LoginSuccessData
         * (测试用例执行过程中:数据在Excel中,页面级元素在xml中)
         * login:页面元素
         * fail:login_fail---确定数据来源
         *      通过login_fail确定要封装回去的类字节码(clazz)
         * case:固定写死(确定)
         */
        String methodName = "login_fail_case";
        // 得到测试用例对应的目录名,功能名,文件夹名,测试用例数据对应的类名(LoginFailData)
        String[] split = methodName.split("_");
        String folderName = split[0];// 文件夹名字
        String excelName = split[1];// 检查点,Excel名称,类名的第二部分
        // 得到Excel的路径
        String excelPath = "/testcase/" + folderName + "/" + excelName + ".xlsx";
        // 测试用例的方法名称的设计是有讲究的
        // 我们可以通过方法名去获得测试用例的excel路径，要封装到的类型
        // 得到类名的两个部分(首字母大写)
        String classNameFirst = (folderName.charAt(0) + "").toUpperCase() + folderName.substring(1);
        String classNameSecond = (excelName.charAt(0) + "").toUpperCase() + excelName.substring(1);
        String totalClassName = classNameFirst + classNameSecond + "Data";
        // System.out.println(totalClassName);
        // clazz-->LoginFailData
        String classPath = "com.zs.auto.day09_1102.testcase." + folderName + "." + totalClassName;
        // System.out.println(classPath);
        Class<?> clazz = Class.forName(classPath);
        ArrayList<Object> readExcal = ExcalTools.readExcal(excelPath, 0, clazz);
        for (Object object : readExcal) {
            System.out.println(object);
        }

    }
}
