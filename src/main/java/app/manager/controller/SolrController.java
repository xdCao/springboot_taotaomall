package app.manager.controller;

import app.manager.service.SolrService;
import app.model.TaoTaoResult;
import org.apache.ibatis.annotations.Result;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
