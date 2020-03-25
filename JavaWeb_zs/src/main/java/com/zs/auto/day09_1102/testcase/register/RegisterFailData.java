package com.zs.auto.day09_1102.testcase.register;

import com.zs.auto.day09_1102.pojo.Excel;

//类名格式:功能模块名+检查点(正反)+Data
public class RegisterFailData extends Excel {

    private String mobilephone;
    private String password;
    private String pwdconfirm;
    private String verifycode;
    private String expectedTips;

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPwdconfirm() {
        return pwdconfirm;
    }

    public void setPwdconfirm(String pwdconfirm) {
        this.pwdconfirm = pwdconfirm;
    }

    public String getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode;
    }

    public String getExpectedTips() {
        return expectedTips;
    }

    public void setExpectedTips(String expectedTips) {
        this.expectedTips = expectedTips;
    }

    @Override
    public String toString() {
        return "RegisterFailData [mobilephone=" + mobilephone + ", password=" + password + ", pwdconfirm=" + pwdconfirm
                + ", verifycode=" + verifycode + ", expectedTips=" + expectedTips + ", getRowNo()=" + getRowNo() + "]";
    }

}
