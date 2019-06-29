package com.group9.seckill.controller;

import com.group9.seckill.entity.Address;
import com.group9.seckill.entity.UserInfo;
import com.group9.seckill.service.AddressService;
import com.group9.seckill.service.Impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;
    @PostMapping("/insertAddress")
    @ResponseBody
    public Address insertAddress(HttpSession session, Address address){

        UserInfo userLoginInfo = (UserInfo)session.getAttribute("userInfo");
        if(addressService.insertAddress(address)){
            List<Address> addressList=addressService.selectAddressByUserId(userLoginInfo.getUserId());
            address=addressList.get(addressList.size()-1);
       };
        return address;

    }
}
