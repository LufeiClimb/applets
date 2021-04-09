package com.applets.jijin.mapper;

import com.applets.jijin.domain.JijinChiyou;

import java.util.List;

/**
 * 持有基金Mapper接口
 *
 * @author LufeiClimb
 * @date 2021-02-26
 */
public interface JijinChiyouMapper {
    /**
     * 查询持有基金
     *
     * @param id 持有基金ID
     * @return 持有基金
     */
    public JijinChiyou selectJijinChiyouById(Long id);

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
     * 删除持有基金
     *
     * @param id 持有基金ID
     * @return 结果
     */
    public int deleteJijinChiyouById(Long id);

    /**
     * 批量删除持有基金
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJijinChiyouByIds(String[] ids);
}
