package com.lemon.web.auto.day05.section01;

public class CodeTester {

	/**
	 * 验证码：
	 * 		1：万能验证码：让开发写死：测试环境没问题，预生产、生产环境下的客户猜不到（推荐1）
	 * 			1）前程贷 hapi   2)柠檬班app测试后台：LM19
	 * 		2：开发去掉：测试环境没问题，预生产、生产环境下肯定是不行
	 * 		3：识别：利用图像识别技术进行识别（如果一个验证码能轻易的进行识别，这个验证码还有啥用？？--》提bug）
	 * 			1）12306哪杯是茅台
	 * 			2）识别还会有误差
	 * 			3）不具备通用性
	 * 		4：cookie绕过验证码（推荐2）
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
	}
}
