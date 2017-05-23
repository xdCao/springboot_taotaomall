import app.mapper.ContentMapper;
import app.mapper.ItemMapper;
import app.pojo.Content;
import app.pojo.Item;
import app.taotao_app;
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
public class ItemMapperTest {

    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void testInsert() throws Exception {

        Item item=new Item();
        item.setTitle("昂等会撒大哥好");
        item.setPrice(12212);
        item.setNum(1);
        item.setCid(560);
        item.setStatus(1);
        item.setCreated(new Date());
        item.setUpdated(new Date());

        itemMapper.insert(item);

    }

    @Test
    public void testQuery() throws Exception {
        List<Item> items = itemMapper.getAll();
        System.out.println(items.size());
    }

    @Test
    public void testUpdate() throws Exception {
        Item item=itemMapper.getOne(536563);
        System.out.println(item.getTitle());
        item.setTitle("dasdasdsadasd");
        itemMapper.update(item);
    }

}
