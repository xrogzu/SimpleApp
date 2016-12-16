package com.example.hfs.simpleapp.ui.countdown;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.hfs.simpleapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CountDownActivity extends AppCompatActivity {


    @Bind(R.id.countDownView)
    CountDownView mCountDownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {
        mCountDownView.setCountDownTimerListener(new CountDownView.CountDownTimerListener() {
            @Override
            public void onStartCount() {
                Toast.makeText(getApplicationContext(), "开始计时", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinishCount() {
                Toast.makeText(getApplicationContext(), "计时结束", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.countDownView, R.id.btn_start_time})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.countDownView:
                this.finish();
                break;
            case R.id.btn_start_time:
                mCountDownView.start();
                break;
        }

    }
}
