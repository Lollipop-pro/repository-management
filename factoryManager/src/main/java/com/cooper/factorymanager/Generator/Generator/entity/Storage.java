package com.cooper.factorymanager.Generator.Generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author cooper
 * @since 2023-10-08
 */
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "in_id", type = IdType.AUTO)
    private Integer inId;

    private Integer goodsId;

    private Integer userId;

    private Integer addressId;

    private Integer inNum;

    private LocalDateTime inTime;

    private Integer deleted;

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    public Integer getInNum() {
        return inNum;
    }

    public void setInNum(Integer inNum) {
        this.inNum = inNum;
    }
    public LocalDateTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Storage{" +
            "inId=" + inId +
            ", goodsId=" + goodsId +
            ", userId=" + userId +
            ", addressId=" + addressId +
            ", inNum=" + inNum +
            ", inTime=" + inTime +
            ", deleted=" + deleted +
        "}";
    }
}
