package app.manager.service;

import app.mapper.SolrMapper;
import app.model.TaoTaoResult;
import app.pojo.SolrItem;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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

}
