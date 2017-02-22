package azsecuer.zhuoxin.com.retrofit_mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

import azsecuer.zhuoxin.com.retrofit_mvp.out.Demo;
import azsecuer.zhuoxin.com.retrofit_mvp.out.Mydapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MyView {


    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    private MyPresenter myPresenter;
    private Mydapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        myPresenter=new MyPresenter(this);
        myPresenter.OnCreat();
        init();

    }

    private void init() {
        adapter=new Mydapter(this);
        listview.setAdapter(adapter);
        adapter.setCallback(new Mydapter.Callback() {
            @Override
            public void click(int k) {

            }

            @Override
            public void longclick(int k) {

            }
        });

    }

    @OnClick(R.id.button)
    public void onClick() {
        myPresenter.loadingData();
    }

    @Override
    public void showprogress() {
        progress.setVisibility(View.VISIBLE);
        button.setVisibility(View.GONE);

    }

    @Override
    public void hideprogress() {
       progress.setVisibility(View.GONE);
        button.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setdata(List<Demo.ResultBean.DataBean> list) {
        adapter.setLists(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myPresenter.OnDestory();
    }
}
