package com.cooper.factorymanager.Generator.Generator.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cooper.factorymanager.Generator.Generator.Config.Result;
import com.cooper.factorymanager.Generator.Generator.entity.Outbound;
import com.cooper.factorymanager.Generator.Generator.entity.User;
import com.cooper.factorymanager.Generator.Generator.service.IOutboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cooper
 * @since 2023-10-08
 */
@RestController
@RequestMapping("/outbound")
public class OutboundController {

    @Autowired
    private IOutboundService outboundService;

    @GetMapping("/list")
    public Result<Map<String,Object>> getOutboundList(@RequestParam(value = "username" ,required = false) String userId,
                                                  @RequestParam (value = "phone" ,required = false) String goodsId,
                                                  @RequestParam (value = "pageNo") Long pageNo,
                                                  @RequestParam (value = "pageSize") Long pageSize){
        LambdaQueryWrapper<Outbound> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(userId),Outbound::getUserId,userId);
        wrapper.eq(StringUtils.hasLength(goodsId),Outbound::getGoodsId,goodsId);

        Page<Outbound> page = new Page<>(pageNo,pageSize);
        outboundService.page(page,wrapper);

        outboundService.getOutboundList(outboundService);

        Map<String,Object> data = new HashMap<>();

        data.put("total",page.getTotal());
        data.put("rows",page.getRecords());

        return Result.success(data);
    }

    @PostMapping
    public Result<?> addOutbound(@RequestBody Outbound outbound){
        outboundService.save(outbound);
        return Result.success("新增用户成功");
    }

    @PutMapping
    public Result<?> updateOutbound(@RequestBody Outbound outbound){
        outboundService.updateById(outbound);
        return Result.success("修改用户成功");
    }

    @GetMapping("/{id}")
    public Result<Outbound> getOutboundById(@PathVariable("id") Integer id){
        Outbound outbound = outboundService.getById(id);
        return Result.success(outbound);
    }

    @DeleteMapping("/{id}")
    public Result<Outbound> deleteOutboundById(@PathVariable("id") Integer id){
        outboundService.removeById(id);
        return Result.success("删除用户成功");
    }
}
