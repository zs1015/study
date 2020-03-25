package com.lemon.web.auto.testcase.register;

import com.lemon.web.auto.pojo.ExcelObject;

public class RegisterFailureData extends ExcelObject {
	private String phone;
	private String password;
	private String pwdConfirm;
	private String verifyCode;
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

	public String getPwdConfirm() {
		return pwdConfirm;
	}

	public void setPwdConfirm(String pwdConfirm) {
		this.pwdConfirm = pwdConfirm;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getExpectedTips() {
		return expectedTips;
	}

	public void setExpectedTips(String expectedTips) {
		this.expectedTips = expectedTips;
	}

	@Override
	public String toString() {
		return "RegisterFailureData [phone=" + phone + ", password=" + password + ", pwdConfirm=" + pwdConfirm
				+ ", verifyCode=" + verifyCode + ", expectedTips=" + expectedTips + "]";
	}

}
