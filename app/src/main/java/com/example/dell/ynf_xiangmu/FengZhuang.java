package com.example.dell.ynf_xiangmu;

import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by DELL on 2017/7/10.
 */

public class FengZhuang {

    private static volatile FengZhuang fengzhuang;
    private Handler handler;
    private OkHttpClient client;
    private String string;
    private Bean bean;

    public static FengZhuang getFengzhuang() {
        if (fengzhuang == null) {
            fengzhuang = new FengZhuang();
        }
        return fengzhuang;
    }

    public FengZhuang() {
        this.handler = new Handler();
        this.client = new OkHttpClient();
    }

    public interface GetBeantu {
        Bean showtu(Bean bean);
    }

    public void jiexi(String url, final GetBeantu getBeantu) {

        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag", "onFailure: 失败了");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("tag", "onFailure: 成功啦");

                string = response.body().string();
                Gson gson = new Gson();
                bean = gson.fromJson(string, Bean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        getBeantu.showtu(bean);
                    }
                });


            }
        });
    }


}
