package com.cooper.factorymanager.Generator.Generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cooper.factorymanager.Generator.Generator.entity.Outbound;
import com.cooper.factorymanager.Generator.Generator.mapper.OutboundMapper;
import com.cooper.factorymanager.Generator.Generator.service.IOutboundService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cooper
 * @since 2023-10-08
 */
@Service
public class OutboundServiceImpl extends ServiceImpl<OutboundMapper, Outbound> implements IOutboundService {

}
