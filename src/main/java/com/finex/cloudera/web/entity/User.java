package com.finex.cloudera.web.entity;


import java.sql.Date;
import java.util.Arrays;

/**
 * 目标：创建用户类User
 * 时间：2017.03.30
 * 版本：v1.0.0
 * @author lordorr
 */
public class User {
    Integer id;   //id
    Integer userId;  //用户编号
    String userName; //用户名
    String userFullyName;//用户全名
    String password;  //密码
    String phone;    //电话号码
    String address;//地址
    String zipCode; //邮编
    String userEmail;//邮箱
    byte[] headThumb; //头像
    Date birth;//出生年月日
    String lockStatus;//是否锁定;Y OR N
    String isOnline;//是否在线：Y OR N
    String lastLoginIP;//最近登录IP
    java.sql.Date registerDate;//用户注册时间
    String question;//用户密码设置问题
    String answer;//密码设置问题答案
    Date lastLoninDate;//最近登录时间
    Date lastLogoutDate;//最近推出时间
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserFullyName() {
        return userFullyName;
    }
    public void setUserFullyName(String userFullyName) {
        this.userFullyName = userFullyName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public byte[] getHeadThumb() {
        return headThumb;
    }
    public void setHeadThumb(byte[] headThumb) {
        this.headThumb = headThumb;
    }
    public Date getBirth() {
        return birth;
    }
    public void setBirth(java.sql.Date birth) {
        this.birth = birth;
    }
    public String getLockStatus() {
        return lockStatus;
    }
    public void setLockStatus(String lockStatus) {
        this.lockStatus = lockStatus;
    }
    public String isOnline() {
        return isOnline;
    }
    public void setOnline(String isOnline) {
        this.isOnline = isOnline;
    }
    public String getLastLoginIP() {
        return lastLoginIP;
    }
    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }
    public Date getRegisterDate() {
        return registerDate;
    }
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public Date getLastLoninDate() {
        return lastLoninDate;
    }
    public void setLastLoninDate(Date lastLoninDate) {
        this.lastLoninDate = lastLoninDate;
    }
    public Date getLastLogoutDate() {
        return lastLogoutDate;
    }
    public void setLastLogoutDate(Date lastLogoutDate) {
        this.lastLogoutDate = lastLogoutDate;
    }
    public User() {
        super();
    }
    public User(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }
    public User(Integer id, Integer userId, String userName, String userFullyName, String password, String phone,
                String address, String zipCode, String userEmail, byte[] headThumb, Date birth, String lockStatus,
                String isOnline, String lastLoginIP, Date registerDate, String question, String answer, Date lastLoninDate,
                Date lastLogoutDate) {
        super();
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userFullyName = userFullyName;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.zipCode = zipCode;
        this.userEmail = userEmail;
        this.headThumb = headThumb;
        this.birth = birth;
        this.lockStatus = lockStatus;
        this.isOnline = isOnline;
        this.lastLoginIP = lastLoginIP;
        this.registerDate = registerDate;
        this.question = question;
        this.answer = answer;
        this.lastLoninDate = lastLoninDate;
        this.lastLogoutDate = lastLogoutDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userFullyName='" + userFullyName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", headThumb=" + Arrays.toString(headThumb) +
                ", birth=" + birth +
                ", lockStatus='" + lockStatus + '\'' +
                ", isOnline='" + isOnline + '\'' +
                ", lastLoginIP='" + lastLoginIP + '\'' +
                ", registerDate=" + registerDate +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", lastLoninDate=" + lastLoninDate +
                ", lastLogoutDate=" + lastLogoutDate +
                '}';
    }
}
