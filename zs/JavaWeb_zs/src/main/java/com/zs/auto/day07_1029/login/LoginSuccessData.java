package com.zs.auto.day07_1029.login;

import com.zs.auto.day07_1029.pojo.Excel;

public class LoginSuccessData extends Excel {
    private String mobilephone;
    private String password;
    private String pratiaUrl;

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

    public String getPratiaUrl() {
        return pratiaUrl;
    }

    public void setPratiaUrl(String pratiaUrl) {
        this.pratiaUrl = pratiaUrl;
    }

    @Override
    public String toString() {
        return "LoginSuccessData [mobilephone=" + mobilephone + ", password=" + password + ", pratiaUrl=" + pratiaUrl
                + ", getRowNo()=" + getRowNo() + "]";
    }

}
