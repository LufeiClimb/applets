package com.applets.jijin.service.impl;

import java.util.List;
import com.applets.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.applets.jijin.mapper.JijinMairuMapper;
import com.applets.jijin.domain.JijinMairu;
import com.applets.jijin.service.IJijinMairuService;
import com.applets.common.core.text.Convert;

/**
 * 买入基金Service业务层处理
 * 
 * @author LufeiClimb
 * @date 2021-02-25
 */
@Service
public class JijinMairuServiceImpl implements IJijinMairuService {
    @Autowired
    private JijinMairuMapper jijinMairuMapper;

    /**
     * 查询买入基金
     * 
     * @param id 买入基金ID
     * @return 买入基金
     */
    @Override
    public JijinMairu selectJijinMairuById(Long id) {
        return jijinMairuMapper.selectJijinMairuById(id);
    }

    /**
     * 查询买入基金列表
     * 
     * @param jijinMairu 买入基金
     * @return 买入基金
     */
    @Override
    public List<JijinMairu> selectJijinMairuList(JijinMairu jijinMairu) {
        return jijinMairuMapper.selectJijinMairuList(jijinMairu);
    }

    /**
     * 新增买入基金
     * 
     * @param jijinMairu 买入基金
     * @return 结果
     */
    @Override
    public int insertJijinMairu(JijinMairu jijinMairu) {
        return jijinMairuMapper.insertJijinMairu(jijinMairu);
    }

    /**
     * 修改买入基金
     * 
     * @param jijinMairu 买入基金
     * @return 结果
     */
    @Override
    public int updateJijinMairu(JijinMairu jijinMairu) {
        jijinMairu.setUpdateTime(DateUtils.getNowDate());
        return jijinMairuMapper.updateJijinMairu(jijinMairu);
    }

    /**
     * 删除买入基金对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJijinMairuByIds(String ids) {
        return jijinMairuMapper.deleteJijinMairuByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除买入基金信息
     * 
     * @param id 买入基金ID
     * @return 结果
     */
    @Override
    public int deleteJijinMairuById(Long id) {
        return jijinMairuMapper.deleteJijinMairuById(id);
    }
}
