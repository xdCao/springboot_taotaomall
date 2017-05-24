import app.mapper.ContentMapper;
import app.pojo.Content;
import app.taotao_app;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;

/**
 * Created by xdcao on 2017/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = taotao_app.class)
public class SqlPageTest {

    @Autowired
    private ContentMapper contentMapper;

    @Test
    public void testPageInfo(){

        PageHelper.startPage(1,30);
        List<Content> contents=contentMapper.getAll();
        PageInfo<Content> pageInfo=new PageInfo<Content>(contents);
        System.out.println("pageNum: "+pageInfo.getPageNum());
        System.out.println("total: "+pageInfo.getTotal());
        System.out.println("pageSize: "+pageInfo.getPageSize());
    }


}
