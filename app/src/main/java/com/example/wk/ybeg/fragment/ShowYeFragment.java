package com.example.wk.ybeg.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.wk.ybeg.MainActivity;
import com.example.wk.ybeg.R;
import com.example.wk.ybeg.activity.DiTu;
import com.rock.qrcodelibrary.CaptureActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by WK on 2016/11/25.
 */
public class ShowYeFragment extends BaseFragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
//    董辉辉、
    public static final String TAG=ShowYeFragment.class.getSimpleName();
    private ImageView mimg;
    private RadioGroup mRG;
    private EditText met;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.showye,container,false);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        view.findViewById(R.id.img1).setOnClickListener(this);
        view.findViewById(R.id.img2).setOnClickListener(this);
        view.findViewById(R.id.img3).setOnClickListener(this);
        view.findViewById(R.id.img4).setOnClickListener(this);
        view.findViewById(R.id.img5).setOnClickListener(this);
        view.findViewById(R.id.img6).setOnClickListener(this);
        view.findViewById(R.id.img7).setOnClickListener(this);
        view.findViewById(R.id.img8).setOnClickListener(this);
        view.findViewById(R.id.left).setOnClickListener(this);
        view.findViewById(R.id.right).setOnClickListener(this);
        view.findViewById(R.id.bt).setOnClickListener(this);
        mimg = ((ImageView) view.findViewById(R.id.shouye_img));
        mRG = ((RadioGroup) view.findViewById(R.id.shouye_rg));
        mRG.setOnCheckedChangeListener(this);
        met = ((EditText) view.findViewById(R.id.et));
        Picasso.with(getContext()).load("http://img0.imgtn.bdimg.com/it/u=3304170896,1670482334&fm=23&gp=0.jpg").into(mimg);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img1:
                ((MainActivity) getActivity()).getRadioBtn(null,2);
                break;
            case R.id.img2:
                ((MainActivity) getActivity()).getRadioBtn(null,8);
                break;
            case R.id.img3:
                ((MainActivity) getActivity()).getRadioBtn(null,4);
                break;
            case R.id.img4:
                ((MainActivity) getActivity()).getRadioBtn(null,9);
                break;
            case R.id.img5:
                ((MainActivity) getActivity()).getRadioBtn(null,6);
                break;
            case R.id.img6:
                ((MainActivity) getActivity()).getRadioBtn(null,3);
                break;
            case R.id.img7:
                startActivity(new Intent(getActivity(), DiTu.class));
                break;
            case R.id.img8:
//                Log.e(TAG, "onClick: "+"ssss" );
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:10010")));
                break;
            case R.id.left:
                ((MainActivity) getActivity()).getRadioBtn(null,2);
                break;
            case R.id.right:
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent,990);
                break;
            case R.id.bt:

                String s = String.valueOf(met.getText());
                if (!s.equals("")){
                    ((MainActivity) getActivity()).getRadioBtn(s,6);
                }
                else {

                    Toast.makeText(getContext(), "关键字不能为空^_^", Toast.LENGTH_SHORT).show();

                }

                break;
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb1:
                met.setHint("请输入商品信息");

                break;
            case R.id.rb2:
                met.setHint("请输入店铺信息");
                break;
        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==getActivity().RESULT_OK) {
            if (requestCode==990) {
                String stringExtra = data.getStringExtra(CaptureActivity.RESULT);
                Toast.makeText(getActivity(), stringExtra, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
