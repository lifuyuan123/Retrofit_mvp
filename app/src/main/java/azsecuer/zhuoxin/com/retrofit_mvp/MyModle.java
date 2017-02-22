package azsecuer.zhuoxin.com.retrofit_mvp;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import azsecuer.zhuoxin.com.retrofit_mvp.out.Demo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Administrator on 2017/2/21.
 */
//业务逻辑层  获取数据
public class MyModle {
    private URL url;
    public static MyModle mymodle;
    Retrofit retrofit;
    String name;
    private List<Demo.ResultBean.DataBean> lists=new ArrayList<>();
    public static MyModle getInstentce(){
        if (mymodle==null){
            mymodle=new MyModle();
        }
        return mymodle;
    }

    public MyModle() {

        retrofit=new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
             url=retrofit.create(URL.class);

    }

    public void asyncloadingdata(){
            url.getdata("top","aa4ef3e8bb94a9ac75be9e58fe00c1df").enqueue(new Callback<Demo>() {
            @Override
            public void onResponse(Call<Demo> call, Response<Demo> response) {
                if(response!=null){
                    Log.i("111111111111",response.body().getResult().getData().toString()+"");
                    Log.i("111111111","1111111111111111");
                    lists = response.body().getResult().getData();
                    EventBus.getDefault().post(new MyEventbus(lists));
                }else {
                    Log.i("111111111111",response.message());
                }


            }

            @Override
            public void onFailure(Call<Demo> call, Throwable t) {

            }
        });
    }


}
