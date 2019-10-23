package com.luru.luru.entity;

/**
 * @author 胡满意
 * @date 2019/10/17
 */
public class Admin {
    int adminId;
    String adminName;
    String adminNicekName;
    String adminPassword;
    String adminEmail;
    int adminPhone;
    int adminPermission;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminNicekName() {
        return adminNicekName;
    }

    public void setAdminNicekName(String adminNicekName) {
        this.adminNicekName = adminNicekName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public int getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(int adminPhone) {
        this.adminPhone = adminPhone;
    }

    public int getAdminPermission() {
        return adminPermission;
    }

    public void setAdminPermission(int adminPermission) {
        this.adminPermission = adminPermission;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminNicekName='" + adminNicekName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminPhone=" + adminPhone +
                ", adminPermission=" + adminPermission +
                '}';
    }
}
