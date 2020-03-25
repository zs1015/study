package com.zs.auto.day09_1102.pojo;

/**
 * Excel公用类:描述任意表单任意一行的抽象类
 * @author Administrator
 *
 */
public abstract class Excel {
    // Excel行号
    private int rowNo;

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    @Override
    public String toString() {
        return "Excel [rowNo=" + rowNo + "]";
    }
    

}
