package com.lemon.web.auto.day06.section01.base;

import org.testng.annotations.Test;

public class Tester {

	public static void main(String[] args) {
//		Tester.f1();// 类名.类方法
//		f1();// 本类中，所有可以省略掉类名
		Tester tester = new Tester();
		tester.f2();//对象.对象方法
		
//		main是静态方法，不是对象方法，调用对象方法的是类，这里没有对象
//		只用对象方法中采用this对象
	}

	public static void f1() {
		System.out.println("Tester.f1()");
	}

	public void f2() {//谁能调用到f2---》对象
		//this--》调用当前方法的对象
		System.out.println("Tester.f2()");
		this.f3();//当前对象
		f3();//如果方法在本类，可以省略this
	}

	public void f3() {
		System.out.println("Tester.f3()");
	}
}
