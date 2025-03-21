package top.whyh.nacosconfigservice.controller;

import jakarta.annotation.Resource;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.whyh.nacosconfigservice.util.OssUtil;


import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class OssController {

    @Resource
    private OssUtil ossUtil;


    @PostMapping("/upload")
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileUrl = ossUtil.uploadFile(file);
        Map<String, Object> response = new HashMap<>();
        response.put("fileUrl", fileUrl);
        return response;
    }
}
