package com.group9.seckill.vo;

import com.group9.seckill.Util.PageUtil;
import com.group9.seckill.entity.Goods;

import java.util.List;

public class GoodsAndPage {
    private PageUtil pageUtil;
    private List<Goods> goods;

    public PageUtil getPageUtil() {
        return pageUtil;
    }

    public void setPageUtil(PageUtil pageUtil) {
        this.pageUtil = pageUtil;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
