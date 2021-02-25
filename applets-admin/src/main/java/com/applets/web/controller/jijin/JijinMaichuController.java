package com.applets.web.controller.jijin;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.applets.common.annotation.Log;
import com.applets.common.enums.BusinessType;
import com.applets.jijin.domain.JijinMaichu;
import com.applets.jijin.service.IJijinMaichuService;
import com.applets.common.core.controller.BaseController;
import com.applets.common.core.domain.AjaxResult;
import com.applets.common.utils.poi.ExcelUtil;
import com.applets.common.core.page.TableDataInfo;

/**
 * 卖出基金Controller
 * 
 * @author LufeiClimb
 * @date 2021-02-25
 */
@Controller
@RequestMapping("/jijin/maichu")
public class JijinMaichuController extends BaseController {
    private String prefix = "jijin/maichu";

    @Autowired
    private IJijinMaichuService jijinMaichuService;

    @RequiresPermissions("jijin:maichu:view")
    @GetMapping()
    public String maichu()
    {
        return prefix + "/maichu";
    }

    /**
     * 查询卖出基金列表
     */
    @RequiresPermissions("jijin:maichu:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(JijinMaichu jijinMaichu) {
        startPage();
        List<JijinMaichu> list = jijinMaichuService.selectJijinMaichuList(jijinMaichu);
        return getDataTable(list);
    }

    /**
     * 导出卖出基金列表
     */
    @RequiresPermissions("jijin:maichu:export")
    @Log(title = "卖出基金", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JijinMaichu jijinMaichu) {
        List<JijinMaichu> list = jijinMaichuService.selectJijinMaichuList(jijinMaichu);
        ExcelUtil<JijinMaichu> util = new ExcelUtil<JijinMaichu>(JijinMaichu.class);
        return util.exportExcel(list, "maichu");
    }

    /**
     * 新增卖出基金
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存卖出基金
     */
    @RequiresPermissions("jijin:maichu:add")
    @Log(title = "卖出基金", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(JijinMaichu jijinMaichu) {
        return toAjax(jijinMaichuService.insertJijinMaichu(jijinMaichu));
    }

    /**
     * 修改卖出基金
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        JijinMaichu jijinMaichu = jijinMaichuService.selectJijinMaichuById(id);
        mmap.put("jijinMaichu", jijinMaichu);
        return prefix + "/edit";
    }

    /**
     * 修改保存卖出基金
     */
    @RequiresPermissions("jijin:maichu:edit")
    @Log(title = "卖出基金", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(JijinMaichu jijinMaichu) {
        return toAjax(jijinMaichuService.updateJijinMaichu(jijinMaichu));
    }

    /**
     * 删除卖出基金
     */
    @RequiresPermissions("jijin:maichu:remove")
    @Log(title = "卖出基金", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(jijinMaichuService.deleteJijinMaichuByIds(ids));
    }
}
