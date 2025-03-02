package top.whyh.userservice.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.whyh.userservice.entity.User;
import top.whyh.userservice.mapper.UserMapper;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    public User getFullUserById(Integer id) {
        return getBaseMapper().selectById(id);
    }
}