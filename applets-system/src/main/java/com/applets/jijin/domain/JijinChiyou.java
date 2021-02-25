package com.applets.jijin.domain;

import java.util.Date;

import com.applets.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.applets.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 持有基金对象 jijin_chiyou
 * 
 * @author LufeiClimb
 * @date 2021-02-25
 */
public class JijinChiyou extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 基金代码 */
    @Excel(name = "基金代码")
    private String code;

    /** 基金名称 */
    @Excel(name = "基金名称")
    private String name;

    /** 最新估值 */
    @Excel(name = "最新估值")
    private String guzhi;

    /** 最新净值 */
    @Excel(name = "最新净值")
    private String jingzhi;

    /** 当前持有成本 */
    @Excel(name = "当前持有成本")
    private String cost;

    /** 当前持有份额 */
    @Excel(name = "当前持有份额")
    private String number;

    /** 总金额 */
    @Excel(name = "总金额")
    private String amount;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date credateTime;

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }
    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setGuzhi(String guzhi){
        this.guzhi = guzhi;
    }

    public String getGuzhi(){
        return guzhi;
    }
    public void setJingzhi(String jingzhi){
        this.jingzhi = jingzhi;
    }

    public String getJingzhi(){
        return jingzhi;
    }
    public void setCost(String cost){
        this.cost = cost;
    }

    public String getCost(){
        return cost;
    }
    public void setNumber(String number){
        this.number = number;
    }

    public String getNumber(){
        return number;
    }
    public void setAmount(String amount){
        this.amount = amount;
    }

    public String getAmount(){
        return amount;
    }
    public void setCredateTime(Date credateTime){
        this.credateTime = credateTime;
    }

    public Date getCredateTime(){
        return credateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("name", getName())
            .append("guzhi", getGuzhi())
            .append("jingzhi", getJingzhi())
            .append("cost", getCost())
            .append("number", getNumber())
            .append("amount", getAmount())
            .append("updateTime", getUpdateTime())
            .append("credateTime", getCredateTime())
            .toString();
    }
}
