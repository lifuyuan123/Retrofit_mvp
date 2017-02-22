package azsecuer.zhuoxin.com.retrofit_mvp;

import android.support.annotation.UiThread;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2017/2/21.
 */

public class MyPresenter {
    private MyView myView;//视图层的接口

    public MyPresenter(MyView myView) {
        this.myView = myView;
    }

    public void OnCreat(){
        EventBus.getDefault().register(this);
    }
    public void OnDestory(){
        EventBus.getDefault().unregister(this);
    }

//    modle层异步加载数据
    @UiThread
    public void loadingData(){
        myView.showprogress();//显示加载
        new MyModle().asyncloadingdata();//modle层异步加载数据
    }
    //从eventbus获取到数据
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBus(MyEventbus myEventbus){
        myView.hideprogress();//加载成功隐藏加载
        if(myEventbus.list==null){
            myView.showMessage("list为空，加载失败");
        }
        myView.setdata(myEventbus.list);
    }


}
