package com.group9.seckill.controller;

import com.group9.seckill.Util.RedisUtil;
import com.group9.seckill.entity.MiaoShaGoods;
import com.group9.seckill.entity.UserInfo;
import com.group9.seckill.service.GoodsService;
import com.group9.seckill.vo.GoodsAndPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    RedisUtil redisUtil;

    @GetMapping("/showGoods")
    @ResponseBody
    public GoodsAndPage showGoods(String pageNum){

        return goodsService.selectGoodsByPage(pageNum);
    }
    @RequestMapping("/showDetail/{goodsId}")
    public ModelAndView showGoodsDetails(ModelAndView modelAndView,
                                         @PathVariable("goodsId") int goodsId){

        modelAndView.setViewName("product");
        MiaoShaGoods miaoShaGoods = goodsService.selectMiaoShaGoodsByGoodsId(goodsId);
        modelAndView.addObject("miaoShaGoods",miaoShaGoods);
        long beginTime = miaoShaGoods.getBeginTime().getTime();
        long endTime = miaoShaGoods.getEndTime().getTime();
        long nowTime = new Date().getTime();
        int status;long interval=0;
        if(miaoShaGoods.getMiaoShaStock()<=0){
            status=3;
        }
        else {
            if (nowTime < beginTime) {
                interval=beginTime-nowTime;
                status = 0;
            }
            else if (nowTime > endTime) {
                status = 1;
            }
            else {
                interval=endTime-nowTime;
                status = 2;
            }
        }
        String key="goods"+miaoShaGoods.getMiaoShaGoodsId();
        long stock=redisUtil.lGetListSize(key);
        if(stock<=0) {
            for (int i = 0; i < miaoShaGoods.getMiaoShaStock(); i++) {
                redisUtil.Rpush(key, 1);
            }
        }
        modelAndView.addObject("goodsStatus",status);
        modelAndView.addObject("interval",interval);
        return  modelAndView;
    }
}
