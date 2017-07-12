package com.example.dell.ynf_xiangmu.Fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.dell.ynf_xiangmu.Bean;
import com.example.dell.ynf_xiangmu.FengZhuang;
import com.example.dell.ynf_xiangmu.R;
import com.example.dell.ynf_xiangmu.adapter.MyAdapter;
import com.example.dell.ynf_xiangmu.adapter.MyAdapter1;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;



import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {
Handler handler=new Handler();
  String url="http://m.yunifang.com/yunifang/mobile/home?random=84831&encode=9dd34239798e8cb22bf99a75d1882447";
    private GridView gridview;
   ArrayList<Bean.DataBean.DefaultGoodsListBean> list=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_one, null);


        initView(view);

        OkHttp();
        return view;
    }

    private void OkHttp() {
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: 失败了" );
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                Log.e("TAG", "onResponse: 成功啦" );
                final String string = response.body().string();
                Gson gson=new Gson();
                final Bean.DataBean.DefaultGoodsListBean bean = gson.fromJson(string, Bean.DataBean.DefaultGoodsListBean.class);


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                 FengZhuang.getFengzhuang().jiexi(url, new FengZhuang.GetBeantu() {
                        @Override
                        public Bean showtu(Bean bean) {

                            bean.getData().getDefaultGoodsList().addAll(list);
                            return null;
                        }
                    });

                    }
                });


            }
        });

    }


    private void initView(View view) {
//        gridview = (GridView) view.findViewById(R.id.gridview);
//
//        MyAdapter adapter=new MyAdapter(getActivity(),list);
//        gridview.setAdapter(adapter);


    }
}
