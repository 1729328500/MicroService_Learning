package top.whyh.historyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.whyh.historyservice.service.HistoryService;

import java.io.IOException;

@RestController
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/history")
    public String getHistory(@RequestParam String date) throws IOException {
        // 直接使用传入的日期字符串，无需转换
        return historyService.getHistoryData(date);
    }
}
