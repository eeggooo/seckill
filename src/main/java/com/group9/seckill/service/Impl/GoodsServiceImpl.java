package com.group9.seckill.service.Impl;

import com.group9.seckill.Util.PageUtil;
import com.group9.seckill.dao.GoodsDao;
import com.group9.seckill.entity.Goods;
import com.group9.seckill.entity.MiaoShaGoods;
import com.group9.seckill.service.GoodsService;
import com.group9.seckill.vo.GoodsAndPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;

    @Override
    public GoodsAndPage selectGoodsByPage(String pageNum){
        PageUtil pageUtil=new PageUtil();
        GoodsAndPage goodsAndPage=new GoodsAndPage();
        pageUtil.setPageNum(Integer.parseInt(pageNum));
        pageUtil.setPagesize(6);
        pageUtil.setTotalCount(goodsDao.getGoodsCounts());
        goodsAndPage.setGoods(goodsDao.selectGoodsByPage(pageUtil));
        goodsAndPage.setPageUtil(pageUtil);
        return goodsAndPage;
    }

    @Override
    public MiaoShaGoods selectMiaoShaGoodsByGoodsId(int goodsId) {

        return goodsDao.selectMiaoShaGoodsByGoodsId(goodsId);
    }

    @Override
    public MiaoShaGoods selectGoodsByMiaoShaGoodsId(int miaoshaGoodsId) {

        return goodsDao.selectMiaoShaGoodsByMiaoShaGoodsId(miaoshaGoodsId);
    }

    @Override
    public int getGoodsCounts() {

        return goodsDao.getGoodsCounts();
    }


    @Override
    public List<Goods> selectAllGoods() {

        return goodsDao.selectAllGoods();
    }
}
