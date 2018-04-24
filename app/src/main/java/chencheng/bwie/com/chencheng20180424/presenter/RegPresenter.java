package chencheng.bwie.com.chencheng20180424.presenter;

import chencheng.bwie.com.chencheng20180424.bean.RegBean;
import chencheng.bwie.com.chencheng20180424.model.ModelCallBack;
import chencheng.bwie.com.chencheng20180424.model.RegModel;
import chencheng.bwie.com.chencheng20180424.view.MyView;

/**
 * Created by dell on 2018/4/24.
 */

public class RegPresenter {
    RegModel regModel = new RegModel();
    MyView.RegView regView;
    public RegPresenter(MyView.RegView regView) {
        this.regView = regView;
    }

    public void getData(String tel, String pwd) {
        regModel.getRegData(tel,pwd, new ModelCallBack.RegCallBack() {

            @Override
            public void success(RegBean regBean) {
                regView.sucess(regBean);
                System.out.println("注册p数据："+regBean.toString());
            }

            @Override
            public void failed(Throwable code) {
                System.out.println("注册p错误："+code);
            }
        });
    }
}
