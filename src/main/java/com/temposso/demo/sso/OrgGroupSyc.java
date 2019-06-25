package com.temposso.demo.sso;


import com.meritdata.tempo.calcite.jdbc.utils.HttpUtil;
import com.thoughtworks.xstream.core.util.Base64Encoder;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 组织同步
 */
public class OrgGroupSyc {

    public static void main(String[] args) {
        //请求串(客户端标识#调用码#当前时间的毫秒值)
        String requestId = "aaaaaa#1dea72e#"+System.currentTimeMillis();
        Base64Encoder encoder = new Base64Encoder();
        requestId = encoder.encode(requestId.getBytes());

       //组织机构数据(此处省略)
        String orgInfo = "<ROOT>"
                + "<ROOTORGCODE>test</ROOTORGCODE>"
                + "<ORG>"
                + "<ORG_NAME>大数据研发中心</ORG_NAME>"
                + "<ORG_SIMPLENAME>研发中心</ORG_SIMPLENAME>"
                + "<ORG_CODE>test1</ORG_CODE>"
                + "<ORG_PARENT_CODE>test</ORG_PARENT_CODE>"
                + "<ORG_DLEVEL>1</ORG_DLEVEL>"
                + "<ORG_SORT>2</ORG_SORT>"
                + "</ORG>"

                + "<ORG>"
                + "<ORG_NAME>财务部</ORG_NAME>"
                + "<ORG_SIMPLENAME>财务部</ORG_SIMPLENAME>"
                + "<ORG_CODE>test2</ORG_CODE>"
                + "<ORG_PARENT_CODE>test</ORG_PARENT_CODE>"
                + "<ORG_DLEVEL>0</ORG_DLEVEL>"
                + "<ORG_SORT>1</ORG_SORT>"
                + "</ORG>"

                + "<ORG>"
                + "<ORG_NAME>人力资源部</ORG_NAME>"
                + "<ORG_SIMPLENAME>人力资源部</ORG_SIMPLENAME>"
                + "<ORG_CODE>test3</ORG_CODE>"
                + "<ORG_PARENT_CODE>test</ORG_PARENT_CODE>"
                + "<ORG_DLEVEL>1</ORG_DLEVEL>"
                + "<ORG_SORT>12</ORG_SORT>"
                + "</ORG>"
                + "</ROOT>";
        String url = "http://127.0.0.1:8383/tempo/webapi/org/sync";
        Map<String,String> form = new HashMap<String, String>();
        form.put("requestId", requestId);
        form.put("orgInfo", orgInfo);
        //此处调用restful的方法，可根据不同系统不同技术实现
        try {
            String result = HttpUtil.invoke(url, form, null, null, "utf-8");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
