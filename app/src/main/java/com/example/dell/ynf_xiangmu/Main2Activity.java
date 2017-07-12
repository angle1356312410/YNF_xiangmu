package com.example.dell.ynf_xiangmu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import static android.R.attr.handle;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView image1;
    private Button text;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();
        initHandler();

        handlerSendMsg();

//
//        final Timer timer = new Timer();
//        final TimerTask take = new TimerTask() {
//            @Override
//            public void run() {
//
//                timer.cancel();
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
//                        startActivity(intent);
//                    }
//                });
//
//            }
//        };
//        timer.schedule(take, 5000, 1000);

    }

    private void initView() {
        image1 = (ImageView) findViewById(R.id.image1);
        text = (Button) findViewById(R.id.text);
        text.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text:

                startActivity(new Intent(Main2Activity.this,OneActivity.class));
                break;
        }
    }


     private void initHandler() {
         handler = new Handler(){
             @Override
             public void handleMessage(Message msg) {
                 super.handleMessage(msg);
                 int k=msg.arg1;
                 text.setText("跳过"+k+"s");

                 if (k == 1) {
                     startActivity(new Intent(Main2Activity.this,OneActivity.class));
                 }else{

                     handlerSendMsg();
                 }
             }
         };

     }
     private int j=5;
     private void handlerSendMsg() {
         Message msg= handler.obtainMessage();
         msg.arg1=j--;
         handler.sendMessageDelayed(msg,1000);

    }
}
