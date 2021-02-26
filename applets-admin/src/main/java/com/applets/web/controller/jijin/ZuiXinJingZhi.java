package com.applets.web.controller.jijin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.applets.common.core.domain.AjaxResult;
import com.applets.common.utils.HttpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 我的基金的最新净值
 *
 * @author lufeixia
 * @version 1.0
 * @date 2020-4-16 09:54:43
 * @since 1.8
 */
@Api(value = "/jingzhi", tags = "基金净值")
@RestController
@RequestMapping("/jingzhi")
public class ZuiXinJingZhi {

    public static void main(String[] args) {
        ZuiXinJingZhi zuiXinJingZhi = new ZuiXinJingZhi();
        zuiXinJingZhi.test();
    }

    public void test() {
        ZuiXinJingZhi zuiXinJingZhi = new ZuiXinJingZhi();
        // System.out.println("净值");
        // zuiXinJingZhi.jingZhi();

        System.out.println("估值");
        zuiXinJingZhi.jiJinXinXi("001980");
    }

    @GetMapping("/jiJinXinXi/{code}")
    @ApiOperation(value = "基金信息")
    public AjaxResult jiJinXinXi(@PathVariable String code) {

        JSONObject result = new JSONObject();
        result.put("code", code);

        JSONObject param = new JSONObject();

        String cookie =
                "__hutmmobile=24CA630B-E0EA-4159-8D24-E25D00A0C337; welcome_fund_attention=true; FUNDID_COOKIE=COOKIE20200411000001208681; SESSION=2cb80d45-a9a9-4a9a-a46e-7bf56e498cd7; __hutmc=268394641; __hutmz=268394641.1614155536.2.1.hutmcsr=(direct)|hutmccn=(direct)|hutmcmd=(none); selectedFeatureType=lx; __hutma=268394641.800853052.1586582687.1614155536.1614262736.3; _hb_ref_pgid=SNM968; _hb_pgid=; __hutmb=268394641.6.10.1614262736; GM_VISIT_COOKIE=001980%2C000594%2C008868";
        String url = "https://www.howbuy.com/fund/" + code + "/";
        String formResult = HttpUtil.httpForm(url, param, cookie);

        Document totalDoc = Jsoup.parse(formResult);
        String name = totalDoc.getElementsByTag("h1").text().replace("(", "-").split("-")[0];
        result.put("name", name);

        String jingzhi = totalDoc.getElementsByClass("cRed").get(1).text();
        result.put("jingzhi", jingzhi);

        String date =
                totalDoc.getElementsByClass("b-0")
                        .get(0)
                        .text()
                        .replace("单位净值 [", "")
                        .replace("]", "");
        result.put("date", LocalDate.now().getYear() + "-" + date);

        String zhangfu = totalDoc.getElementsByClass("b-rate").get(0).text();
        result.put("zhangfu", zhangfu);

        param.put("jjdm", code);
        url = "https://www.howbuy.com/fund/ajax/gmfund/valuation/valuationnav.htm";
        formResult = HttpUtil.httpForm(url, param, cookie);
        totalDoc = Jsoup.parse(formResult);
        String guzhi = totalDoc.getElementsByClass("con_value").text();
        result.put("guzhi", guzhi);
        String guzhiriqi = totalDoc.getElementsByClass("tips_icon_con").text();
        result.put("guzhiriqi", guzhiriqi);

        return AjaxResult.success(result);
    }

    @GetMapping("/guZhi")
    @ApiOperation(value = "最新估值")
    public List<String> guZhi() {

        List<String> re = new ArrayList<>();
        JSONObject param = new JSONObject();
        param.put("jjdmstr", "110022,160632,161725,519933,000248,000961,001548,008173");
        String s =
                HttpUtil.httpForm(
                        "https://www.howbuy.com/fund/ajax/gmfund/fundnetestimatejson.htm",
                        param,
                        null);

        JSONArray jsonArray = JSONArray.parseArray(s);
        jsonArray.sort(
                (o1, o2) -> {
                    JSONObject a1 = (JSONObject) o1;
                    JSONObject a2 = (JSONObject) o2;
                    return a1.getString("code").compareTo(a2.getString("code"));
                });
        for (Object o : jsonArray) {
            JSONObject a = (JSONObject) o;
            // System.out.println(a.getString("jjjc"));
            System.out.println(a.getString("valuation"));
            re.add(a.getString("valuation"));
        }
        return re;
    }

    @GetMapping("/jingZhi")
    @ApiOperation(value = "最新净值")
    public List<String> jingZhi() {

        List<String> re = new ArrayList<>();
        JSONObject param = new JSONObject();
        // param.put("tabType", "2");
        String cookie =
                "__hutmz=268394641.1585122498.1.1.hutmcsr=(direct)|hutmccn=(direct)|hutmcmd=(none); __hutmmobile=F5C45DCC-405E-45DB-84EE-CFB365AAF197; _ga=GA1.2.1873930785.1585122498; selectedFeatureType=lx; USER_INFO_COOKIE=8013087048; USER_SALT_COOKIE=6cd638adfe6a18ee3f6ea1a41aee636d; FUNDID_COOKIE=COOKIE20200401000001205771; SESSION=10393d71-88e1-4ec2-8336-fcbdc39d1663; __hutmc=268394641; Hm_lvt_394e04be1e3004f9ae789345b827e8e2=1585122498,1585723127,1586327428; _hb_ref_pgid=11010; _hb_pgid=; welcome_fund_attention=true; GM_COMPARE_COOKIE=003741B519746B519933B008173; GM_VISIT_COOKIE=008173%2C519933%2C009058%2C001548%2C161725%2C003741%2C006147%2C006985; _gid=GA1.2.768083053.1587029184; __hutma=268394641.783161955.1585122498.1587089178.1587105163.22; __hutmb=268394641.1.10.1587105163; Hm_lpvt_394e04be1e3004f9ae789345b827e8e2=1587105164; OZ_SI_1497=sTime=1586327427&sIndex=613; OZ_1U_1497=vid=ve7b0cc121a2b8.0&ctime=1587105336&ltime=1587105333; OZ_1Y_1497=erefer=-&eurl=https%3A//www.howbuy.com/fundtool/filter.htm&etime=1586327427&ctime=1587105336&ltime=1587105333&compid=1497";
        String formResult =
                HttpUtil.httpForm(
                        "https://www.howbuy.com/fund/ajax/fundtool/findopenfund.htm",
                        param,
                        cookie);

        Document totalDoc = Jsoup.parse(formResult);
        Elements elements = totalDoc.getAllElements();
        String text = elements.text();
        text = text.replaceAll("[ 盈亏备注删除]", "");
        String[] splits = text.split("购买");
        Set<String> all = new TreeSet<>(Arrays.asList(splits));
        Set<String> a = new TreeSet<>();
        for (String split : all) {
            String temp = split.substring(0, split.indexOf("("));
            if (temp.contains(".")) {
                String daiMa = temp.substring(0, 6);
                String jingZhi = temp.substring(temp.lastIndexOf("-") + 1);
                a.add(daiMa + "-" + jingZhi);
                // System.out.println(daiMa + "-" + jingZhi);
            }
        }

        for (String s : a) {
            System.out.println(s.substring(s.lastIndexOf("-") + 1));
        }
        return re;
    }
}
