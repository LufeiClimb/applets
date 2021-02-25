package com.applets.jijin.service.impl;

import java.util.List;
import com.applets.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.applets.jijin.mapper.JijinChiyouMapper;
import com.applets.jijin.domain.JijinChiyou;
import com.applets.jijin.service.IJijinChiyouService;
import com.applets.common.core.text.Convert;

/**
 * 持有基金Service业务层处理
 * 
 * @author LufeiClimb
 * @date 2021-02-25
 */
@Service
public class JijinChiyouServiceImpl implements IJijinChiyouService {
    @Autowired
    private JijinChiyouMapper jijinChiyouMapper;

    /**
     * 查询持有基金
     * 
     * @param id 持有基金ID
     * @return 持有基金
     */
    @Override
    public JijinChiyou selectJijinChiyouById(Long id) {
        return jijinChiyouMapper.selectJijinChiyouById(id);
    }

    /**
     * 查询持有基金列表
     * 
     * @param jijinChiyou 持有基金
     * @return 持有基金
     */
    @Override
    public List<JijinChiyou> selectJijinChiyouList(JijinChiyou jijinChiyou) {
        return jijinChiyouMapper.selectJijinChiyouList(jijinChiyou);
    }

    /**
     * 新增持有基金
     * 
     * @param jijinChiyou 持有基金
     * @return 结果
     */
    @Override
    public int insertJijinChiyou(JijinChiyou jijinChiyou) {
        return jijinChiyouMapper.insertJijinChiyou(jijinChiyou);
    }

    /**
     * 修改持有基金
     * 
     * @param jijinChiyou 持有基金
     * @return 结果
     */
    @Override
    public int updateJijinChiyou(JijinChiyou jijinChiyou) {
        jijinChiyou.setUpdateTime(DateUtils.getNowDate());
        return jijinChiyouMapper.updateJijinChiyou(jijinChiyou);
    }

    /**
     * 删除持有基金对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteJijinChiyouByIds(String ids) {
        return jijinChiyouMapper.deleteJijinChiyouByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除持有基金信息
     * 
     * @param id 持有基金ID
     * @return 结果
     */
    @Override
    public int deleteJijinChiyouById(Long id) {
        return jijinChiyouMapper.deleteJijinChiyouById(id);
    }
}
