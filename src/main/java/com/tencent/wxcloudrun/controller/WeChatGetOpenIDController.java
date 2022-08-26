package com.tencent.wxcloudrun.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WeChatGetOpenIDController {

    public static List openIDList = new ArrayList<>();

    //根据code获取用户的openid
    @PostMapping("/getOpenID")
    public void getOpenID(@RequestParam("code") String code) {

        String AppID = "wx008be22aff98b7ab";
        String AppSecret = "27f797e37158258f0f3fee4ee4d98c30";

        String result = "";
        try {
            //请求微信服务器
            result = HttpUtil.get(
                    "https://api.weixin.qq.com/sns/jscode2session?appid="
                            + AppID + "&secret="
                            + AppSecret + "&js_code="
                            + code
                            + "&grant_type=authorization_code");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------------------");
        System.out.println(code);
        System.out.println(result);

        JSONObject jsonObject = JSONUtil.parseObj(result);
        String sessionKey = jsonObject.getStr("session_key");
        System.out.println("session_key: " + sessionKey);
        String openID = jsonObject.getStr("openid");
        System.out.println("openid: " + openID);

        openIDList.add(openID);
    }
}
