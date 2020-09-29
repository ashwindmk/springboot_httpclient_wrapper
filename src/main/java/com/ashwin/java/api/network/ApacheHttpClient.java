package com.ashwin.java.api.network;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "ApacheHttpClient")
public class ApacheHttpClient implements HttpClient {
    @Override
    public HttpResponseDto<?> doGet(HttpRequestDto requestDto) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(requestDto.getUrl());

            CloseableHttpResponse response = httpClient.execute(request);

            int status = response.getStatusLine().getStatusCode();
            String message = response.getStatusLine().toString();
            String reason = response.getStatusLine().getReasonPhrase();

            HttpResponseDto<String> responseDto = new HttpResponseDto<>(status, message);
            responseDto.setReason(reason);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                responseDto.setData(result);
            }
            return responseDto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new HttpResponseDto<Void>(-1, "error");
    }

    @Override
    public HttpResponseDto doPost(HttpRequestDto requestDto) {
        return null;
    }

    @Override
    public HttpResponseDto doPut(HttpRequestDto requestDto) {
        return null;
    }

    @Override
    public HttpResponseDto doPatch(HttpRequestDto requestDto) {
        return null;
    }

    @Override
    public HttpResponseDto doDelete(HttpRequestDto requestDto) {
        return null;
    }
}
