package com.applets.jijin.mapper;

import java.util.List;
import com.applets.jijin.domain.JijinShouyi;

/**
 * 收益历史Mapper接口
 *
 * @author LufeiClimb
 * @date 2021-02-26
 */
public interface JijinShouyiMapper {
    /**
     * 查询收益历史
     *
     * @param id 收益历史ID
     * @return 收益历史
     */
    public JijinShouyi selectJijinShouyiById(Long id);

    /**
     * 查询收益历史列表
     *
     * @param jijinShouyi 收益历史
     * @return 收益历史集合
     */
    public List<JijinShouyi> selectJijinShouyiList(JijinShouyi jijinShouyi);

    /**
     * 新增收益历史
     *
     * @param jijinShouyi 收益历史
     * @return 结果
     */
    public int insertJijinShouyi(JijinShouyi jijinShouyi);

    /**
     * 修改收益历史
     *
     * @param jijinShouyi 收益历史
     * @return 结果
     */
    public int updateJijinShouyi(JijinShouyi jijinShouyi);

    /**
     * 删除收益历史
     *
     * @param id 收益历史ID
     * @return 结果
     */
    public int deleteJijinShouyiById(Long id);

    /**
     * 批量删除收益历史
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJijinShouyiByIds(String[] ids);
}
