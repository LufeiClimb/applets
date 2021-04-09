package com.applets.web.controller.jijin;

import com.applets.common.annotation.Log;
import com.applets.common.core.controller.BaseController;
import com.applets.common.core.domain.AjaxResult;
import com.applets.common.core.page.TableDataInfo;
import com.applets.common.enums.BusinessType;
import com.applets.common.utils.poi.ExcelUtil;
import com.applets.jijin.domain.JijinShouyi;
import com.applets.jijin.service.IJijinShouyiService;
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
 * 收益历史Controller
 *
 * @author LufeiClimb
 * @date 2021-02-26
 */
@Controller
@RequestMapping("/jijin/shouyi")
public class JijinShouyiController extends BaseController {
    private String prefix = "jijin/shouyi";

    @Autowired private IJijinShouyiService jijinShouyiService;

    @RequiresPermissions("jijin:shouyi:view")
    @GetMapping()
    public String shouyi() {
        return prefix + "/shouyi";
    }

    /** 查询收益历史列表 */
    @RequiresPermissions("jijin:shouyi:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JijinShouyi jijinShouyi) {
        startPage();
        List<JijinShouyi> list = jijinShouyiService.selectJijinShouyiList(jijinShouyi);
        return getDataTable(list);
    }

    /** 导出收益历史列表 */
    @RequiresPermissions("jijin:shouyi:export")
    @Log(title = "收益历史", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JijinShouyi jijinShouyi) {
        List<JijinShouyi> list = jijinShouyiService.selectJijinShouyiList(jijinShouyi);
        ExcelUtil<JijinShouyi> util = new ExcelUtil<JijinShouyi>(JijinShouyi.class);
        return util.exportExcel(list, "shouyi");
    }

    /** 新增收益历史 */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /** 新增保存收益历史 */
    @RequiresPermissions("jijin:shouyi:add")
    @Log(title = "收益历史", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JijinShouyi jijinShouyi) {
        return toAjax(jijinShouyiService.insertJijinShouyi(jijinShouyi));
    }

    /** 修改收益历史 */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        JijinShouyi jijinShouyi = jijinShouyiService.selectJijinShouyiById(id);
        mmap.put("jijinShouyi", jijinShouyi);
        return prefix + "/edit";
    }

    /** 修改保存收益历史 */
    @RequiresPermissions("jijin:shouyi:edit")
    @Log(title = "收益历史", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JijinShouyi jijinShouyi) {
        return toAjax(jijinShouyiService.updateJijinShouyi(jijinShouyi));
    }

    /** 删除收益历史 */
    @RequiresPermissions("jijin:shouyi:remove")
    @Log(title = "收益历史", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(jijinShouyiService.deleteJijinShouyiByIds(ids));
    }
}
