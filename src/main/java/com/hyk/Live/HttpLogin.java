package com.hyk.Live;

import com.hyk.common.HttpBase;
import com.hyk.domain.LoginVo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;

/**
 * @param
 * @Description TODO
 * @Author Lindsay
 * @Date 2020/10/6 2:27 PM
 **/
public class HttpLogin extends HttpBase {

    private ILogin iLogin;

    /**
     * 构造方法（1个参数）
     * 只传Host
     * 可以加入自定义拦截器 -超时判断
     * 或者，默认没有使用拦截器。
     *
     * @param host 访问域名host
     */
    public HttpLogin(String host) {
        super(host);
        iLogin = super.create(ILogin.class);
    }

    public Response<ResponseBody> login(HashMap<String,String> headers, LoginVo loginVo) throws IOException {

        Call<ResponseBody> call = iLogin.login(headers, loginVo);

        return call.execute();


    }


}
