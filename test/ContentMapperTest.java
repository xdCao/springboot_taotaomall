import app.mapper.ContentMapper;
import app.pojo.Content;
import app.pojo.User;
import app.taotao_app;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by xdcao on 2017/5/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = taotao_app.class)
public class ContentMapperTest {

    @Autowired
    private ContentMapper contentMapper;

    @Test
    public void testInsert() throws Exception {

        Content content=new Content();
        content.setCategoryId(2);
        content.setContent("jajajhdaslkdjlkasjdlkaslkd");
        contentMapper.insert(content);

    }

    @Test
    public void testQuery() throws Exception {
        List<Content> contents = contentMapper.getAll();
        System.out.println(contents.size());
    }

    @Test
    public void testUpdate() throws Exception {
        Content content=contentMapper.getOne(28);
        System.out.println(content.getContent());
        content.setContent("neo");
        contentMapper.update(content);
    }

}
