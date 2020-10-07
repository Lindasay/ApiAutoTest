package com.hyk.Live;


import com.hyk.domain.LoginVo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;


import java.util.Map;

public interface ILogin {


    @POST("/sesame/hykLogin")
    Call<ResponseBody> login(@HeaderMap Map<String, String> headers, @Body LoginVo loginVo);

}
