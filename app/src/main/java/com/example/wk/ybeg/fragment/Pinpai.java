package com.example.wk.ybeg.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wk.ybeg.R;
import com.example.wk.ybeg.listadapter.PinpaiAda;
import com.example.wk.ybeg.model.PinPai;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WK on 2016/12/5.
 */
public class Pinpai extends BaseFragment {
    public static String TAG=Pinpai.class.getSimpleName();
    private RecyclerView lv;
    private PinpaiAda adapter;
    private List<PinPai>data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.pinpai,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv = ((RecyclerView) view.findViewById(R.id.lv));
        lv.setLayoutManager(new GridLayoutManager(getContext(),3));
        adapter = new PinpaiAda(getContext());
        lv.setAdapter(adapter);
        getdata();
    }

    private void getdata() {
        x.http().get(new RequestParams("http://www.yb1983.com/json/brand.php"), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    data=new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        String s = jsonArray.get(i).toString();
                        Gson gson = new Gson();
                        PinPai pinPai = gson.fromJson(s, PinPai.class);
                        data.add(pinPai);
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
}
