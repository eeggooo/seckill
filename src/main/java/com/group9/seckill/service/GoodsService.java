package com.group9.seckill.service;

import com.group9.seckill.entity.Goods;
import com.group9.seckill.entity.MiaoShaGoods;
import com.group9.seckill.vo.GoodsAndPage;

import java.util.List;

public interface GoodsService {
    GoodsAndPage selectGoodsByPage(String pageNum);
    List<Goods> selectAllGoods();
    int getGoodsCounts();
    MiaoShaGoods selectMiaoShaGoodsByGoodsId(int goodsId);
    MiaoShaGoods selectGoodsByMiaoShaGoodsId(int miaoshaGoodsId);
}
