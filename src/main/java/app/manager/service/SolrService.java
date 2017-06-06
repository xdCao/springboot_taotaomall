package app.manager.service;

import app.mapper.SolrMapper;
import app.model.SolrResult;
import app.model.TaoTaoResult;
import app.pojo.SolrItem;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xdcao on 2017/6/3.
 */
@Service
public class SolrService {

    @Autowired
    private SolrMapper solrMapper;

    @Autowired
    private SolrClient solrClient;

    public TaoTaoResult importSolr() throws IOException, SolrServerException {
        List<SolrItem> solrItems=solrMapper.getSolrItemList();
        for (SolrItem solrItem:solrItems){
            SolrInputDocument document=new SolrInputDocument();
            document.addField("id",solrItem.getId());
            document.addField("item_title",solrItem.getTitle());
            document.addField("item_sell_point",solrItem.getSell_point());
            document.addField("item_price",solrItem.getPrice());
            document.addField("item_image",solrItem.getImage());
            document.addField("item_category_name",solrItem.getCategory_name());
            document.addField("item_desc",solrItem.getItem_desc());
            solrClient.add(document);
        }
        solrClient.commit();
        return new TaoTaoResult(200,"ok",null);
    }

    public TaoTaoResult querySolr(String queryStr,int page,int rows) throws IOException, SolrServerException {

        SolrQuery solrQuery=new SolrQuery(queryStr);
        solrQuery.setStart((page-1)*rows);
        solrQuery.setRows(rows);
        solrQuery.set("df","item_title");
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("item_title");
        solrQuery.setHighlightSimplePre("<font class=\"skcolor_lig\">");
        solrQuery.setHighlightSimplePost("</font>");

        QueryResponse queryResponse=solrClient.query(solrQuery);
        SolrDocumentList documents=queryResponse.getResults();
        List<SolrItem> solrItems=new ArrayList<SolrItem>();
        for (SolrDocument document:documents){
            SolrItem solrItem=new SolrItem();
            solrItem.setId((String) document.get("id"));
            solrItem.setCategory_name((String) document.get("item_category_name"));
            solrItem.setImage((String) document.get("item_image"));
            solrItem.setItem_desc((String) document.get("item_desc"));
            solrItem.setPrice((Long) document.get("item_price"));
            solrItem.setSell_point((String) document.get("item_sell_point"));

            //高亮显示
            Map<String, Map<String, List<String>>> hightLighting = queryResponse.getHighlighting();
            List<String> list=hightLighting.get(document.get("id")).get("item_title");
            if (list!=null&&list.size()>0){
                solrItem.setTitle(list.get(0));
            }else {
                solrItem.setTitle((String) document.get("item_title"));
            }

            solrItems.add(solrItem);
        }
        SolrResult solrResult=new SolrResult();
        solrResult.setItemlist(solrItems);
        solrResult.setRecordCount(documents.getNumFound());
        int pageCount= (int) ((documents.getNumFound()%rows==0)?(documents.getNumFound()/rows+1):(documents.getNumFound()/rows));
        solrResult.setPageCount(pageCount);
        solrResult.setCurPage(page);

        return new TaoTaoResult(200,"ok",solrResult);

    }


}
