package com.group9.seckill.dao;

import com.group9.seckill.Util.PageUtil;
import com.group9.seckill.entity.Goods;
import com.group9.seckill.entity.MiaoShaGoods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface GoodsDao {
        List<Goods> selectGoodsByPage(PageUtil pageUtil);
        List<Goods> selectAllGoods();
        int getGoodsCounts();
        MiaoShaGoods selectMiaoShaGoodsByGoodsId(int goodsId);
        void reduceStock(int miaoshaGoodsId);
        MiaoShaGoods selectMiaoShaGoodsByMiaoShaGoodsId(int miaoshaGoodsId);
}
