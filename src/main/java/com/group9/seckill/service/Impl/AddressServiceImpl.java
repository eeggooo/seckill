package com.group9.seckill.service.Impl;

import com.group9.seckill.dao.AddressDao;
import com.group9.seckill.entity.Address;
import com.group9.seckill.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressDao;

    @Override
    public boolean insertAddress(Address address) {
        return addressDao.insertAddress(address);
    }

    @Override
    public Address selectAddressById(int addressId) {
        return addressDao.selectAddressByAddressId(addressId);
    }

    @Override
    public List<Address> selectAddressByUserId(int userId) {

        return addressDao.selectAddressByUserId(userId);

    }
}
