package com.soft1721.jianyue.api.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.soft1721.jianyue.api.util.StringUtil;

/**
 * 短信发送工具类，返回生成的随机验证码
 */
public class SMSUtil {
    public static String send(String mobile) {
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-beijing",
                "LTAIfNjZCWTJVtUG",
                "KXO6gOBtyqSY216qmYujBDfFgvPJsH");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-beijing");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "万里小白sherlock");
        request.putQueryParameter("TemplateCode", "SMS_162730680");
        String verifyCode = StringUtil.getVerifyCode();
        request.putQueryParameter("TemplateParam", "{\"code\":" + verifyCode + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return verifyCode;
    }

    public static void main(String[] args) {
        System.out.println(send("187****5590"));
    }
}