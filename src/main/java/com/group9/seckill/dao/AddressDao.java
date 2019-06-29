package com.group9.seckill.dao;

import com.group9.seckill.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AddressDao {
    List<Address> selectAddressByUserId(int userId);
    boolean insertAddress(Address address);
    Address selectAddressByAddressId(int addressId);
}
