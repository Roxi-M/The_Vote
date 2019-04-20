package com.roxi.vote.utils;

import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Roxi酱
 */

public class NetWorkUtil {
    public static String getHttpResponse(String urls) throws IOException {
        URL url=new URL(urls);
        HttpsURLConnection urlConnection=(HttpsURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        InputStream is=urlConnection.getInputStream();
        InputStreamReader isr=new InputStreamReader(is,"utf-8");
        StringBuffer sb=new StringBuffer();
        int len;
        char []chars=new char[1024*8];
        while ((len=isr.read(chars,0,chars.length))!=-1){
            sb.append(new String(chars,0,len));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
