package chencheng.bwie.com.chencheng20180424.presenter;

import chencheng.bwie.com.chencheng20180424.bean.UserBean;
import chencheng.bwie.com.chencheng20180424.model.ModelCallBack;
import chencheng.bwie.com.chencheng20180424.model.PersonModel;
import chencheng.bwie.com.chencheng20180424.view.MyView;

/**
 * Created by dell on 2018/4/24.
 */

public class PersonPresenter {
    PersonModel personModel = new PersonModel();
    MyView.PersonView personView;
    public PersonPresenter(MyView.PersonView personView) {
        this.personView = personView;
    }

    public void getData(int uid) {
        personModel.getPersonData(uid, new ModelCallBack.PersonCallBack() {
            @Override
            public void success(UserBean personInfoBean) {
                personView.sucess(personInfoBean);
                System.out.println("个人p数据："+personInfoBean.toString());
            }

            @Override
            public void failed(Throwable code) {
                System.out.println("个人p错误："+code);
            }
        });
    }
}
