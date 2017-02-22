package azsecuer.zhuoxin.com.retrofit_mvp;

import java.util.List;

import azsecuer.zhuoxin.com.retrofit_mvp.out.Demo;

/**
 * Created by Administrator on 2017/2/21.
 */
//视图层
public interface MyView {
    void showprogress();
    void hideprogress();
    void setdata(List<Demo.ResultBean.DataBean> list);
    void showMessage(String s);
}
