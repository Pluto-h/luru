package com.luru.luru.entity;

/**
 * @author 胡满意
 * @date 2019/10/17
 */
public class Number {
    int numberId;
    String numberName;
    String numberPassword;
    String numberType;
    int numberState;

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

    public String getNumberName() {
        return numberName;
    }

    public void setNumberName(String numberName) {
        this.numberName = numberName;
    }

    public String getNumberPassword() {
        return numberPassword;
    }

    public void setNumberPassword(String numberPassword) {
        this.numberPassword = numberPassword;
    }

    public String getNumberType() {
        return numberType;
    }

    public void setNumberType(String numberType) {
        this.numberType = numberType;
    }

    public int getNumberState() {
        return numberState;
    }

    public void setNumberState(int numberState) {
        this.numberState = numberState;
    }

    @Override
    public String toString() {
        return "Number{" +
                "numberId=" + numberId +
                ", numberName='" + numberName + '\'' +
                ", numberPassword='" + numberPassword + '\'' +
                ", numberType='" + numberType + '\'' +
                ", numberState=" + numberState +
                '}';
    }
}
