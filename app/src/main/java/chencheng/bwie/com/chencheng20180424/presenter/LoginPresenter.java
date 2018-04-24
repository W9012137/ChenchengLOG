package chencheng.bwie.com.chencheng20180424.presenter;

import chencheng.bwie.com.chencheng20180424.bean.LogBean;
import chencheng.bwie.com.chencheng20180424.model.LoginModel;
import chencheng.bwie.com.chencheng20180424.model.ModelCallBack;
import chencheng.bwie.com.chencheng20180424.view.MyView;

/**
 * Created by dell on 2018/4/24.
 */

public class LoginPresenter {
    LoginModel loginModel = new LoginModel();
    MyView.LoginView loginView;
    public LoginPresenter(MyView.LoginView loginView) {
        this.loginView = loginView;
    }

    public void getData(String tel, String pwd) {
        loginModel.getLoginData(tel,pwd, new ModelCallBack.LoginCallBack() {
            @Override
            public void success(LogBean dengluBean) {
                loginView.success(dengluBean);
                System.out.println("登录p数据："+dengluBean.toString());
            }

            @Override
            public void failed(Throwable code) {
                System.out.println("登录p错误："+code);
            }
        });
    }
}
