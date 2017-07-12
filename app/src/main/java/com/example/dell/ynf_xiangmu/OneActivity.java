package com.example.dell.ynf_xiangmu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class OneActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private Banner banner;
    private Toolbar toobar;
    private List<String> images = new ArrayList<>();
    private ImageView chu;
    private ImageView qiao;
    private ImageView you;
    private ImageView li;
    private TextView selecter;
    private RadioButton shouye;
    private RadioButton fenlei;
    private RadioButton gouwuche;
    private RadioButton wo;
    private ProgressBar progressbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        pro();


        initView();
        toolbar();



    }

    private void pro() {


        final Timer timer = new Timer();
        final TimerTask take = new TimerTask() {
            @Override
            public void run() {

                timer.cancel();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressbar.setVisibility(View.GONE);
                        getbanner();
                    }
                });

            }
        };
        timer.schedule(take, 2000, 1000);

    }

    private void getbanner() {
        Banner banner = (Banner) findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());

        images.add("https://image.yunifang.com/yunifang/images/goods/ad0/17070619513209764837049733.jpg");
        images.add("https://image.yunifang.com/yunifang/images/goods/ad0/17070519497508550972547222.jpg");
        images.add("https://image.yunifang.com/yunifang/images/goods/ad0/17062110133913261197772909.jpg");
        images.add("https://image.yunifang.com/yunifang/images/goods/ad0/170531171355414489169046156.jpg");

        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    private void toolbar() {
        toobar = (Toolbar) findViewById(R.id.toolbar);
        toobar.setTitle("御泥坊VIP商城");
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        banner = (Banner) findViewById(R.id.banner);
        chu = (ImageView) findViewById(R.id.chu);

        qiao = (ImageView) findViewById(R.id.qiao);

        you = (ImageView) findViewById(R.id.you);

        li = (ImageView) findViewById(R.id.li);

        selecter = (TextView) findViewById(R.id.selecter);
        selecter.setOnClickListener(this);
        shouye = (RadioButton) findViewById(R.id.shouye);
        shouye.setOnClickListener(this);
        fenlei = (RadioButton) findViewById(R.id.fenlei);
        fenlei.setOnClickListener(this);
        gouwuche = (RadioButton) findViewById(R.id.gouwuche);
        gouwuche.setOnClickListener(this);
        wo = (RadioButton) findViewById(R.id.wo);
        wo.setOnClickListener(this);
        progressbar = (ProgressBar) findViewById(R.id.progressbar);

    }

    @Override
    public void onClick(View v) {

        selecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this, All_recyclerView.class);
                startActivity(intent);
            }
        });

//        shouye.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(OneActivity.this, OneActivity.class);
//                startActivity(intent);
//            }
//        });
        fenlei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this, FenleiActivity.class);
                startActivity(intent);
            }
        });
        gouwuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this, GouwucheActivity.class);
                startActivity(intent);
            }
        });
        wo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this, WoActivity.class);
                startActivity(intent);
            }
        });
    }
}
