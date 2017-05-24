package app.controller;

import app.model.TreeNodeResult;
import app.service.ItemCatService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xdcao on 2017/5/24.
 */
@Controller
@RequestMapping(value = "/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<TreeNodeResult> getItemCatListTree(@RequestParam(value = "id",defaultValue = "0") Long parent_id){

        return itemCatService.getItemCatTree(parent_id);

    }


}
