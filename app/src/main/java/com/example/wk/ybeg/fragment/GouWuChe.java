package com.example.wk.ybeg.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wk.ybeg.App;
import com.example.wk.ybeg.R;
import com.example.wk.ybeg.listadapter.GoodsAdapter;
import com.example.wk.ybeg.model.Goods;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.List;

/**
 * Created by WK on 2016/11/25.
 */
public class GouWuChe extends BaseFragment {
    public static final String TAG=GouWuChe.class.getSimpleName();
    private ListView lv;
    private GoodsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.gouwuche,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv = (ListView) view.findViewById(R.id.lv);
        adapter = new GoodsAdapter(getContext());
        lv.setAdapter(adapter);
        getData();
    }

    private void getData() {
        DbManager db = x.getDb(App.daoConfig);
        try {
            List<Goods> all = db.findAll(Goods.class);
            if (all == null||all.size()==0) {
                Toast.makeText(getActivity(), "购物车暂无内容，请添加", Toast.LENGTH_SHORT).show();
            }
            adapter.upDataRes(all);
        } catch (DbException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), "购物车暂无内容，请添加", Toast.LENGTH_SHORT).show();
        }

    }
}
