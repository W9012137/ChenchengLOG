package chencheng.bwie.com.chencheng20180424.model;

import chencheng.bwie.com.chencheng20180424.bean.LogBean;
import chencheng.bwie.com.chencheng20180424.bean.RegBean;
import chencheng.bwie.com.chencheng20180424.bean.UserBean;

/**
 * Created by dell on 2018/4/24.
 */

public interface ModelCallBack {
    public interface LoginCallBack{
        //登录时，数据获取成功的方法，返回一个值表示登陆成功
        public void success(LogBean loginBean);
        //登录时，数据获取失败的方法，返回一个int值响应码表示登陆失败
        public void failed(Throwable code);
    }

    public interface RegCallBack {
        //注册时，数据获取成功的方法，返回一个值表示登陆成功
        public void success(RegBean regBean);
        //注册时，数据获取失败的方法，返回一个int值响应码表示登陆失败
        public void failed(Throwable code);
    }

    //个人中心
    public interface PersonCallBack{
        void success(UserBean personBean);
        void failed(Throwable code);
    }
}
