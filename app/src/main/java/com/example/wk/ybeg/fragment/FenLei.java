package com.example.wk.ybeg.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.wk.ybeg.MainActivity;
import com.example.wk.ybeg.R;
import com.example.wk.ybeg.listadapter.LeftList;
import com.example.wk.ybeg.listadapter.RightAdapter;
import com.example.wk.ybeg.model.FeiLeiModel;
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
public class FenLei extends BaseFragment implements RightAdapter.ItemOnClickListener, LeftList.GetListListener {
    public static final String TAG=FenLei.class.getSimpleName();
    private ListView list1;
    private RecyclerView list2;
    private LeftList adapter;
    private int curr=0;
    private List<FeiLeiModel>data;
    private List<FeiLeiModel.ListBean.ChildrenBean>dataRight;
    private RightAdapter rightAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fenlei,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        updata();
    }

    private void updata() {
        RequestParams entity = new RequestParams("http://www.yb1983.com/json/category.php");
        x.http().get(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONArray jsonArray = new JSONArray(result);
                    data=new ArrayList<>();
                    dataRight=new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        String s = jsonArray.get(i).toString();
                        Gson gson = new Gson();
                        FeiLeiModel feiLeiModel = gson.fromJson(s, FeiLeiModel.class);
//                        List<FeiLeiModel.ListBean> list = feiLeiModel.getList();
//                        for (FeiLeiModel.ListBean listBean : list) {
//                            FeiLeiModel.ListBean.ChildrenBean bean = new FeiLeiModel.ListBean.ChildrenBean();
//                            bean.setCat_id(listBean.getCat_id());
//                            bean.setCat_name(listBean.getCat_name());
//                            bean.setSpanCount(3);
//                            dataRight.add(bean);
//                            List<FeiLeiModel.ListBean.ChildrenBean> children = listBean.getChildren();
//                            for (FeiLeiModel.ListBean.ChildrenBean child : children) {
//                                dataRight.add(child);
//                            }
//                        }
                        if (i==0){
                            feiLeiModel.setIschecked(true);
                        }
                        data.add(feiLeiModel);
//                        Log.e(TAG, "onSuccess: "+feiLeiModel.getCat_id() );
                    }
                    List<FeiLeiModel.ListBean> list = data.get(0).getList();
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
                    rightAdapter.upDataRes(dataRight);

                    adapter.upDataRes(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: "+ex );

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void initView() {
        list1 = ((ListView) view.findViewById(R.id.list1));

        list2 = ((RecyclerView) view.findViewById(R.id.list2));
        GridLayoutManager layout = new GridLayoutManager(getContext(), 3);
        layout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return dataRight.get(position).getSpanCount();
            }
        });
        list2.setLayoutManager(layout);
        rightAdapter = new RightAdapter(getContext());
        list2.setAdapter(rightAdapter);
        adapter = new LeftList(getContext(),list2);
        list1.setAdapter(adapter);
        adapter.setListListener(this);
        rightAdapter.setListener(this);

    }


    @Override
    public void OnItemListener(int position) {
        ((MainActivity) getActivity()).StartList(position);
    }

    @Override
    public void GetListener(int id) {
        ((MainActivity) getActivity()).StartList(id);
    }
}
