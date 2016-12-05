package com.example.wk.ybeg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

import com.example.wk.ybeg.MainActivity;
import com.example.wk.ybeg.R;

public class Welcome extends AppCompatActivity  implements Handler.Callback{
    private Handler handler;
    private String TAG="sssw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        handler=new Handler(this);

        final Thread thread = new Thread(){
            @Override
            public void run() {
                SystemClock.sleep(3000);
                handler.sendEmptyMessage(1000);
                Log.e(TAG, "run: " );

            }
        };
        thread.start();


    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 1000:
                finish();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
        return true;
    }
}
