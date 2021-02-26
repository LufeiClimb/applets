package com.applets.jijin.domain;

import com.applets.common.annotation.Excel;
import com.applets.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 买入基金对象 jijin_mairu
 * 
 * @author LufeiClimb
 * @date 2021-02-25
 */
public class JijinMairu extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 基金代码 */
    @Excel(name = "基金代码")
    private String code;

    /** 基金名称 */
    @Excel(name = "基金名称")
    private String name;

    /** 买入时净值 */
    @Excel(name = "买入时净值")
    private String realValue;

    /** 买入份额 */
    @Excel(name = "买入份额")
    private String number;

    /** 买入金额 */
    @Excel(name = "买入金额")
    private String amount;

    /** 手续费 */
    @Excel(name = "手续费")
    private String charge;

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
    public void setRealValue(String realValue){
        this.realValue = realValue;
    }

    public String getRealValue(){
        return realValue;
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
    public void setCharge(String charge){
        this.charge = charge;
    }

    public String getCharge(){
        return charge;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("name", getName())
            .append("realValue", getRealValue())
            .append("number", getNumber())
            .append("amount", getAmount())
            .append("charge", getCharge())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
