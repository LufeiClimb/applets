package com.applets.jijin.domain;

import com.applets.common.annotation.Excel;
import com.applets.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 卖出基金对象 jijin_maichu
 *
 * @author LufeiClimb
 * @date 2021-02-25
 */
public class JijinMaichu extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 基金代码 */
    @Excel(name = "基金代码")
    private String code;

    /** 基金名称 */
    @Excel(name = "基金名称")
    private String name;

    /** 卖出时净值 */
    @Excel(name = "卖出时净值")
    private String realValue;

    /** 卖出份额 */
    @Excel(name = "卖出份额")
    private String number;

    /** 卖出金额 */
    @Excel(name = "卖出金额")
    private String amount;

    /** 手续费 */
    @Excel(name = "手续费")
    private String charge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealValue() {
        return realValue;
    }

    public void setRealValue(String realValue) {
        this.realValue = realValue;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
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
