package top.whyh.userservice.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.whyh.userservice.config.ApiResponse;
import top.whyh.userservice.config.WhyhProperties;
import top.whyh.userservice.entity.User;
import top.whyh.userservice.mapper.UserMapper;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private WhyhProperties whyhProperties;

    public ApiResponse getFullUserById(Integer id) {
        if (!whyhProperties.getServiceFlag()) {
            return new ApiResponse(503, "用户服务正在维护中，请稍后。。", null);
        }

        User user = getBaseMapper().selectById(id);
        if (user == null) {
            return new ApiResponse(404, "用户不存在", null);
        }

        return new ApiResponse(200, "成功", user);
    }
}
