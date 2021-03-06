package com.teamnexters.zipsa.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.teamnexters.zipsa.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity {
    @BindView(R.id.start_activity_main_icon) ImageView mainIconImage;
    public final static long ONE_SECOND = 1000;

    Handler handler;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(StartActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        Glide.with(this).load(R.drawable.icon_zipsa).into(mainIconImage);

        createHandler();
        handler.postDelayed(runnable, ONE_SECOND);
    }

    public void createHandler() {
        handler = new Handler();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handler.removeCallbacks(runnable);
    }

}
