package com.group9.seckill.service.Impl;

import com.group9.seckill.dao.UserDao;
import com.group9.seckill.entity.UserInfo;
import com.group9.seckill.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public boolean insertUserInfo(UserInfo userInfo) {
        userInfo.setRegistTime(new Date());
        userInfo.setLastLoginTime(new Date());
//        连续两次加密
        userInfo.setUserPwd(DigestUtils.md5Hex(
                DigestUtils.md5Hex(
                        userInfo.getUserPwd()))
        );
        UserInfo user=userDao.selectUserInfoByUserName(userInfo.getUserName());
        if(user==null){
            return userDao.insertUserInfo(userInfo);
        }
        else{
            return false;
        }

    }

    @Override
    public UserInfo selectUserNameAndPassword(UserInfo userInfo) {
        //        连续两次加密
        userInfo.setUserPwd(DigestUtils.md5Hex(
                DigestUtils.md5Hex(
                        userInfo.getUserPwd()))
        );
        return userDao.selectUserNameAndPassword(userInfo);
    }

    @Override
    public boolean checkUserName(String UserName) {
        UserInfo userInfo =userDao.selectUserInfoByUserName(UserName);
        return userInfo!=null?true:false;
    }
}
