package chencheng.bwie.com.chencheng20180424.net;

import java.util.Map;

import chencheng.bwie.com.chencheng20180424.bean.LogBean;
import chencheng.bwie.com.chencheng20180424.bean.RegBean;
import chencheng.bwie.com.chencheng20180424.bean.UserBean;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by dell on 2018/4/24.
 */

public interface ApiService {
    //注册的接口
    //https://www.zhaoapi.cn/user/reg?mobile=18631090582&password=888888
    @FormUrlEncoded
    @POST("/user/reg")
    Observable<RegBean> reg(@FieldMap Map<String,String> map);

    //登录的接口
    //https://www.zhaoapi.cn/user/login?mobile=18631090582&password=888888
    @FormUrlEncoded
    @POST("/user/login")
    Observable<LogBean> login(@FieldMap Map<String,String> map);

    //个人中心接口：
    //https://www.zhaoapi.cn/user/getUserInfo?uid=100
    @GET("/user/getUserInfo")
    Observable<UserBean> person(@Query("uid") int uid);
}
