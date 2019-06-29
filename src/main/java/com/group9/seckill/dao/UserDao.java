package com.group9.seckill.dao;

import com.group9.seckill.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
    UserInfo selectUserInfoByUserName(String UserName);
    boolean insertUserInfo(UserInfo userInfo);
    UserInfo selectUserNameAndPassword(UserInfo userInfo);
}
