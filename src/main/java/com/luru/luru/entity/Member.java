package com.luru.luru.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author  胡满意
 * @date  2019/10/14
 */

public class Member {
    int memberId;
    String memberName;
    String memberNicakName;
    String memberPassword;
    String memberEmail;
    int memberPhone;
    String memberAlipay;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date memberLastLoginTime;
    BigDecimal memberBalance;
    BigDecimal memberWeekBalance;
    BigDecimal memberMonthBalance;

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberNicakName() {
        return memberNicakName;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public int getMemberPhone() {
        return memberPhone;
    }

    public BigDecimal getMemberWeekBalance() {
        return memberWeekBalance;
    }

    public void setMemberWeekBalance(BigDecimal memberWeekBalance) {
        this.memberWeekBalance = memberWeekBalance;
    }

    public void setMemberLastLoginTime(Date memberLastLoginTime) {
        this.memberLastLoginTime = memberLastLoginTime;
    }

    public BigDecimal getMemberMonthBalance() {
        return memberMonthBalance;
    }

    public void setMemberMonthBalanbce(BigDecimal memberMonthBalance) {
        this.memberMonthBalance = memberMonthBalance;
    }

    public String getMemberAlipay() {
        return memberAlipay;
    }


    public BigDecimal getMemberBalance() {
        return memberBalance;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setMemberNicakName(String memberNicakName) {
        this.memberNicakName = memberNicakName;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public void setMemberPhone(int memberPhone) {
        this.memberPhone = memberPhone;
    }

    public void setMemberAlipay(String memberAlipay) {
        this.memberAlipay = memberAlipay;
    }

    public void setMemberBalance(BigDecimal memberBalance) {
        this.memberBalance = memberBalance;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", memberNickName='" + memberNicakName + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberPhone=" + memberPhone +
                ", memberAlipay='" + memberAlipay + '\'' +
                ", memberLastLoginTime=" + memberLastLoginTime +
                ", memberBalance=" + memberBalance +
                ", memberWeekBalance=" + memberWeekBalance +
                ", memberMonthBalance=" + memberMonthBalance +
                '}';
    }
}
