package com.applets.system.service;

import java.util.List;
import com.applets.system.domain.JijinChiyou;

/**
 * 持有基金Service接口
 * 
 * @author LufeiClimb
 * @date 2021-02-24
 */
public interface IJijinChiyouService {
    /**
     * 查询持有基金
     * 
     * @param daima 持有基金ID
     * @return 持有基金
     */
    public JijinChiyou selectJijinChiyouById(String daima);

    /**
     * 查询持有基金列表
     * 
     * @param jijinChiyou 持有基金
     * @return 持有基金集合
     */
    public List<JijinChiyou> selectJijinChiyouList(JijinChiyou jijinChiyou);

    /**
     * 新增持有基金
     * 
     * @param jijinChiyou 持有基金
     * @return 结果
     */
    public int insertJijinChiyou(JijinChiyou jijinChiyou);

    /**
     * 修改持有基金
     * 
     * @param jijinChiyou 持有基金
     * @return 结果
     */
    public int updateJijinChiyou(JijinChiyou jijinChiyou);

    /**
     * 批量删除持有基金
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJijinChiyouByIds(String ids);

    /**
     * 删除持有基金信息
     * 
     * @param daima 持有基金ID
     * @return 结果
     */
    public int deleteJijinChiyouById(String daima);
}
