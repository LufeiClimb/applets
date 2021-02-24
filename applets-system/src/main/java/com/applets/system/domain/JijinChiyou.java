package com.applets.system.domain;

import com.applets.common.annotation.Excel;
import com.applets.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 持有基金对象 jijin_chiyou
 * 
 * @author LufeiClimb
 * @date 2021-02-24
 */
public class JijinChiyou extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 基金代码 */
    @Excel(name = "基金代码")
    private String daima;

    /** 基金名称 */
    @Excel(name = "基金名称")
    private String mingcheng;

    /** 最新估值 */
    @Excel(name = "最新估值")
    private String guzhi;

    /** 最新净值 */
    @Excel(name = "最新净值")
    private String jingzhi;

    public void setDaima(String daima){
        this.daima = daima;
    }

    public String getDaima(){
        return daima;
    }
    public void setMingcheng(String mingcheng){
        this.mingcheng = mingcheng;
    }

    public String getMingcheng(){
        return mingcheng;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("daima", getDaima())
            .append("mingcheng", getMingcheng())
            .append("guzhi", getGuzhi())
            .append("jingzhi", getJingzhi())
            .toString();
    }
}
