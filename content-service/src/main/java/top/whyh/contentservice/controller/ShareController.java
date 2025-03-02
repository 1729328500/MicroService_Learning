package top.whyh.contentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.whyh.contentservice.entity.Share;
import top.whyh.contentservice.openfeign.UserFeignClient;
import top.whyh.contentservice.service.ShareService;
import top.whyh.contentservice.vo.ShareVO;
import top.whyh.contentservice.vo.UserVO;

@RestController
@RequestMapping("/share")
@RequiredArgsConstructor
public class ShareController {

    private final ShareService shareService;
    private final UserFeignClient userFeignClient;

    @GetMapping("/{id}")
    public ShareVO getShareById(@PathVariable Integer id) {
        Share share = shareService.getShareById(id);
        UserVO userVO = userFeignClient.getUserById(share.getUserId());

        return ShareVO.builder()
                .id(share.getId())
                .userId(share.getUserId())
                .title(share.getTitle())
                .createTime(share.getCreateTime())
                .updateTime(share.getUpdateTime())
                .original(share.getOriginal())
                .author(share.getAuthor())
                .cover(share.getCover())
                .summary(share.getSummary())
                .price(share.getPrice())
                .downloadUrl(share.getDownloadUrl())
                .buyCount(share.getBuyCount())
                .showFlag(share.getShowFlag())
                .auditStatus(share.getAuditStatus())
                .reason(share.getReason())
                .userInfo(userVO)
                .build();
    }
}
