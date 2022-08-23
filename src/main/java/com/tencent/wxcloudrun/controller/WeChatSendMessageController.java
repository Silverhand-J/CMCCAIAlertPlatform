package com.tencent.wxcloudrun.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tencent.wxcloudrun.model.Alert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tencent.wxcloudrun.controller.WeChatGetOpenIDController.openIDList;

@RestController
public class WeChatSendMessageController {

    //获取access_token以调用订阅消息模板推送的接口
    public static String getAccessToken() {

        String appId = "wx008be22aff98b7ab";
        String appSecret = "27f797e37158258f0f3fee4ee4d98c30";

        //请求微信服务器
        String result = HttpUtil.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + appId + "&secret="
                + appSecret);

        JSONObject accessToken = JSONUtil.parseObj(result);
        return accessToken.getStr("access_token");
    }

    //向用户推送模板消息
    @GetMapping("/sendMessage")
    public static String sendMessage(Alert alert) {

        String post = null;

        //for (int i = 0; i <= openIDList.; i++) {
        for (Object openID : openIDList) {
            JSONObject message = new JSONObject();
            //message.set("touser", "onw1o5VcKZ9IEWyJ7Xa-PLhH5Yy4"); //主开发号
            //message.set("touser", "onw1o5e1CiIOhizXke6SbGpfYFKM");
            message.set("touser", openID);
            message.set("template_id", "A_Rk2xS1lG-MMZFXDQOPIHRurZscfV7ToJu83Z2Y5io");
            message.set("page", "pages/alert_detail/alert_detail?equipment_id="
                    + alert.getEquipment_id() + "&time="
                    + alert.getTime().substring(0, 10));

            JSONObject data = new JSONObject();
            data.set("thing7", new JSONObject().set("value", alert.getLocation()));
            data.set("thing3", new JSONObject().set("value", "疑似烟雾"));
            data.set("character_string1", new JSONObject().set("value", alert.getEquipment_id()));
            data.set("time5", new JSONObject().set("value", alert.getTime()));
            data.set("thing6", new JSONObject().set("value", "预警详情请点击进入小程序查看并进行处理！"));
            //data.set("date4", new JSONObject().set("value", LocalDateTime.now()));
            //data.set("character_string2", new JSONObject().set("value", DateUtil.now()));
            message.set("data", data);

            //请求微信服务器，推送模板消息
            String accessToken = getAccessToken();
            post = HttpUtil.post("https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token="
                    + accessToken, message.toString());
        }
        return post;
    }

    //对前端发来的用户同意订阅消息进行响应
    @GetMapping("/subscribeSuccess")
    public String subscribeSuccess() {
        return "订阅成功";
    }
}
