package com.roxi.vote.controller;

import com.roxi.vote.bean.User;
import com.roxi.vote.service.EntiyService;
import com.roxi.vote.service.UserService;
import com.roxi.vote.service.WeChatService;
import com.roxi.vote.utils.AuthUtil;
import com.roxi.vote.utils.NetWorkUtil;
import com.roxi.vote.utils.SignatureUtil;
import org.apache.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author Roxi酱
 */
@Controller
@RequestMapping("/weChat")
public class WeChatConfig {
    @Autowired
    UserService userService;
    @Autowired
    EntiyService entiyService;

    @Autowired
    WeChatService weChatService;
    @Autowired
    AuthUtil authUtil;

    @Value("${weixin.redirect_back.url}")
    String backUrl;
    @Value("${weixin.base.appid}")
    String appid;
    @Value("${weixin.base.appsecret}")
    String appsecret;

    @RequestMapping(value = "/get",method = {RequestMethod.POST,RequestMethod.GET})
    public  @ResponseBody String get(@RequestParam("signature") String signature,@RequestParam("timestamp") String timestamp,String nonce,String echostr) {
        if (SignatureUtil.checkSignature(signature, timestamp, nonce)) {
            // 随机字符串
            return echostr;
        }
        return null;
    }

    @RequestMapping(value = "/getAuth",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String getAuth(String code,String state){
        JSONObject jsonObject=null;
         try {
             jsonObject=authUtil.doGetJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    @RequestMapping(value = "/getCode",method = RequestMethod.GET)
    public void getCode(HttpServletResponse response) throws IOException {

        String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid
                + "&redirect_uri="+ URLEncoder.encode(backUrl,"utf-8")
                + "&response_type=code"
                + "&scope=snsapi_base"
                + "&state=STATE#wechat_redirect";

       response.sendRedirect(url);
    }

    @RequestMapping(value = "/callback",method = {RequestMethod.GET,RequestMethod.POST})
   // @ResponseBody
    protected String callBack(String code,String state,HttpSession session) throws IOException, JSONException {
        System.out.println("this can send the code:"+code+"this is state:"+state);

        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid
                + "&secret=" + appsecret
                + "&code=" + code
                + "&grant_type=authorization_code";

        JSONObject jsonObject=weChatService.getJson(url);

        String token=jsonObject.getString("access_token");
        String openId=jsonObject.getString("openid");
        System.out.println(token+"----"+openId);
        userService.judge(openId);
        session.setAttribute("user",openId);
        return "Vote.html";
    }
}
