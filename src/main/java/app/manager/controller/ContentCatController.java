package app.manager.controller;

import app.manager.service.ContentCatService;
import app.model.TaoTaoResult;
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
@RequestMapping(value = "/content/category")
public class ContentCatController {

    @Autowired
    private ContentCatService contentCatService;


    @RequestMapping(value = "/list")
    @ResponseBody
    public List<TreeNodeResult> getContentCatTree(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        return contentCatService.getContentCatTree(parentId);
    }

    @RequestMapping(value = "/create")
    @ResponseBody
    public TaoTaoResult createNewContentCat(Long parentId, String name){
        return contentCatService.createNewContentCat(parentId,name);
    }


    @RequestMapping(value = "/update")
    @ResponseBody
    public void updateContentCat(Long id,String name){
        contentCatService.updateContentCat(id,name);
    }


    @RequestMapping(value = "/delete")
    @ResponseBody
    public void deleteContentCat(Long id){
        contentCatService.deleteContentCat(id);
    }


}
