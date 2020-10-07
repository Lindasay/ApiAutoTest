package com.hyk.Login;

import com.alibaba.fastjson.JSONObject;
import com.hyk.Live.HttpLogin;
import com.hyk.common.HttpHeader;
import com.hyk.domain.LoginVo;
import com.hyk.utils.DataUtils;
import okhttp3.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;


/**
 * @param
 * @Description TODO
 * @Author Lindsay
 * @Date 2020/10/6 2:40 PM
 **/
public class TestLogin {

    private static Properties properties;
    private static HttpLogin implLogin;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("env.properties");
        properties = new Properties();
        properties.load(is);
        String host = properties.getProperty("hyk.host");
        implLogin = new HttpLogin(host);
        is.close();
    }

    @Test(description = "好衣库登录")
    public void testcase1() throws Exception{

        Response<ResponseBody> response = implLogin.login(HttpHeader.getHeaderMap(),new LoginVo(DataUtils.bizType,DataUtils.mobile,DataUtils.password));

        ResponseBody body = response.body();

        Assert.assertNotNull(body, "response.body()");

        //将respons转为JSON
       JSONObject jsonObject = JSONObject.parseObject(body.string());
       Iterator<String> iterator = jsonObject.keySet().iterator();

       String mobile=null;
       while (iterator.hasNext()){

           String value = iterator.next();

           if(value.equals("entry")){

               String string = jsonObject.getString(value);
               JSONObject parseObject = JSONObject.parseObject(string);
              mobile = parseObject.getString("mobile");

           }


       }

       Assert.assertEquals("13221711868",mobile);
       //获取接口的字段值进行校验
        String status = jsonObject.getString("status");
        System.out.println("status:"+status);
        Assert.assertEquals("true",status);
    }


}
