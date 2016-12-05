package com.example.wk.ybeg.listadapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wk.ybeg.R;
import com.example.wk.ybeg.model.FeiLeiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WK on 2016/11/29.
 */
public class LeftList extends BaseAdapter implements View.OnClickListener, RightAdapter.ItemOnClickListener {
    private List<FeiLeiModel> data;
    private List<FeiLeiModel.ListBean.ChildrenBean>dataRight;
    private LayoutInflater inflater;
    private RightAdapter rightAdapter;
    private RecyclerView list2;
    private Context context;
    private GetListListener listListener;

    public void setListListener(GetListListener listListener) {
        this.listListener = listListener;
    }

    public interface GetListListener{
        void GetListener(int id);
    }
    private String TAG="ssss";

    public LeftList(Context context, RecyclerView list2) {
        this.list2=list2;
        inflater = LayoutInflater.from(context);
        this.context=context;
        data = new ArrayList<>();
    }

    public void upDataRes(List<FeiLeiModel> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public FeiLeiModel getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.left_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (getItem(position).ischecked()) {
            viewHolder.tv.setBackgroundResource(R.drawable.list_back_1);
        } else {
            viewHolder.tv.setBackgroundResource(R.drawable.list_back_2);
        }
        viewHolder.tv.setTag(position);
        viewHolder.tv.setOnClickListener(this);
        viewHolder.tv.setText(getItem(position).getCat_name());

        return convertView;
    }

    @Override
    public void onClick(View v) {
        Integer location = (Integer) v.getTag();
        dataRight=new ArrayList<>();
        List<FeiLeiModel.ListBean> list = data.get(location).getList();
        for (FeiLeiModel.ListBean listBean : list) {
            FeiLeiModel.ListBean.ChildrenBean bean = new FeiLeiModel.ListBean.ChildrenBean();
            bean.setCat_id(listBean.getCat_id());
            bean.setCat_name(listBean.getCat_name());
            bean.setSpanCount(3);
            dataRight.add(bean);
            List<FeiLeiModel.ListBean.ChildrenBean> children = listBean.getChildren();
            for (FeiLeiModel.ListBean.ChildrenBean child : children) {
                dataRight.add(child);
            }
        }
        Log.e(TAG, "onClick: "+dataRight.size() );
        GridLayoutManager layout = new GridLayoutManager(context, 3);
        layout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return dataRight.get(position).getSpanCount();
            }
        });
        list2.setLayoutManager(layout);
        rightAdapter = new RightAdapter(context);
        list2.setAdapter(rightAdapter);
        rightAdapter.setListener(this);
        for (FeiLeiModel feiLeiModel : data) {
            feiLeiModel.setIschecked(false);
        }
        notifyDataSetChanged();

        rightAdapter.upDataRes(dataRight);
        data.get(location).setIschecked(true);
        v.setBackgroundResource(R.drawable.list_back_1);
    }

    @Override
    public void OnItemListener(int position) {
        listListener.GetListener(position);

    }

    public static class ViewHolder {
        TextView tv;
        public ViewHolder(View itemView) {
            tv = (TextView) itemView.findViewById(R.id.left_tv);
        }
    }

}
