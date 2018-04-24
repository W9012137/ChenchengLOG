package chencheng.bwie.com.chencheng20180424.model;

import java.util.concurrent.TimeUnit;

import chencheng.bwie.com.chencheng20180424.bean.UserBean;
import chencheng.bwie.com.chencheng20180424.net.ApiService;
import chencheng.bwie.com.chencheng20180424.net.LoggingInterceptor;
import chencheng.bwie.com.chencheng20180424.net.RetrofitUnitl;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;

/**
 * Created by dell on 2018/4/24.
 */

public class PersonModel {
    //https://www.zhaoapi.cn/user/getUserInfo?uid=100
    public void getPersonData(int uid, final ModelCallBack.PersonCallBack callBack){
        //使用okhttp请求,添加拦截器时把下面代码解释
        OkHttpClient ok = new OkHttpClient.Builder()
                .connectTimeout(20000, TimeUnit.SECONDS)
                .writeTimeout(20000,TimeUnit.SECONDS)
                .readTimeout(20000,TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .build();

        //使用Retrofit结合RxJava，okhttp封装类的单例模式
        RetrofitUnitl.getInstance("https://www.zhaoapi.cn",ok)
                .setCreate(ApiService.class)
                .person(uid)
                .subscribeOn(Schedulers.io())               //请求完成后在io线程中执行
                .observeOn(AndroidSchedulers.mainThread())  //最后在主线程中执行

                //进行事件的订阅，使用Consumer实现
                .subscribe(new Consumer<UserBean>() {
                    @Override
                    public void accept(UserBean personInfoBean) throws Exception {
                        //请求成功时返回数据
                        callBack.success(personInfoBean);
                        System.out.println("m个人信息：" + personInfoBean.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callBack.failed(throwable);
                    }
                });
    }

}
