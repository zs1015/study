package com.lemon.web.auto.day08.section01.util;

import java.util.ArrayList;

import com.lemon.web.auto.day08.section01.pojo.ExcelObject;

public class DataProviderUtils {

	/**
	 * 数据提供者获取数据的公共方法
	 * @param excelPath
	 * @param sheetIndex
	 * @param clazz
	 * @return
	 */
	public static Object[][] getData(String excelPath, int sheetIndex, Class<? extends ExcelObject> clazz) {
		// 反射去取excel数据，封装到列表中
		ArrayList<Object> objs = ExcelUtils.readExcel(excelPath, sheetIndex, clazz);
		// 创建一个二维数组
		Object[][] datas = new Object[objs.size()][];
		// 遍历所有的LoginFailData对象，每个LoginFailData对象保存到一个一维数组--》4个一维数组--》二维数组
		for (int index = 0; index < objs.size(); index++) {
			Object[] itemArray = { objs.get(index) };// 每个LoginFailData对象保存到一个一维数组
			datas[index] = itemArray;// 把每个一维数组放到二维数组对应索引
		}
		return datas;
	}

}
