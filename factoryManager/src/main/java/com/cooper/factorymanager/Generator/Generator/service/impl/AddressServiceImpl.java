package com.cooper.factorymanager.Generator.Generator.service.impl;

import com.cooper.factorymanager.Generator.Generator.entity.Address;
import com.cooper.factorymanager.Generator.Generator.mapper.AddressMapper;
import com.cooper.factorymanager.Generator.Generator.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cooper
 * @since 2023-10-08
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
