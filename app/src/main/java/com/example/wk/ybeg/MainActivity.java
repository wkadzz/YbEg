package com.example.wk.ybeg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.example.wk.ybeg.activity.BaseActivity;
import com.example.wk.ybeg.fragment.FenLei;
import com.example.wk.ybeg.fragment.GengDuo;
import com.example.wk.ybeg.fragment.GouWuChe;
import com.example.wk.ybeg.fragment.ShowYeFragment;
import com.example.wk.ybeg.fragment.WoDe;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup mRadioGroup;
    private Fragment showFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
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
        transaction.hide(showFragment);
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
        }
        transaction.commit();
    }

    private void addFragment(Class<? extends Fragment> clazz, FragmentManager fragmentManager, FragmentTransaction transaction, String tag) {
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
}
