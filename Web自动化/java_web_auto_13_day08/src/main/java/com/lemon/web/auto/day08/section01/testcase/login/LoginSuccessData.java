package com.lemon.web.auto.day08.section01.testcase.login;

import com.lemon.web.auto.day08.section01.pojo.ExcelObject;

public class LoginSuccessData extends ExcelObject {
	private String phone;
	private String password;
	private String partialUrl;

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

	public String getPartialUrl() {
		return partialUrl;
	}

	public void setPartialUrl(String partialUrl) {
		this.partialUrl = partialUrl;
	}

	@Override
	public String toString() {
		return "LoginSuccessData [phone=" + phone + ", password=" + password + ", partialUrl=" + partialUrl + "]";
	}

}
