package com.lemon.web.auto.day07.section01.testcase.login;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.annotations.DataProvider;

import com.lemon.web.auto.day07.section01.util.DataProviderUtils;
import com.lemon.web.auto.day07.section01.util.ExcelUtils;

/**
 * 可以去设计约束、规则
 * 		excel名称和测试用例方法名称形成一定的关系
 * 		反向测试用例方法名：login_failure_test_case
 * 		正向测试用例方法名：login_success_test_case
 * 
 * login_failure_test_case:按照_进行分割--Array
 * 设计方法一：
 * Array[0] -->login  -->功能对应的测试用例文件夹名和测试用例数据的文件的名称
 * Array[1] --> failure  -->表单的名称
 * 
 * 设计方法二：
 * Array[0] -->login  -->功能对应的测试用例文件夹名
 * Array[1] --> failure  -->Excel的名称
 * @author happy
 *
 */
public class LoginDataProvider {
	// 反向测试用例的数据提供者
	@DataProvider
	public static Object[][] dp1(Method method) {
		System.out.println("反向：------------------------------------");
		System.out.println(method.getName());
		
		return DataProviderUtils.getData("/testcase/login/login.xlsx", 0, LoginFailData.class);
	}

	// 正向测试用例的数据提供者
	@DataProvider
	public static Object[][] dp2(Method method) {
		System.out.println("正向：------------------------------------");
		System.out.println(method.getName());
		return DataProviderUtils.getData("/testcase/login/login.xlsx", 1, LoginSuccessData.class);
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		/**
		 * 测试用例的方法名称的设计是有讲究的
		 * 我们可以通过方法名去获得测试用例的excel路径，要封装到的类型
		 */
		String methodName = "login_failure_test_case";
		//分割
		String[] array = methodName.split("_");
		String folderName = array[0];//得到测试用例对应的目录名称  也是测试用例数据对应的类型  (LoginTester)
		String classPath = "com.lemon.web.auto.login.LoginTester";
		//com.lemon.web.auto.day07.section01.testcase.login.LoginTester
		//com.lemon.web.auto.day07.section01.testcase.register.RegisterTester
		Class clazz = Class.forName(classPath);
		
		String excelName = array[1];
		String excelPath = "/testcase/"+folderName+"/"+excelName+".xlsx";
		System.out.println(excelPath);
		ArrayList<Object> objs = ExcelUtils.readExcel(excelPath, 0, clazz);
		
	}
}
