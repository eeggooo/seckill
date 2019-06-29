package com.group9.seckill.controller;


import com.group9.seckill.Util.RedisUtil;
import com.group9.seckill.entity.*;
import com.group9.seckill.service.AddressService;
import com.group9.seckill.service.GoodsService;
import com.group9.seckill.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    AddressService addressService;
    @Autowired
    RedisUtil redisUtil;
    @GetMapping("/showCheckout/{miaoshaGoodsId}")
    public ModelAndView checkout(HttpSession session,@PathVariable("miaoshaGoodsId") int miaoshaGoodsId,
                                 ModelAndView modelAndView){
        UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
        if(userInfo==null){
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }
        else{

            MiaoShaGoods miaoShaGoods = goodsService.selectGoodsByMiaoShaGoodsId(miaoshaGoodsId);
            modelAndView.addObject("miaoshaGoods",miaoShaGoods);
            List<Address> address = addressService.selectAddressByUserId(userInfo.getUserId());
            modelAndView.addObject("userAddress",address);

            String key= "goods"+miaoshaGoodsId;
            System.out.println(key);
            Object o = redisUtil.lPop(key);
            if(o !=null) {
                OrderInfo orderInfo=orderService.doOrderInfo(miaoshaGoodsId, userInfo);
                session.setAttribute("orderInfo",orderInfo);
                modelAndView.setViewName("checkout");
            }
            return modelAndView;
        }

    }
    @GetMapping("/handleOrder/{miaoshaGoodsId}")
    public ModelAndView Chechout(HttpSession session, @PathVariable("miaoshaGoodsId") int miaoshaGoodsId,
                                     String selectAddress,
                                 ModelAndView modelAndView){

            UserInfo userIfo = (UserInfo)session.getAttribute("userInfo");
            if(userIfo==null){
                modelAndView.setViewName("redirect:/login");
                return  modelAndView;
            }
            else {
                    OrderInfo orderInfo=(OrderInfo)session.getAttribute("orderInfo");
                    orderInfo.setAddress(addressService.selectAddressById(Integer.parseInt(selectAddress)));
                    session.setAttribute("orderInfo",orderInfo);
                    modelAndView.setViewName("redirect:/alipay/pay");

                return modelAndView;
            }
    }
    @RequestMapping("/insert")
    public String insertOrder(HttpSession session){

        OrderInfo orderInfo = (OrderInfo) session.getAttribute("orderInfo");
        orderInfo.setOrder_pay_no(new Date().getTime()+String.valueOf(orderInfo.getMiaoShaGoods().getMiaoShaGoodsId()));
        orderService.updateOrderInfo(orderInfo);
        return "redirect:/";
    }
    @RequestMapping("/pay")
    public ModelAndView payOrder(HttpSession session,ModelAndView modelAndView){
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        if(userInfo==null){
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        else{
            List<OrderInfo> orderInfoList=orderService.selectOrder(userInfo);
            List<OrderInfo> orderInfoList1=new LinkedList<>();
            for(int i=0;i<orderInfoList.size();i++){
               if( orderInfoList.get(i).getPay_time()==null&&orderInfoList.get(i).getOrder_pay_no()==null){
                   orderInfoList.get(i).setMiaoShaGoods(
                           goodsService.selectGoodsByMiaoShaGoodsId(
                                   orderInfoList.get(i).getMiaoShaGoods().getMiaoShaGoodsId()));

                   orderInfoList1.add(orderInfoList.get(i));
               }
            }
            modelAndView.addObject("userAddress",addressService.selectAddressByUserId(userInfo.getUserId()));
            modelAndView.addObject("orderToPay",orderInfoList1);
            session.setAttribute("orderInfoList",orderInfoList1);
            modelAndView.setViewName("orderToPay");
            return modelAndView;
        }

    }
    @RequestMapping("/selectOrder/{orderId}")
    public ModelAndView selectOrder(HttpSession session,@PathVariable("orderId") String orderId,
                            String selectAddress,ModelAndView modelAndView){
        session.getAttribute("orderInfoList");
        List<OrderInfo> orderInfoList=(List<OrderInfo>) session.getAttribute("orderInfoList");
        OrderInfo orderInfo=orderInfoList.get(Integer.parseInt(orderId)-1);
        orderInfo.setAddress(addressService.selectAddressById(Integer.parseInt(selectAddress)));
        session.setAttribute("orderInfo",orderInfo);
        modelAndView.setViewName("redirect:/alipay/pay");
        System.out.println(1);
        return modelAndView;
    }
}
