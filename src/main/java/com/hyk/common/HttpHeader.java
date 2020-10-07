package com.hyk.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @param
 * @Description TODO
 * @Author Lindsay
 * @Date 2020/10/6 12:46 PM
 **/
public class HttpHeader {

    private static HashMap<String,String> headerMap;


    public static HashMap<String,String> getHeaderMap(){

        headerMap = new HashMap<>();

        headerMap.put("content-type","application/json");
        headerMap.put("encrypttype","IOS");
        headerMap.put("user-agent","HYK/4.0.2 (iPhone; iOS 13.1.2; Scale/3.00)");


        return headerMap;
    }


}
