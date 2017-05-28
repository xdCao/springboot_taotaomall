package app.controller;

import app.model.DataGridResult;
import app.pojo.ItemParam;
import app.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
