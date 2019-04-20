package com.roxi.vote.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class WeChatService {

    public JSONObject getJson(String urls) throws IOException, JSONException {
        URL url=new URL(urls);
        HttpsURLConnection urlConnection= (HttpsURLConnection) url.openConnection();
        InputStream is=urlConnection.getInputStream();
        InputStreamReader isr=new InputStreamReader(is,"utf-8");
        int len;
        char []chars=new char[1024*8];
        StringBuffer sb=new StringBuffer();
        while ((len=isr.read(chars,0,chars.length))!=-1){
            sb.append(new String(chars,0,len));
        }
        JSONObject jsonObject=new JSONObject(sb.toString());
        return jsonObject;
    }
}
