package com.example.wk.ybeg.listadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wk.ybeg.R;
import com.example.wk.ybeg.model.PinPai;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WK on 2016/12/5.
 */
public class PinpaiAda extends RecyclerView.Adapter<PinpaiAda.ViewHolder> {
    private List<PinPai> data;
    private LayoutInflater inflater;

    public PinpaiAda(Context context) {
        inflater=LayoutInflater.from(context);
        data=new ArrayList<>();
    }
    public void upDataRes(List<PinPai> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.right_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(data.get(position).getBrand_name());

    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.right_tv);
        }
    }
}
