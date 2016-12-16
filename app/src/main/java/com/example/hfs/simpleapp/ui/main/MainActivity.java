package com.example.hfs.simpleapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hfs.simpleapp.R;
import com.example.hfs.simpleapp.ui.byeburger.ByeBurgerActivity;
import com.example.hfs.simpleapp.ui.countdown.CountDownActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn_hide_and_show_title_bottom)
    Button mBtnHideAndShowTitleBottom;
    @Bind(R.id.activity_main)
    LinearLayout mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_hide_and_show_title_bottom, R.id.btn_ad_count_down})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_hide_and_show_title_bottom:
                jump(ByeBurgerActivity.class);
                break;
            case R.id.btn_ad_count_down:
                jump(CountDownActivity.class);
                break;
        }
    }

    /**
     * 跳转到相应界面
     *
     * @param clz 要跳转的Activity
     */
    public void jump(Class clz) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        startActivity(intent);
    }
}
