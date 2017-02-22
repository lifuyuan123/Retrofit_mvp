package azsecuer.zhuoxin.com.retrofit_mvp;

import azsecuer.zhuoxin.com.retrofit_mvp.out.Demo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/2/21.
 */

public interface URL {
    @GET("/toutiao/index")
    Call<Demo> getdata(@Query("type")String type,@Query("key") String key);
}
