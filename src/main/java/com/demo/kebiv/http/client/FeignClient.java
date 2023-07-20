package com.demo.kebiv.http.client;

import feign.Request;
import feign.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by code00000001 on 20/7/2023.
 */
@Component // 配置文件类FeignConfiguration里面 @Bean的方式注入了bean又用了@Component是为了 拿到配置文件里面的配置feign.url
public class FeignClient extends AbstractClient {
    private final static Pattern urlPattern = Pattern.compile("://\\{feignUrl}/([A-Za-z0-9_-]*)");

    @Value("${feign.url}")
    private String feignUrl;

    @Override
    HttpURLConnection convertAndGetNewHttpURLConnection(Request request) throws IOException {
        String sourceUrl = request.url();
        Matcher matcher = urlPattern.matcher(sourceUrl);
        String targetUrl = sourceUrl;
        boolean isFind = matcher.find();
        if(isFind) {

            String regex = "http://\\{feignUrl}";
            targetUrl = sourceUrl.replaceAll(regex, feignUrl);
        }
        return (HttpURLConnection) new URL(targetUrl).openConnection();
    }

    @Override
    public Response execute(Request request, Request.Options options) throws IOException {
        HttpURLConnection connection = convertAndSend(request, options);
        return convertResponse(connection).toBuilder().request(request).build();
    }
}
