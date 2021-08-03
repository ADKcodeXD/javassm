package com.adk.ssm.domain;

import com.adk.ssm.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class Orders {
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private String orderDesc;
    private int orderStatus;
    private String orderStatusStr;
    private Integer peopleCount;
    private Product product;
    private Member member;
    private List<Passenger> passengerList;
    private int payType ;
    private String payTypeStr ;

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                ", orderSatus=" + orderStatus +
                ", orderSatusStr='" + orderStatusStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", product=" + product +
                ", member=" + member +
                ", passengerList=" + passengerList +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                '}';
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        if(orderTime!=null){
            orderTimeStr = DateUtils.dateToString(orderTime, "yyyy-MM-dd HH:mm:ss");
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr() {
        if (orderTime!=null){
            orderTimeStr= DateUtils.dateToString(orderTime,"yyyy-MM-dd HH:mm:ss");
        }
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusStr() {
            if(orderStatus ==1){
                orderStatusStr ="成功支付";
            }else if(orderStatus ==0){
                orderStatusStr ="未支付";
            }
        return orderStatusStr;
    }


    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {

        if(payType==1){
            payTypeStr="微信支付";
        }else if(payType==2){
            payTypeStr="支付宝支付";
        }else {
            payTypeStr="未支付";
        }
        return payTypeStr;
    }


}
