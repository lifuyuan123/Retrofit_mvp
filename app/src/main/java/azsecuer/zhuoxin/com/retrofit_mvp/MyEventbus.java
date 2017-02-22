package azsecuer.zhuoxin.com.retrofit_mvp;

import java.util.List;

import azsecuer.zhuoxin.com.retrofit_mvp.out.Demo;

/**
 * Created by Administrator on 2017/2/21.
 */
//用于Eventbus传输的实体类（传送list）
public class MyEventbus {
     List<Demo.ResultBean.DataBean> list;
    public MyEventbus() {
    }

    public MyEventbus(List<Demo.ResultBean.DataBean> list) {
        this.list = list;
    }
}
