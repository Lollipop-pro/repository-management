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
public class Outbound implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "out_id", type = IdType.AUTO)
    private Integer outId;

    private Integer goodsId;

    private Integer userId;

    private Integer addressId;

    private Integer outNum;

    private LocalDateTime outTime;

    private Integer deleted;

    private String goodsName;

    private Integer goodsNumber;

    private String userName;

    private String phone;

    private String addressName;

    public Integer getOutId() {
        return outId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
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

    public Integer getOutNum() {
        return outNum;
    }

    public void setOutNum(Integer outNum) {
        this.outNum = outNum;
    }

    public LocalDateTime getOutTime() {
        return outTime;
    }

    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    @Override
    public String toString() {
        return "Outbound{" +
                "outId=" + outId +
                ", goodsId=" + goodsId +
                ", userId=" + userId +
                ", addressId=" + addressId +
                ", outNum=" + outNum +
                ", outTime=" + outTime +
                ", deleted=" + deleted +
                ", goodsName='" + goodsName + '\'' +
                ", goodsNumber=" + goodsNumber +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", addressName='" + addressName + '\'' +
                '}';
    }
}
