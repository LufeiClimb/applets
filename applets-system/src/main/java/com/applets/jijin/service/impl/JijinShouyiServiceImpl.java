package com.applets.jijin.service.impl;

import java.util.List;
import com.applets.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.applets.jijin.mapper.JijinShouyiMapper;
import com.applets.jijin.domain.JijinShouyi;
import com.applets.jijin.service.IJijinShouyiService;
import com.applets.common.core.text.Convert;

/**
 * 收益历史Service业务层处理
 * 
 * @author LufeiClimb
 * @date 2021-02-26
 */
@Service
public class JijinShouyiServiceImpl implements IJijinShouyiService {
    @Autowired
    private JijinShouyiMapper jijinShouyiMapper;

    /**
     * 查询收益历史
     * 
     * @param id 收益历史ID
     * @return 收益历史
     */
    @Override
    public JijinShouyi selectJijinShouyiById(Long id) {
        return jijinShouyiMapper.selectJijinShouyiById(id);
    }

    /**
     * 查询收益历史列表
     * 
     * @param jijinShouyi 收益历史
     * @return 收益历史
     */
    @Override
    public List<JijinShouyi> selectJijinShouyiList(JijinShouyi jijinShouyi) {
        return jijinShouyiMapper.selectJijinShouyiList(jijinShouyi);
    }

    /**
     * 新增收益历史
     * 
     * @param jijinShouyi 收益历史
     * @return 结果
     */
    @Override
    public int insertJijinShouyi(JijinShouyi jijinShouyi) {
        jijinShouyi.setCreateTime(DateUtils.getNowDate());
        return jijinShouyiMapper.insertJijinShouyi(jijinShouyi);
    }

    /**
     * 修改收益历史
     * 
     * @param jijinShouyi 收益历史
     * @return 结果
     */
    @Override
    public int updateJijinShouyi(JijinShouyi jijinShouyi) {
        jijinShouyi.setUpdateTime(DateUtils.getNowDate());
        return jijinShouyiMapper.updateJijinShouyi(jijinShouyi);
    }

    /**
     * 删除收益历史对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJijinShouyiByIds(String ids) {
        return jijinShouyiMapper.deleteJijinShouyiByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除收益历史信息
     * 
     * @param id 收益历史ID
     * @return 结果
     */
    @Override
    public int deleteJijinShouyiById(Long id) {
        return jijinShouyiMapper.deleteJijinShouyiById(id);
    }
}
