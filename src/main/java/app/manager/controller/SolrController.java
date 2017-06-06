package app.manager.controller;

import app.manager.service.SolrService;
import app.model.TaoTaoResult;
import org.apache.ibatis.annotations.Result;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

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

    @RequestMapping(value = "/solr/q")
    @ResponseBody
    public TaoTaoResult querySolr(@RequestParam(defaultValue = "") String keyword,@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "30") int rows){
        try {
            return solrService.querySolr(keyword,page,rows);
        } catch (Exception e) {
            return new TaoTaoResult(500,e.getStackTrace().toString(),null);
        }
    }

}
