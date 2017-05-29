package app.manager.controller;

import app.model.DataGridResult;
import app.model.TaoTaoResult;
import app.manager.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xdcao on 2017/5/28.
 */
@Controller
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping(value = "/item/param/list")
    @ResponseBody
    public DataGridResult listParam(@RequestParam Integer page, @RequestParam Integer rows){
        return itemParamService.getItemParamListByPage(page,rows);
    }


    @RequestMapping(value = "/item/param/query/itemcatid/{cid}")
    @ResponseBody
    public TaoTaoResult checkParamExsitence(@PathVariable Long cid){
        return itemParamService.checkParamExsitence(cid);
    }

    @RequestMapping(value = "/item/param/save/{cid}")
    @ResponseBody
    public TaoTaoResult saveItemParam(@PathVariable Long cid,@RequestParam String paramData){
        return itemParamService.saveItemParam(cid,paramData);
    }

    @RequestMapping(value = "/item/param/delete")
    @ResponseBody
    public TaoTaoResult deleteItemParams(@RequestParam List<Long> ids){
        return itemParamService.deleteItemParams(ids);
    }

}
