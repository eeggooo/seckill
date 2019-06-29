package com.group9.seckill.service;

import com.group9.seckill.entity.UserInfo;

public interface UserService {
    boolean checkUserName(String userName);
    boolean insertUserInfo(UserInfo userInfo);
    UserInfo selectUserNameAndPassword(UserInfo userInfo);

}
