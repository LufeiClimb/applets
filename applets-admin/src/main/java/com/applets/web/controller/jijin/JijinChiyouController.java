package com.applets.web.controller.jijin;

import com.applets.common.annotation.Log;
import com.applets.common.core.controller.BaseController;
import com.applets.common.core.domain.AjaxResult;
import com.applets.common.core.page.TableDataInfo;
import com.applets.common.enums.BusinessType;
import com.applets.common.utils.poi.ExcelUtil;
import com.applets.jijin.domain.JijinChiyou;
import com.applets.jijin.service.IJijinChiyouService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 持有基金Controller
 *
 * @author LufeiClimb
 * @date 2021-02-26
 */
@Controller
@RequestMapping("/jijin/chiyou")
public class JijinChiyouController extends BaseController {
    private String prefix = "jijin/chiyou";

    @Autowired private IJijinChiyouService jijinChiyouService;

    @RequiresPermissions("jijin:chiyou:view")
    @GetMapping()
    public String chiyou() {
        return prefix + "/chiyou";
    }

    /** 查询持有基金列表 */
    @RequiresPermissions("jijin:chiyou:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JijinChiyou jijinChiyou) {
        startPage();
        List<JijinChiyou> list = jijinChiyouService.selectJijinChiyouList(jijinChiyou);
        return getDataTable(list);
    }

    /** 导出持有基金列表 */
    @RequiresPermissions("jijin:chiyou:export")
    @Log(title = "持有基金", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JijinChiyou jijinChiyou) {
        List<JijinChiyou> list = jijinChiyouService.selectJijinChiyouList(jijinChiyou);
        ExcelUtil<JijinChiyou> util = new ExcelUtil<JijinChiyou>(JijinChiyou.class);
        return util.exportExcel(list, "chiyou");
    }

    /** 新增持有基金 */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /** 新增保存持有基金 */
    @RequiresPermissions("jijin:chiyou:add")
    @Log(title = "持有基金", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JijinChiyou jijinChiyou) {
        return toAjax(jijinChiyouService.insertJijinChiyou(jijinChiyou));
    }

    /** 修改持有基金 */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        JijinChiyou jijinChiyou = jijinChiyouService.selectJijinChiyouById(id);
        mmap.put("jijinChiyou", jijinChiyou);
        return prefix + "/edit";
    }

    /** 修改保存持有基金 */
    @RequiresPermissions("jijin:chiyou:edit")
    @Log(title = "持有基金", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JijinChiyou jijinChiyou) {
        return toAjax(jijinChiyouService.updateJijinChiyou(jijinChiyou));
    }

    /** 删除持有基金 */
    @RequiresPermissions("jijin:chiyou:remove")
    @Log(title = "持有基金", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(jijinChiyouService.deleteJijinChiyouByIds(ids));
    }
}
