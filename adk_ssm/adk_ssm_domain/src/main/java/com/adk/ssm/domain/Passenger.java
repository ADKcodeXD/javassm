package com.adk.ssm.domain;

public class Passenger {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private int crednitalsType;
    private String crednitalsTypeStr;
    private String crednitalsNum;
    private int traverllerType;
    private String traverllerTypeStr;

    @Override
    public String toString() {
        return "Passenger{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", crednitalsType=" + crednitalsType +
                ", crednitalsTypeStr='" + crednitalsTypeStr + '\'' +
                ", crednitalsNum='" + crednitalsNum + '\'' +
                ", traverllerType=" + traverllerType +
                ", traverllerTypeStr='" + traverllerTypeStr + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getCrednitalsType() {
        return crednitalsType;
    }

    public void setCrednitalsType(int crednitalsType) {
        this.crednitalsType = crednitalsType;
    }

    public String getCrednitalsTypeStr() {
       if(crednitalsType==0){
           crednitalsTypeStr="其他证件";
       }else if (crednitalsType==1){
           crednitalsTypeStr="身份证";
       }else if (crednitalsType==2){
           crednitalsTypeStr="港澳台证件";
       }
       return crednitalsTypeStr;
    }


    public String getCrednitalsNum() {
        return crednitalsNum;
    }

    public void setCrednitalsNum(String crednitalsNum) {
        this.crednitalsNum = crednitalsNum;
    }

    public int getTraverllerType() {
        return traverllerType;
    }

    public void setTraverllerType(int traverllerType) {
        this.traverllerType = traverllerType;
    }

    public String getTraverllerTypeStr() {
        if(traverllerType==0){
            traverllerTypeStr="儿童";
        }else if(traverllerType==1){
            traverllerTypeStr="成人";
        }else if(traverllerType==2){
            traverllerTypeStr="老人";
        }else if(traverllerType==3){
            traverllerTypeStr="残疾人";
        }
        return traverllerTypeStr;
    }

    public void setTraverllerTypeStr(String traverllerTypeStr) {
        this.traverllerTypeStr = traverllerTypeStr;
    }
}
