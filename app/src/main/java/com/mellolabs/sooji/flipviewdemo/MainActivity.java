package com.mellolabs.sooji.flipviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by soo-ji on 17-01-20.
 */
public class MainActivity extends AppCompatActivity {

    private Button mBtnStart;
    private Flip mFlipView;
    private Button mBtnReset;
    private FlipList mFlipList;

    @SuppressWarnings("all")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mFlipView = (Flip) findViewById(R.id.flip_view);

        mFlipList = (FlipList) findViewById(R.id.flip_list);
        mFlipList.setNumber(2017);
        mFlipList.flipToNumber(2036);
        mBtnStart = (Button) findViewById(R.id.btn_anim_start);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mFlipView.start();
                mFlipList.start();
            }
        });
        mBtnReset = (Button) findViewById(R.id.btn_reset);
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFlipView.reset();
            }
        });
    }
}
