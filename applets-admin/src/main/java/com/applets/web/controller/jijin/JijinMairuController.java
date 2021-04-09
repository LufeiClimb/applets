package com.applets.web.controller.jijin;

import com.applets.common.annotation.Log;
import com.applets.common.core.controller.BaseController;
import com.applets.common.core.domain.AjaxResult;
import com.applets.common.core.page.TableDataInfo;
import com.applets.common.enums.BusinessType;
import com.applets.common.utils.poi.ExcelUtil;
import com.applets.jijin.domain.JijinMairu;
import com.applets.jijin.service.IJijinMairuService;
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
 * 买入基金Controller
 *
 * @author LufeiClimb
 * @date 2021-02-25
 */
@Controller
@RequestMapping("/jijin/mairu")
public class JijinMairuController extends BaseController {
    private String prefix = "jijin/mairu";

    @Autowired private IJijinMairuService jijinMairuService;

    @RequiresPermissions("jijin:mairu:view")
    @GetMapping()
    public String mairu() {
        return prefix + "/mairu";
    }

    /** 查询买入基金列表 */
    @RequiresPermissions("jijin:mairu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JijinMairu jijinMairu) {
        startPage();
        List<JijinMairu> list = jijinMairuService.selectJijinMairuList(jijinMairu);
        return getDataTable(list);
    }

    /** 导出买入基金列表 */
    @RequiresPermissions("jijin:mairu:export")
    @Log(title = "买入基金", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JijinMairu jijinMairu) {
        List<JijinMairu> list = jijinMairuService.selectJijinMairuList(jijinMairu);
        ExcelUtil<JijinMairu> util = new ExcelUtil<JijinMairu>(JijinMairu.class);
        return util.exportExcel(list, "mairu");
    }

    /** 新增买入基金 */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /** 新增保存买入基金 */
    @RequiresPermissions("jijin:mairu:add")
    @Log(title = "买入基金", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JijinMairu jijinMairu) {
        return toAjax(jijinMairuService.insertJijinMairu(jijinMairu));
    }

    /** 修改买入基金 */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        JijinMairu jijinMairu = jijinMairuService.selectJijinMairuById(id);
        mmap.put("jijinMairu", jijinMairu);
        return prefix + "/edit";
    }

    /** 修改保存买入基金 */
    @RequiresPermissions("jijin:mairu:edit")
    @Log(title = "买入基金", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JijinMairu jijinMairu) {
        return toAjax(jijinMairuService.updateJijinMairu(jijinMairu));
    }

    /** 删除买入基金 */
    @RequiresPermissions("jijin:mairu:remove")
    @Log(title = "买入基金", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(jijinMairuService.deleteJijinMairuByIds(ids));
    }
}
