import app.mapper.UserMapper;
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
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {

        User user =new User();
        user.setUsername("caohao");
        user.setPassword("940620");
        user.setCreated(new Date());
        user.setUpdated(new Date());
        userMapper.insert(user);

        System.out.println("size: "+userMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<User> users = userMapper.getAll();
        System.out.println(users.toString());
    }

    @Test
    public void testUpdate() throws Exception {
        User user = userMapper.getOne(7l);
        System.out.println(user.toString());
        user.setUsername("neo");
        userMapper.update(user);
        Assert.assertTrue(("neo".equals(userMapper.getOne(7l).getUsername())));
    }

}
