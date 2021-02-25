package com.applets.jijin.mapper;

import java.util.List;
import com.applets.jijin.domain.JijinMaichu;

/**
 * 卖出基金Mapper接口
 * 
 * @author LufeiClimb
 * @date 2021-02-25
 */
public interface JijinMaichuMapper {
    /**
     * 查询卖出基金
     * 
     * @param id 卖出基金ID
     * @return 卖出基金
     */
    public JijinMaichu selectJijinMaichuById(Long id);

    /**
     * 查询卖出基金列表
     * 
     * @param jijinMaichu 卖出基金
     * @return 卖出基金集合
     */
    public List<JijinMaichu> selectJijinMaichuList(JijinMaichu jijinMaichu);

    /**
     * 新增卖出基金
     * 
     * @param jijinMaichu 卖出基金
     * @return 结果
     */
    public int insertJijinMaichu(JijinMaichu jijinMaichu);

    /**
     * 修改卖出基金
     * 
     * @param jijinMaichu 卖出基金
     * @return 结果
     */
    public int updateJijinMaichu(JijinMaichu jijinMaichu);

    /**
     * 删除卖出基金
     * 
     * @param id 卖出基金ID
     * @return 结果
     */
    public int deleteJijinMaichuById(Long id);

    /**
     * 批量删除卖出基金
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteJijinMaichuByIds(String[] ids);
}
