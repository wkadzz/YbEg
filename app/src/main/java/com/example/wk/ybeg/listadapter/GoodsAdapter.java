package com.example.wk.ybeg.listadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wk.ybeg.R;
import com.example.wk.ybeg.model.Goods;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WK on 2016/12/1.
 */
public class GoodsAdapter extends BaseAdapter {
    private static final String TAG = "dd";
    private List<Goods> data;
    private LayoutInflater inflater;
    private Context context;

    public GoodsAdapter(Context context) {
        inflater=LayoutInflater.from(context);
        data=new ArrayList<>();
        this.context=context;
    }
    public void upDataRes(List<Goods> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Goods getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null) {
            convertView=inflater.inflate(R.layout.goods_item,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder= (ViewHolder) convertView.getTag();
        }
        Log.e(TAG, "getView: "+ getItem(position).getGoods_name());
        holder.title.setText(getItem(position).getGoods_name());
        holder.price.setText("￥ "+getItem(position).getShop_price()+"元");
        holder.count.setText("点击："+getItem(position).getClick_count()+"次");
        Picasso.with(context).load("http://www.yb1983.com/"+getItem(position).getGoods_thumb()).into(holder.img);
        return convertView;
    }

    public static class ViewHolder {
        ImageView img;
        TextView title, price, count;

        public ViewHolder(View itemView) {
            title = (TextView) itemView.findViewById(R.id.goods_title);
            img = (ImageView) itemView.findViewById(R.id.goods_img);
            price = (TextView) itemView.findViewById(R.id.goods_price);
            count = (TextView) itemView.findViewById(R.id.goods_count);
        }
    }
}
