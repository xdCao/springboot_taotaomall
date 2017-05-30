package app.manager.controller;

import app.manager.service.ContentCatService;
import app.model.TreeNodeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xdcao on 2017/5/30.
 */
@Controller
public class ContentCatController {

    @Autowired
    private ContentCatService contentCatService;


    @RequestMapping(value = "/content/category/list")
    @ResponseBody
    public List<TreeNodeResult> getContentCatTree(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        return contentCatService.getContentCatTree(parentId);
    }


}
