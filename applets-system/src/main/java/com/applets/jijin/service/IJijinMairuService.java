package com.applets.jijin.service;

import com.applets.jijin.domain.JijinMairu;

import java.util.List;

/**
 * 买入基金Service接口
 *
 * @author LufeiClimb
 * @date 2021-02-25
 */
public interface IJijinMairuService {
    /**
     * 查询买入基金
     *
     * @param id 买入基金ID
     * @return 买入基金
     */
    public JijinMairu selectJijinMairuById(Long id);

    /**
     * 查询买入基金列表
     *
     * @param jijinMairu 买入基金
     * @return 买入基金集合
     */
    public List<JijinMairu> selectJijinMairuList(JijinMairu jijinMairu);

    /**
     * 新增买入基金
     *
     * @param jijinMairu 买入基金
     * @return 结果
     */
    public int insertJijinMairu(JijinMairu jijinMairu);

    /**
     * 修改买入基金
     *
     * @param jijinMairu 买入基金
     * @return 结果
     */
    public int updateJijinMairu(JijinMairu jijinMairu);

    /**
     * 批量删除买入基金
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJijinMairuByIds(String ids);

    /**
     * 删除买入基金信息
     *
     * @param id 买入基金ID
     * @return 结果
     */
    public int deleteJijinMairuById(Long id);
}
