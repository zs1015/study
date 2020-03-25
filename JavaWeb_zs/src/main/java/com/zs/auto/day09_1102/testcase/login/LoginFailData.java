package com.zs.auto.day09_1102.testcase.login;

import com.zs.auto.day09_1102.pojo.Excel;

public class LoginFailData extends Excel {
    private String mobilephone;
    private String password;
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

    public String getExpectedTips() {
        return expectedTips;
    }

    public void setExpectedTips(String expectedTips) {
        this.expectedTips = expectedTips;
    }

    @Override
    public String toString() {
        return "LoginFailData [mobilephone=" + mobilephone + ", password=" + password + ", expectedTips=" + expectedTips
                + ", getMobilephone()=" + getMobilephone() + ", getPassword()=" + getPassword() + ", getExpectedTips()="
                + getExpectedTips() + ", getRowNo()=" + getRowNo() + ", toString()=" + super.toString()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
    }

}
