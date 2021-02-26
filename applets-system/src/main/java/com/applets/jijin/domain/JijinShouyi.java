package com.applets.jijin.domain;

import java.util.Date;

import com.applets.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.applets.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 收益历史对象 jijin_shouyi
 * 
 * @author LufeiClimb
 * @date 2021-02-26
 */
public class JijinShouyi extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 基金代码 */
    @Excel(name = "基金代码")
    private String code;

    /** 基金名称 */
    @Excel(name = "基金名称")
    private String name;

    /** 购买平台 */
    @Excel(name = "购买平台")
    private String pingtai;

    /** 基金组合 */
    @Excel(name = "基金组合")
    private String zuhe;

    /** 单位净值 */
    @Excel(name = "单位净值")
    private String jingzhi;

    /** 涨跌幅 */
    @Excel(name = "涨跌幅")
    private String zhangfu;

    /** 持有成本 */
    @Excel(name = "持有成本")
    private String cost;

    /** 持有份额 */
    @Excel(name = "持有份额")
    private String fene;

    /** 总金额 */
    @Excel(name = "总金额")
    private String jine;

    /** 总盈亏 */
    @Excel(name = "总盈亏")
    private String yingkui;

    /** 总收益率 */
    @Excel(name = "总收益率")
    private String shouyilv;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

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
    public void setPingtai(String pingtai){
        this.pingtai = pingtai;
    }

    public String getPingtai(){
        return pingtai;
    }
    public void setZuhe(String zuhe){
        this.zuhe = zuhe;
    }

    public String getZuhe(){
        return zuhe;
    }
    public void setJingzhi(String jingzhi){
        this.jingzhi = jingzhi;
    }

    public String getJingzhi(){
        return jingzhi;
    }
    public void setZhangfu(String zhangfu){
        this.zhangfu = zhangfu;
    }

    public String getZhangfu(){
        return zhangfu;
    }
    public void setCost(String cost){
        this.cost = cost;
    }

    public String getCost(){
        return cost;
    }
    public void setFene(String fene){
        this.fene = fene;
    }

    public String getFene(){
        return fene;
    }
    public void setJine(String jine){
        this.jine = jine;
    }

    public String getJine(){
        return jine;
    }
    public void setYingkui(String yingkui){
        this.yingkui = yingkui;
    }

    public String getYingkui(){
        return yingkui;
    }
    public void setShouyilv(String shouyilv){
        this.shouyilv = shouyilv;
    }

    public String getShouyilv(){
        return shouyilv;
    }
    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("name", getName())
            .append("pingtai", getPingtai())
            .append("zuhe", getZuhe())
            .append("jingzhi", getJingzhi())
            .append("zhangfu", getZhangfu())
            .append("cost", getCost())
            .append("fene", getFene())
            .append("jine", getJine())
            .append("yingkui", getYingkui())
            .append("shouyilv", getShouyilv())
            .append("date", getDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}