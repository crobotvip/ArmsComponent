package com.example.module.user.mvp.model.api.service;

import com.example.module.user.mvp.model.entity.LoginResponse;

import java.util.List;

import io.reactivex.Observable;
import me.jessyan.armscomponent.commonsdk.core.BaseResponse;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static com.example.module.user.mvp.model.api.Api.USER_DOMAIN_NAME;
import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

public interface UserService {
    /**
     * 用户登录
     */
    @Headers({DOMAIN_NAME_HEADER + USER_DOMAIN_NAME})
    @FormUrlEncoded
    @POST("jery/user/caslogin")
    Observable<BaseResponse<LoginResponse>> login(@Field("username") String username,
                                                  @Field("password") String password,
                                                  @Field("verifyCode") String verifyCode);
}
