package com.lemon.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import com.google.common.io.Files;
import com.lemon.base.BasePage;

/**
 * @Title: ScreenShotUtil.java
 * @Description: TODO(截图的工具类)
 * @author 歪歪欧巴
 * @date 2019年11月26日
 * @Copyright:湖南省零檬信息技术有限公司. All rights reserved.
 */
public class ScreenShotUtil {
	public static File screenshot(String filePath) {
		// driver截图API
		File sourceFile = BasePage.getDriver().getScreenshotAs(OutputType.FILE);
		File targetFile = new File(filePath);
		try {
			// 当你的目标路径如果不存在 ，不会自动给你创建

			// Files.copy(sourceFile, targetFile);
			// 当你的目标路径如果不存在 ，自动给你创建
			FileUtils.copyFile(sourceFile, targetFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return targetFile;
	}
}
