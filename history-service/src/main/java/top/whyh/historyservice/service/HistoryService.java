package top.whyh.historyservice.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class HistoryService {

    private static final Logger logger = LoggerFactory.getLogger(HistoryService.class);

    @Value("${juhe.api.key}")
    private String apiKey;

    private static final String API_URL = "http://v.juhe.cn/todayOnhistory/queryEvent";

    public String getHistoryData(String date) throws IOException {
        logger.info("Received date: {}", date); // 添加日志
        String url = String.format("%s?key=%s&date=%s", API_URL, apiKey, date);
        HttpGet request = new HttpGet(url);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            // 确保使用UTF-8编码
            String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            logger.info("API Response: {}", responseString); // 添加日志
            return responseString;
        }
    }
}
