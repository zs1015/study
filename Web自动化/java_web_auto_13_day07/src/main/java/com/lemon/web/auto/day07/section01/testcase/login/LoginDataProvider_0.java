package com.lemon.web.auto.day07.section01.testcase.login;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;

import com.lemon.web.auto.day07.section01.util.ExcelUtils;

public class LoginDataProvider_0 {
	// 反向测试用例的数据提供者
	@DataProvider
	public static Object[][] dp1() {
		// 反射去取excel数据，封装到列表中
		ArrayList<Object> objs = ExcelUtils.readExcel("/testcase/login/login.xlsx", 0, LoginFailData.class);
		// 创建一个二维数组
		Object[][] datas = new Object[objs.size()][];
		// 遍历所有的LoginFailData对象，每个LoginFailData对象保存到一个一维数组--》4个一维数组--》二维数组
		for (int index = 0; index < objs.size(); index++) {
			LoginFailData loginFailData = (LoginFailData) objs.get(index);
			Object[] itemArray = { loginFailData };// 每个LoginFailData对象保存到一个一维数组
			datas[index] = itemArray;// 把每个一维数组放到二维数组对应索引
		}
		return datas;
	}

	// 正向测试用例的数据提供者
	@DataProvider
	public static Object[][] dp2() {
		// 反射去取excel数据，封装到列表中
		ArrayList<Object> objs = ExcelUtils.readExcel("/testcase/login/login.xlsx", 1, LoginSuccessData.class);
		// 创建一个二维数组
		Object[][] datas = new Object[objs.size()][];
		// 遍历所有的LoginFailData对象，每个LoginFailData对象保存到一个一维数组--》4个一维数组--》二维数组
		for (int index = 0; index < objs.size(); index++) {
			LoginSuccessData loginFailData = (LoginSuccessData) objs.get(index);
			Object[] itemArray = { loginFailData };// 每个LoginFailData对象保存到一个一维数组
			datas[index] = itemArray;// 把每个一维数组放到二维数组对应索引
		}
		return datas;
	}
}
