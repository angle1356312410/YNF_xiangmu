package com.example.dell.ynf_xiangmu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.ynf_xiangmu.All_recyclerView;
import com.example.dell.ynf_xiangmu.Bean;
import com.example.dell.ynf_xiangmu.R;

import java.util.ArrayList;

import static android.R.id.list;
import static com.example.dell.ynf_xiangmu.R.id.re_price2;

/**
 * Created by DELL on 2017/7/10.
 */
public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.ViewHolder> {
    Context context;
    ArrayList<Bean.DataBean.DefaultGoodsListBean> list;

    public MyAdapter1(Context context, ArrayList<Bean.DataBean.DefaultGoodsListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        ViewHolder holder =new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    Glide.with(context).load(list.get(position).getGoods_img()).error(R.mipmap.ic_launcher).into(holder.re_image);
        holder.re_content.setText(list.get(position).getGoods_name());
        holder.re_price1.setText(list.get(position).getMarket_price());
        Log.e(">>>>>>>>>>>>>>>>", "onBindViewHolder: "+list.get(position).getShop_price() );
        holder.re_price2.setText( list.get(position).getShop_price()+"");





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


         final ImageView re_image;
         final TextView re_content;
        final TextView re_price1;
        final TextView re_price2;

        public ViewHolder(View itemView) {
            super(itemView);
            re_image = (ImageView) itemView.findViewById(R.id.re_image);
            re_content = (TextView) itemView.findViewById(R.id.re_centent);
            re_price1 = (TextView) itemView.findViewById(R.id.re_price1);
            re_price2 = (TextView) itemView.findViewById(R.id.re_price2);


        }
    }
}

