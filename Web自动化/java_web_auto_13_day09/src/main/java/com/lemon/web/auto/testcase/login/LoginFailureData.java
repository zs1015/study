package com.lemon.web.auto.testcase.login;

import com.lemon.web.auto.pojo.ExcelObject;

public class LoginFailureData extends ExcelObject {
	// Phone Password ExpectedTips
	private String phone;
	private String password;
	private String expectedTips;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getExpectedTips() {
		return expectedTips;
	}

	public void setExpectedTips(String expectedTips) {
		this.expectedTips = expectedTips;
	}

	@Override
	public String toString() {
		return "LoginFailData [phone=" + phone + ", password=" + password + ", expectedTips=" + expectedTips + "]";
	}

}
