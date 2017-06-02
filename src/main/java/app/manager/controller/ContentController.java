package app.manager.controller;

import app.manager.service.ContentService;
import app.model.DataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xdcao on 2017/6/2.
 */
@Controller
@RequestMapping(value = "/content/query")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public DataGridResult getContentListByCate(int page,int rows,Long categoryId){
        System.out.println("page: "+page+", rows: "+",cateId: "+categoryId);
        return contentService.getContentsByCatId(page,rows,categoryId);
    }

}
