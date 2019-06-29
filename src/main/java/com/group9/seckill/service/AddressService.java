package com.group9.seckill.service;

import com.group9.seckill.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> selectAddressByUserId(int userId);
    boolean insertAddress(Address address);
    Address selectAddressById(int addressId);
}
