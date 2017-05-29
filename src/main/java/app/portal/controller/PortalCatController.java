package app.portal.controller;

import app.config.JacksonUtil;
import app.manager.service.ItemCatService;
import app.model.CatItemResult;
import app.portal.service.PortalItemCatService;
import com.alibaba.druid.support.json.JSONUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xdcao on 2017/5/29.
 */
@Controller
@RequestMapping(value = "/portal")
public class PortalCatController {

    @Autowired
    private PortalItemCatService itemCatService;

    @RequestMapping(value = "/item/cat/list")
    @ResponseBody
    public String getItemCatResult(String callback){

        CatItemResult catItemResult=itemCatService.getAllCats();
        if (StringUtils.isEmpty(callback)){
            String json=JacksonUtil.toJSon(catItemResult);
            return json;
        }else {
            String jsonp= JacksonUtil.toJSon(catItemResult);
            String result=callback+"("+jsonp+");";
            return result;
        }

    }

}
