package com.example.dell.ynf_xiangmu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.dell.ynf_xiangmu.adapter.MyAdapter1;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class All_recyclerView extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView recycler;
    private ImageButton image_fanhui;
     String url="http://m.yunifang.com/yunifang/mobile/home?random=84831&encode=9dd34239798e8cb22bf99a75d1882447";
    private ArrayList<Bean.DataBean.DefaultGoodsListBean> list=new ArrayList<>();
    private MyAdapter1 adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_recycler_view);
        initView();


    }

    private void initView() {
        recycler = (RecyclerView) findViewById(R.id.recycler);
        image_fanhui = (ImageButton) findViewById(R.id.image_fanhui);
        image_fanhui.setOnClickListener(this);

        adapter1 = new MyAdapter1(All_recyclerView.this,list);
        recycler.setLayoutManager(new GridLayoutManager(All_recyclerView.this,2));
        recycler.setAdapter(adapter1);

        FengZhuang.getFengzhuang().jiexi(url, new FengZhuang.GetBeantu() {
            @Override
            public Bean showtu(Bean bean) {
//                List<Bean.DataBean.DefaultGoodsListBean> been = bean.getData().getDefaultGoodsList();
                list.addAll(bean.getData().getDefaultGoodsList());
                adapter1.notifyDataSetChanged();

                return null;
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_fanhui:
                startActivity(new Intent(All_recyclerView.this,OneActivity.class));
                break;
        }
    }
}




