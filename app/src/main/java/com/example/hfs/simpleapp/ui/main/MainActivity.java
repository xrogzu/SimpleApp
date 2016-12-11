package com.example.hfs.simpleapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hfs.simpleapp.R;
import com.example.hfs.simpleapp.ui.byeburger.ByeBurgerActivity;

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

    @OnClick({R.id.btn_hide_and_show_title_bottom})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_hide_and_show_title_bottom:
                Intent intent =new Intent();
                intent.setClass(this, ByeBurgerActivity.class);
                startActivity(intent);
                break;
        }
    }
}
