package com.luru.luru.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 胡满意
 * @date 2019/10/17
 */
public class Payment {
    int paymentId;
    int paymentNumber;
    String paymentMutter;
    Date paymentTime;
    BigDecimal paymentMoney;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(int paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public String getPaymentMutter() {
        return paymentMutter;
    }

    public void setPaymentMutter(String paymentMutter) {
        this.paymentMutter = paymentMutter;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public BigDecimal getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(BigDecimal paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", paymentNumber=" + paymentNumber +
                ", paymentMutter='" + paymentMutter + '\'' +
                ", paymentTime=" + paymentTime +
                ", paymentMoney=" + paymentMoney +
                '}';
    }
}
