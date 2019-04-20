package com.roxi.vote.utils;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Roxi酱
 */
@Component
public class AuthUtil {

    @Value("${weixin.base.appid}")
    public  String appid;
    //="wx3b835565c7f8edb1";
    @Value("${weixin.base.appsecret}")
    public  String appsecret;
    //="c0d24490107b35f6202d7695571bd0db";
    public  JSONObject doGetJson() throws Exception{
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+appsecret;
        String json=NetWorkUtil.getHttpResponse(url);
        JSONObject jsonObject=new JSONObject(json);
        return jsonObject;
    }
}
