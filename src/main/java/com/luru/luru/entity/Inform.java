package com.luru.luru.entity;

import java.util.Date;

/**
 * @author 胡满意
 * @date 2019/10/17
 */
public class Inform {
    int informId;
    String informHeadLine;
    String informContent;
    Date informTime;
    int informType;

    public int getInformType() {
        return informType;
    }

    public void setInformType(int informType) {
        this.informType = informType;
    }

    public int getInformId() {
        return informId;
    }

    public void setInformId(int informId) {
        this.informId = informId;
    }

    public String getInformHeadLine() {
        return informHeadLine;
    }

    public void setInformHeadLine(String informHeadLine) {
        this.informHeadLine = informHeadLine;
    }

    public String getInformContent() {
        return informContent;
    }

    public void setInformContent(String informContent) {
        this.informContent = informContent;
    }

    public Date getInformTime() {
        return informTime;
    }

    public void setInformTime(Date informTime) {
        this.informTime = informTime;
    }

    @Override
    public String toString() {
        return "Inform{" +
                "informId=" + informId +
                ", informHeadLine='" + informHeadLine + '\'' +
                ", informContent='" + informContent + '\'' +
                ", informTime=" + informTime +
                ", informType=" + informType +
                '}';
    }

}
