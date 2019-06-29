package com.group9.seckill.entity;

import java.util.Date;

public class OrderInfo {
    private  int order_id;

    private  String order_no;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Address address;

    private MiaoShaGoods miaoShaGoods;

    private UserInfo userInfo;

    private Date create_time;

    private Date pay_time;

    private int buy_count;

    private  String order_pay_no;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public MiaoShaGoods getMiaoShaGoods() {
        return miaoShaGoods;
    }

    public void setMiaoShaGoods(MiaoShaGoods miaoShaGoods) {
        this.miaoShaGoods = miaoShaGoods;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getPay_time() {
        return pay_time;
    }

    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }

    public int getBuy_count() {
        return buy_count;
    }

    public void setBuy_count(int buy_count) {
        this.buy_count = buy_count;
    }

    public String getOrder_pay_no() {
        return order_pay_no;
    }

    public void setOrder_pay_no(String order_pay_no) {
        this.order_pay_no = order_pay_no;
    }
}
