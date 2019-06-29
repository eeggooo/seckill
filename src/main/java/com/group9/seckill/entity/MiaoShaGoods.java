package com.group9.seckill.entity;

import java.util.Date;

public class MiaoShaGoods{
    private int miaoShaGoodsId;

    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    private int miaoShaPrice;

    private int miaoShaStock;

    private Date beginTime;

    private Date endTime;

    public int getMiaoShaGoodsId() {
        return miaoShaGoodsId;
    }

    public void setMiaoShaGoodsId(int miaoShaGoodsId) {
        this.miaoShaGoodsId = miaoShaGoodsId;
    }

    public int getMiaoShaPrice() {
        return miaoShaPrice;
    }

    public void setMiaoShaPrice(int miaoShaPrice) {
        this.miaoShaPrice = miaoShaPrice;
    }

    public int getMiaoShaStock() {
        return miaoShaStock;
    }

    public void setMiaoShaStock(int miaoShaStock) {
        this.miaoShaStock = miaoShaStock;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
