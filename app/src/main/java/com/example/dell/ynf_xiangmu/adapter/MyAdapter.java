package com.example.dell.ynf_xiangmu.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.ynf_xiangmu.Bean;
import com.example.dell.ynf_xiangmu.R;

import java.util.ArrayList;

import static android.R.id.list;
import static android.os.Build.VERSION_CODES.M;
import static com.example.dell.ynf_xiangmu.R.id.parallax;
import static com.example.dell.ynf_xiangmu.R.id.re_centent;
import static com.example.dell.ynf_xiangmu.R.id.re_image;
import static com.example.dell.ynf_xiangmu.R.id.re_price1;
import static com.example.dell.ynf_xiangmu.R.id.re_price2;

/**
 * Created by DELL on 2017/7/11.
 */

public class MyAdapter extends BaseAdapter {

    FragmentActivity context;
    ArrayList<Bean.DataBean.DefaultGoodsListBean> list;
    private ViewHolder holder;


    public MyAdapter(FragmentActivity context, ArrayList<Bean.DataBean.DefaultGoodsListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      if (convertView==null){
                 convertView= View.inflate(context, R.layout.item,null);
                 holder = new ViewHolder();
                 holder.re_image=(ImageView) convertView.findViewById(R.id.re_image);
                 holder.re_centent=(TextView) convertView.findViewById(R.id.re_centent);
                 holder.re_price1=(TextView) convertView.findViewById(R.id.re_price1);

                 convertView.setTag(holder);
             }else {
                 holder=(ViewHolder)  convertView.getTag() ;
             }
         Glide.with(context).load(list.get(position).getGoods_img()).error(R.mipmap.ic_launcher).into(holder.re_image);
            holder.re_centent.setText(list.get(position).getGoods_name());
            holder.re_price1.setText(list.get(position).getMarket_price());

             return convertView;
         }


    class ViewHolder {
        ImageView re_image;
        TextView re_centent;
        TextView re_price1;

    }
}
