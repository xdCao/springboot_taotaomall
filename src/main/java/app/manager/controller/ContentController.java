package app.manager.controller;

import app.manager.service.ContentService;
import app.model.DataGridResult;
import app.model.TaoTaoResult;
import app.pojo.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xdcao on 2017/6/2.
 */
@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/content/query/list")
    @ResponseBody
    public DataGridResult getContentListByCate(int page,int rows,Long categoryId){
        return contentService.getContentsByCatId(page,rows,categoryId);
    }

    @RequestMapping(value = "/content/save")
    @ResponseBody
    public TaoTaoResult addContent(Content content){
        return contentService.addContent(content);
    }

    @RequestMapping(value = "/content/edit")
    @ResponseBody
    public TaoTaoResult editContent(Content content){
        return contentService.editContent(content);
    }

    @RequestMapping(value = "/content/delete")
    @ResponseBody
    public TaoTaoResult deleteContents(@RequestParam List<Long> ids){
        return contentService.deleteContents(ids);
    }

}
