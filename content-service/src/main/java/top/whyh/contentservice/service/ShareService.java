package top.whyh.contentservice.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.whyh.contentservice.entity.Share;
import top.whyh.contentservice.mapper.ShareMapper;


@Service
public class ShareService extends ServiceImpl<ShareMapper, Share> {
    public Share getShareById(Integer id) {
        return this.getById(id);
    }
}