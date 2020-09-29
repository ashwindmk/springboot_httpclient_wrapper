package com.ashwin.java.api.network;

public interface HttpClient {
    HttpResponseDto doGet(HttpRequestDto requestDto);

    HttpResponseDto doPost(HttpRequestDto requestDto);

    HttpResponseDto doPut(HttpRequestDto requestDto);

    HttpResponseDto doPatch(HttpRequestDto requestDto);

    HttpResponseDto doDelete(HttpRequestDto requestDto);
}
