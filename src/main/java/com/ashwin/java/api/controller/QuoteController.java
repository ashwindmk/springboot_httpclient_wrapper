package com.ashwin.java.api.controller;

import com.ashwin.java.api.mapper.QuoteMapper;
import com.ashwin.java.api.network.HttpClient;
import com.ashwin.java.api.network.HttpRequestDto;
import com.ashwin.java.api.network.HttpResponseDto;
import com.ashwin.java.domain.model.Quote;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    @Autowired
    @Qualifier(value = "ApacheHttpClient")
    private HttpClient httpClient;

    @GetMapping
    public ResponseEntity<?> quote() {
        HttpRequestDto requestDto = new HttpRequestDto("https://gturnquist-quoters.cfapps.io/api/random");
        HttpResponseDto<String> responseDto = httpClient.doGet(requestDto);
        System.out.println("Response: " + responseDto);
        if (responseDto.getStatus() >= 200 && responseDto.getStatus() < 300) {
            String response = responseDto.getData();
            try {
                Quote quote = QuoteMapper.fromJson(response, Quote.class);
                return ResponseEntity.ok(quote);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.status(responseDto.getStatus()).body(null);
    }
}
