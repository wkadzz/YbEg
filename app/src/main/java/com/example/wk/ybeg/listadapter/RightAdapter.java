package com.example.wk.ybeg.listadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wk.ybeg.R;
import com.example.wk.ybeg.model.FeiLeiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WK on 2016/11/30.
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> implements View.OnClickListener {
    private List<FeiLeiModel.ListBean.ChildrenBean>data;
    private LayoutInflater inflater;
    private ItemOnClickListener listener;
    private String TAG="sss";

    public interface ItemOnClickListener{
        void OnItemListener(int position);
    }
    public RightAdapter(Context context){
        inflater=LayoutInflater.from(context);
        data=new ArrayList<>();

    }

    public void setListener(ItemOnClickListener listener) {
        this.listener = listener;
    }

    public void upDataRes(List<FeiLeiModel.ListBean.ChildrenBean>data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();

        }
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getSpanCount();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder=null;
        switch (viewType) {
            case 1:
                viewHolder = new ViewHolder(inflater.inflate(R.layout.right_item, parent, false));
                break;
            case 3:
                viewHolder = new ViewHolder(inflater.inflate(R.layout.right_item_title, parent, false));
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data.get(position).getCat_name());
        holder.textView.setTag(data.get(position).getCat_id());
        holder.textView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return data!=null?data.size():0;
    }

    @Override
    public void onClick(View v) {
        String tag = (String) v.getTag();
        Log.e(TAG, "onClick: "+tag );
        listener.OnItemListener(Integer.parseInt(tag));

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.right_tv);
        }
    }
}
