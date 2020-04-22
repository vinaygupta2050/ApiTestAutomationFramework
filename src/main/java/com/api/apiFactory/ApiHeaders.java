package com.api.apiFactory;

import io.restassured.http.Header;

import java.util.HashMap;
import java.util.Map;

public class ApiHeaders {

    public  static Map<String,String> defaultHeader(){
        Map<String,String> headerMap = new HashMap<String, String>();
        headerMap.put("accept","*/*");
        //headerMap.put("Content-Type","application/json");
        return headerMap;

    }
    public  static Map<String,String> headerWithContentType(){
        Map<String,String> headerMap = new HashMap<String, String>();
        String token="";
        headerMap.put("accept","*/*");
        headerMap.put("Content-Type","application/json");
        return headerMap;
    }

}
