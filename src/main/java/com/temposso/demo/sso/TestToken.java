package com.temposso.demo.sso;

import com.meritdata.tempo.utils.MD5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestToken {

    String url = "http://localhost:8080/webapp/index.jsp?token=b256af93076beb879ed8ab4a67edffa1&userId=admin";

    public static void main(String[] args) {
        // 用 pf_user_info 表中的USER_NAME字段
        String user="demo";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String token= MD5.get(sdf.format(new Date())+user);
        System.out.println(token);
//        System.out.println(System.currentTimeMillis());
    }
}
