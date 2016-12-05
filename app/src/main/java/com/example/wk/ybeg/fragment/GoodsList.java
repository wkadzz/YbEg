package com.example.wk.ybeg.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wk.ybeg.R;
import com.example.wk.ybeg.activity.GoodsActivity;
import com.example.wk.ybeg.listadapter.GoodsAdapter;
import com.example.wk.ybeg.model.Goods;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WK on 2016/11/25.
 */
public class GoodsList extends BaseFragment implements AdapterView.OnItemClickListener {
//    董辉辉、
    public static final String TAG=GoodsList.class.getSimpleName();
    private ListView mList;
    private GoodsAdapter adapter;
    private List<Goods> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.goods_list,container,false);
        return view; }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mList = ((ListView) view.findViewById(R.id.goodsList));
        adapter = new GoodsAdapter(getContext());
        mList.setAdapter(adapter);
        getData();
        mList.setOnItemClickListener(this);
    }

    public void getData() {
        x.http().get(new RequestParams("http://www.yb1983.com/json/goodsList.php?page=0&field=shop_price&order=desc&brand=&cat_id="+getArguments().getInt("id")), new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
//                Log.e(TAG, "onSuccess: "+result );
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    data=new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        String s = jsonArray.get(i).toString();
                        Gson gson = new Gson();
                        Goods goods = gson.fromJson(s, Goods.class);
                        data.add(goods);
                    }
                    if (data.size()==0) {
                        Toast.makeText(getActivity(), "暂无数据", Toast.LENGTH_SHORT).show();
                    }
                    adapter.upDataRes(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String goods_id = data.get(position).getGoods_id();
        Log.e(TAG, "onItemClick: "+goods_id );
        Intent intent = new Intent(getActivity(), GoodsActivity.class);
        intent.putExtra("id",goods_id);
        startActivity(intent);
    }
}
