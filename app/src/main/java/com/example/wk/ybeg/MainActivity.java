package com.example.wk.ybeg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.wk.ybeg.activity.BaseActivity;
import com.example.wk.ybeg.fragment.FenLei;
import com.example.wk.ybeg.fragment.GengDuo;
import com.example.wk.ybeg.fragment.GoodsList;
import com.example.wk.ybeg.fragment.GouWuChe;
import com.example.wk.ybeg.fragment.Pinpai;
import com.example.wk.ybeg.fragment.ShowYeFragment;
import com.example.wk.ybeg.fragment.WoDe;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private static final String TAG = "ssss";
    private RadioGroup mRadioGroup;
    private Fragment showFragment;
    private RadioButton goods;
    private RadioButton fenLie;
    private RadioButton mGouweche;
    private RadioButton wode;
    private RadioButton pinpai;
    private long exitTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        goods = (RadioButton) findViewById(R.id.rb_goods);
        fenLie = (RadioButton) findViewById(R.id.rb_fenlei);
        mGouweche = (RadioButton) findViewById(R.id.rb_gouwuche);
        wode = (RadioButton) findViewById(R.id.rb_wode);
        pinpai = (RadioButton) findViewById(R.id.rb_pinpai);
        mRadioGroup = (RadioGroup) findViewById(R.id.rg);
        mRadioGroup.setOnCheckedChangeListener(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        showFragment = new ShowYeFragment();
        transaction.add(R.id.fl_discover, showFragment, ShowYeFragment.TAG);
        transaction.commit();
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (checkedId) {
            case R.id.rb_shouye:
                addFragment(ShowYeFragment.class, fragmentManager, transaction,  ShowYeFragment.TAG);
                break;
            case R.id.rb_fenlei:

                addFragment(FenLei.class, fragmentManager, transaction, FenLei.TAG);
                break;
            case R.id.rb_gouwuche:
                addFragment(GouWuChe.class, fragmentManager, transaction, GouWuChe.TAG);
                break;
            case R.id.rb_wode:
                addFragment(WoDe.class, fragmentManager, transaction, WoDe.TAG);
                break;
            case R.id.rb_gengduo:
                addFragment(GengDuo.class, fragmentManager, transaction, GengDuo.TAG);
                break;
            case R.id.rb_pinpai:
                addFragment(Pinpai.class, fragmentManager, transaction, Pinpai.TAG);
                break;

        }
        transaction.commit();
    }

    private void addFragment(Class<? extends Fragment> clazz, FragmentManager fragmentManager, FragmentTransaction transaction, String tag) {
        transaction.hide(showFragment);
        showFragment =  fragmentManager.findFragmentByTag(tag);
        if (showFragment != null) {
            transaction.show(showFragment);
        } else {
            try {
                try {
                    showFragment = clazz.getConstructor().newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            transaction.add(R.id.fl_discover, showFragment, tag);
        }
    }
    public void StartList(int pos){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(showFragment);
        showFragment = new GoodsList();

        Bundle args = new Bundle();
        args.putInt("id",pos);
        showFragment.setArguments(args);
        goods.setChecked(true);
        transaction.add(R.id.fl_discover, showFragment, GoodsList.TAG);
        transaction.commit();
//        Toast.makeText(MainActivity.this, pos+"", Toast.LENGTH_SHORT).show();

    }
    public void getRadioBtn(String s,int id){
        switch (id) {
            case 2:
                fenLie.setChecked(true);
                break;
            case 3:
                mGouweche.setChecked(true);
                break;
            case 4:
                wode.setChecked(true);
                break;
            case 6:
                StartList(0);
                break;
            case 8:
                pinpai.setChecked(true);
                break;
            case 9:
                break;

        }

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN)
        {
            if((System.currentTimeMillis()-exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                Log.e(TAG, "onKeyDown: " );
                Toast.makeText(getApplicationContext(), "再按一次退出",Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            }
            else
            {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
