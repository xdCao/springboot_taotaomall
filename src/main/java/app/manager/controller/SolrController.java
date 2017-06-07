package app.manager.controller;

import app.manager.service.SolrService;
import app.model.SolrResult;
import app.model.TaoTaoResult;
import org.apache.ibatis.annotations.Result;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xdcao on 2017/6/3.
 */
@Controller
public class SolrController {

    @Autowired
    private SolrService solrService;


    @RequestMapping(value = "/solr/import")
    @ResponseBody
    public TaoTaoResult importSolr() throws IOException, SolrServerException {
        return solrService.importSolr();
    }

//    @RequestMapping(value = "/solr/q")
//    @ResponseBody
//    public TaoTaoResult querySolr(@RequestParam(defaultValue = "") String keyword,@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "30") int rows){
//        try {
//            return solrService.querySolr(keyword,page,rows);
//        } catch (Exception e) {
//            return new TaoTaoResult(500,e.getStackTrace().toString(),null);
//        }
//    }


    @RequestMapping(value = "/solr/q")
    @ResponseBody
    public ModelAndView querySolr(@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "30") int rows){


        try {
            SolrResult solrResult=solrService.querySolr(keyword,page,rows);
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("query",keyword);
            map.put("totalPages",solrResult.getPageCount());
            map.put("itemList",solrResult.getItemlist());
            map.put("page",solrResult.getCurPage());
            ModelAndView modelAndView=new ModelAndView("portal/search",map);
            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
