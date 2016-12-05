package com.example.wk.ybeg.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wk.ybeg.App;
import com.example.wk.ybeg.R;
import com.example.wk.ybeg.model.Goods;
import com.example.wk.ybeg.model.GoodsXQ;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.ex.DbException;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class GoodsActivity extends AppCompatActivity implements Handler.Callback, View.OnClickListener {

    private static final int REESULT = 1100;
    private String TAG="ss";
    private Handler handler;
    private TextView title;
    private TextView jiage;
    private TextView bianhao;
    private TextView cucun;
    private GoodsXQ goodsXQ;
    private TextView songJifen;
    private TextView yongjifen;
    private ImageView mimg;
    private Button jiache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        Log.e(TAG, "onCreate: "+getIntent().getStringExtra("id") );
        initView();
        getData();
    }

    private void initView() {
        handler=new Handler(this);
        title = (TextView) findViewById(R.id.title);
        jiage = (TextView) findViewById(R.id.jiage);
        bianhao = (TextView) findViewById(R.id.bianhao);
        cucun = (TextView) findViewById(R.id.kucun);
        songJifen = (TextView) findViewById(R.id.songjifen);
        yongjifen = (TextView) findViewById(R.id.yongjifen);
        mimg = (ImageView) findViewById(R.id.viewpager);
        jiache = (Button) findViewById(R.id.jiache);
        jiache.setOnClickListener(this);
    }

    public void getData() {
        x.http().get(new RequestParams("http://www.yb1983.com/json/goods.php?goods_id="+getIntent().getStringExtra("id")), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                goodsXQ = gson.fromJson(result, GoodsXQ.class);
                handler.sendEmptyMessage(REESULT);

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
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case REESULT:
                title.setText(goodsXQ.getGoods().getGoods_name()+"");
                jiage.setText("￥"+goodsXQ.getGoods().getShop_price()+"元");
                bianhao.setText("商品编号："+goodsXQ.getGoods().getGoods_sn()+"");
                cucun.setText("商品库存"+goodsXQ.getGoods().getGoods_number()+"");
                songJifen.setText("购买此商品赠送："+goodsXQ.getGoods().getGive_integral()+"积分");
                yongjifen.setText("购买此商品可使用："+goodsXQ.getGoods().getIntegral()+"积分");
                String img_url = "http://www.yb1983.com/"+goodsXQ.getGoods_gallery().get(0).getImg_url();
                Log.e(TAG, "handleMessage: "+img_url );
                Picasso.with(this).load(img_url).into(mimg);
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jiache:
                DbManager db = x.getDb(App.daoConfig);
                try {
                    Goods entity = new Goods();
                    entity.setGoods_name(goodsXQ.getGoods().getGoods_name());
                    entity.setShop_price(goodsXQ.getGoods().getShop_price()+"");
                    entity.setClick_count(goodsXQ.getGoods().getClick_count());
                    entity.setGoods_thumb(goodsXQ.getGoods_gallery().get(0).getImg_url());
                    db.saveOrUpdate(entity);
                    Toast.makeText(GoodsActivity.this, "加入购物车成功", Toast.LENGTH_SHORT).show();
                } catch (DbException e) {
                    e.printStackTrace();
                    Toast.makeText(GoodsActivity.this, "加入购物车失败", Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }
}
