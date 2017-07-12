package com.example.dell.ynf_xiangmu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Main3Activity extends AppCompatActivity {

    private ImageView image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();

        final Timer timer = new Timer();
        final TimerTask take = new TimerTask() {
            @Override
            public void run() {

                timer.cancel();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent=new Intent(Main3Activity.this,OneActivity.class);
                        startActivity(intent);
                    }
                });

            }
        };
        timer.schedule(take, 2000, 1000);



    }

    private void initView() {
        image2 = (ImageView) findViewById(R.id.image2);
    }
}
