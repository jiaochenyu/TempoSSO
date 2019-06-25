package com.temposso.demo.sso;

import com.meritdata.tempo.calcite.jdbc.utils.HttpUtil;
import com.thoughtworks.xstream.core.util.Base64Encoder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 人员同步
 */
public class OrgUserSyc {

    public static void main(String[] args) {
        //请求串(客户端标识#调用码#当前时间的毫秒值)
        String requestId = "aaaaaa#cc3acac#"+System.currentTimeMillis();
        Base64Encoder encoder = new Base64Encoder();
        requestId = encoder.encode(requestId.getBytes());

        //用户信息
        String userInfo = "<ROOT>"
                + "<ROOTORGCODE>show</ROOTORGCODE>"

                + "<USER>"
                + "<RY_STAFFNAME>测试用户1</RY_STAFFNAME>"
                + "<RY_STAFFCODE>usertest1</RY_STAFFCODE>"
                + "<RY_DEPARTMENTCODE>show</RY_DEPARTMENTCODE>"
                + "<RY_LOGINNAME>testlogin1</RY_LOGINNAME>"
                + "<RY_ISSEAL_V>1</RY_ISSEAL_V>"
                + "<RY_PASSWORD>111111</RY_PASSWORD>"
                + "<RY_MAIL>aaa@merit.com</RY_MAIL>"
                + "<RY_IP></RY_IP>"
                + "<RY_MAC></RY_MAC>"
                + "<RY_PHONE>13091617887</RY_PHONE>"
                + "<RY_TEL>3996841</RY_TEL>"
                + "<RY_SEX>0</RY_SEX>"
                + "<RY_SORT>1</RY_SORT>"
                + "</USER>"

                + "<USER>"
                + "<RY_STAFFNAME>测试用户2</RY_STAFFNAME>"
                + "<RY_STAFFCODE>usertest2</RY_STAFFCODE>"
                + "<RY_DEPARTMENTCODE>show</RY_DEPARTMENTCODE>"
                + "<RY_LOGINNAME>testlogin2</RY_LOGINNAME>"
                + "<RY_PASSWORD>111111</RY_PASSWORD>"
                + "<RY_ISSEAL_V>1</RY_ISSEAL_V>"
                + "<RY_MAIL>175687482@qq.com</RY_MAIL>"
                + "<RY_IP></RY_IP>"
                + "<RY_MAC></RY_MAC>"
                + "<RY_PHONE>13091617881</RY_PHONE>"
                + "<RY_TEL>3996842</RY_TEL>"
                + "<RY_SEX>1</RY_SEX>"
                + "<RY_SORT>2</RY_SORT>"
                + "</USER>"
                + "</ROOT>";
        String url = "http://127.0.0.1:8383/tempo/webapi/user/sync"; //
        Map<String,String> form = new HashMap<String, String>();
        form.put("requestId", requestId);
        form.put("userInfo", userInfo);
        //此处调用restful的方法，可根据不同系统不同技术实现
        try {
            String result = HttpUtil.invoke(url, form, null, null, "utf-8");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
