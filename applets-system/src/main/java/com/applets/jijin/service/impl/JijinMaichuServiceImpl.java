package com.applets.jijin.service.impl;

import com.applets.common.core.text.Convert;
import com.applets.common.utils.DateUtils;
import com.applets.jijin.domain.JijinMaichu;
import com.applets.jijin.mapper.JijinMaichuMapper;
import com.applets.jijin.service.IJijinMaichuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 卖出基金Service业务层处理
 *
 * @author LufeiClimb
 * @date 2021-02-25
 */
@Service
public class JijinMaichuServiceImpl implements IJijinMaichuService {
    @Autowired private JijinMaichuMapper jijinMaichuMapper;

    /**
     * 查询卖出基金
     *
     * @param id 卖出基金ID
     * @return 卖出基金
     */
    @Override
    public JijinMaichu selectJijinMaichuById(Long id) {
        return jijinMaichuMapper.selectJijinMaichuById(id);
    }

    /**
     * 查询卖出基金列表
     *
     * @param jijinMaichu 卖出基金
     * @return 卖出基金
     */
    @Override
    public List<JijinMaichu> selectJijinMaichuList(JijinMaichu jijinMaichu) {
        return jijinMaichuMapper.selectJijinMaichuList(jijinMaichu);
    }

    /**
     * 新增卖出基金
     *
     * @param jijinMaichu 卖出基金
     * @return 结果
     */
    @Override
    public int insertJijinMaichu(JijinMaichu jijinMaichu) {
        jijinMaichu.setCreateTime(DateUtils.getNowDate());
        return jijinMaichuMapper.insertJijinMaichu(jijinMaichu);
    }

    /**
     * 修改卖出基金
     *
     * @param jijinMaichu 卖出基金
     * @return 结果
     */
    @Override
    public int updateJijinMaichu(JijinMaichu jijinMaichu) {
        jijinMaichu.setUpdateTime(DateUtils.getNowDate());
        return jijinMaichuMapper.updateJijinMaichu(jijinMaichu);
    }

    /**
     * 删除卖出基金对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJijinMaichuByIds(String ids) {
        return jijinMaichuMapper.deleteJijinMaichuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除卖出基金信息
     *
     * @param id 卖出基金ID
     * @return 结果
     */
    @Override
    public int deleteJijinMaichuById(Long id) {
        return jijinMaichuMapper.deleteJijinMaichuById(id);
    }
}
