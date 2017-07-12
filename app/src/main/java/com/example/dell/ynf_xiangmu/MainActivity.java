package com.example.dell.ynf_xiangmu;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import static android.R.id.list;
import static android.transition.Fade.IN;

public class MainActivity extends AppCompatActivity {

    private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

                final Timer timer = new Timer();
                final TimerTask take = new TimerTask() {
                    @Override
                    public void run() {

                        timer.cancel();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                                startActivity(intent);
                            }
                        });

                    }
                };
                timer.schedule(take, 2000, 1000);

    }

    private void initView() {
        image = (ImageView) findViewById(R.id.image);
    }
}
