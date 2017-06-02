import app.mapper.SolrMapper;
import app.pojo.SolrItem;
import app.taotao_app;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by xdcao on 2017/6/3.
 */
@SpringBootTest(classes = taotao_app.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SolrMapperTest {

    @Autowired
    private SolrMapper solrMapper;

    @Test
    public void test(){
        List<SolrItem> solrItems=solrMapper.getSolrItemList();
        for (SolrItem solrItem:solrItems){
            System.out.println(solrItem.getTitle());
        }
    }

}
