package app.portal.service;

import app.mapper.UserMapper;
import app.model.TaoTaoResult;
import app.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by xdcao on 2017/6/8.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public TaoTaoResult checkUserName(String username){
        List<User> users=userMapper.getUsersByName(username);
        if (users!=null&&users.size()>0){
            return new TaoTaoResult(200,"用户名已存在",null);
        }else {
            return new TaoTaoResult(200,"用户名可以使用",true);
        }
    }


    public TaoTaoResult checkPhone(String phone) {
        List<User> users=userMapper.getUsersByPhone(phone);
        if (users!=null&&users.size()>0){
            return new TaoTaoResult(200,"手机号已注册",null);
        }else {
            return new TaoTaoResult(200,"手机号可以使用",true);
        }
    }

    @Transactional
    public TaoTaoResult register(String username, String password, String phone) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        user.setPhone(phone);
        Date date=new Date();
        user.setCreated(date);
        user.setUpdated(date);
        userMapper.insert(user);
        return new TaoTaoResult(200,"注册成功",null);
    }

    public TaoTaoResult login(String username, String password) {
        List<User> users=userMapper.getUsersByName(username);
        if (users!=null&&users.size()>0){
            if (users.get(0).getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))){
                return new TaoTaoResult(200,"登录成功",null);
            }else {
                return new TaoTaoResult(500,"密码错误",null);
            }
        }else {
            return new TaoTaoResult(200,"用户名不存在",null);
        }
    }
}
