package com.mellolabs.sooji.flipviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by soo-ji on 17-01-20.
 */
public class Flip extends RelativeLayout {
    private Bitmap b;
    private Matrix m;
    private ImageView mImageTopBack;
    private ImageView mImageTop;
    private ImageView mImageBottom;
    private ImageView mImageBottomBack;
    private boolean mShouldFlip = false;
    private int mCurrentNum = -1;


    public Flip(Context context) {
        super(context);
        init();
    }

    public Flip(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Flip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        View.inflate(getContext(), R.layout.layout_flip_view, this);
        mImageTopBack = (ImageView) findViewById(R.id.image_top_back);
        mImageTop = (ImageView) findViewById(R.id.image_top);
        mImageBottom = (ImageView) findViewById(R.id.image_bottom);
        mImageBottomBack = (ImageView) findViewById(R.id.image_bottom_back);


    }

    public void setOrigNum(int num){
        mCurrentNum = num;
        switch (num){
            case 0:
                mImageTop.setImageResource(R.drawable.parts_0_top);
                mImageBottom.setImageResource(R.drawable.parts_0_bottom);
                break;
            case 1:
                mImageTop.setImageResource(R.drawable.parts_1_top);
                mImageBottom.setImageResource(R.drawable.parts_1_bottom);
                break;
            case 2:
                mImageTop.setImageResource(R.drawable.parts_2_top);
                mImageBottom.setImageResource(R.drawable.parts_2_bottom);
                break;
            case 3:
                mImageTop.setImageResource(R.drawable.parts_3_top);
                mImageBottom.setImageResource(R.drawable.parts_3_bottom);
                break;
            case 4:
                mImageTop.setImageResource(R.drawable.parts_4_top);
                mImageBottom.setImageResource(R.drawable.parts_4_bottom);
                break;
            case 5:
                mImageTop.setImageResource(R.drawable.parts_5_top);
                mImageBottom.setImageResource(R.drawable.parts_5_bottom);
                break;
            case 6:
                mImageTop.setImageResource(R.drawable.parts_6_top);
                mImageBottom.setImageResource(R.drawable.parts_6_bottom);
                break;
            case 7:
                mImageTop.setImageResource(R.drawable.parts_7_top);
                mImageBottom.setImageResource(R.drawable.parts_7_bottom);
                break;
            case 8:
                mImageTop.setImageResource(R.drawable.parts_8_top);
                mImageBottom.setImageResource(R.drawable.parts_8_bottom);
                break;
            case 9:
                mImageTop.setImageResource(R.drawable.parts_9_top);
                mImageBottom.setImageResource(R.drawable.parts_9_bottom);
                break;
        }
    }

    public void flipTo(int num){
        if(num < 0 || num > 9){
            Log.e("FLIP", "invalid input");
            return;
        }
        if(mCurrentNum == num){
            mShouldFlip = false;
            return;
        }
        mShouldFlip = true;
        switch (num){
            case 0:
                mImageTopBack.setImageResource(R.drawable.parts_0_top);
                mImageBottomBack.setImageResource(R.drawable.parts_0_bottom);
                break;
            case 1:
                mImageTopBack.setImageResource(R.drawable.parts_1_top);
                mImageBottomBack.setImageResource(R.drawable.parts_1_bottom);
                break;
            case 2:
                mImageTopBack.setImageResource(R.drawable.parts_2_top);
                mImageBottomBack.setImageResource(R.drawable.parts_2_bottom);
                break;
            case 3:
                mImageTopBack.setImageResource(R.drawable.parts_3_top);
                mImageBottomBack.setImageResource(R.drawable.parts_3_bottom);
                break;
            case 4:
                mImageTopBack.setImageResource(R.drawable.parts_4_top);
                mImageBottomBack.setImageResource(R.drawable.parts_4_bottom);
                break;
            case 5:
                mImageTopBack.setImageResource(R.drawable.parts_5_top);
                mImageBottomBack.setImageResource(R.drawable.parts_5_bottom);
                break;
            case 6:
                mImageTopBack.setImageResource(R.drawable.parts_6_top);
                mImageBottomBack.setImageResource(R.drawable.parts_6_bottom);
                break;
            case 7:
                mImageTopBack.setImageResource(R.drawable.parts_7_top);
                mImageBottomBack.setImageResource(R.drawable.parts_7_bottom);
                break;
            case 8:
                mImageTopBack.setImageResource(R.drawable.parts_8_top);
                mImageBottomBack.setImageResource(R.drawable.parts_8_bottom);
                break;
            case 9:
                mImageTopBack.setImageResource(R.drawable.parts_9_top);
                mImageBottomBack.setImageResource(R.drawable.parts_9_bottom);
                break;
        }


    }

    public void reset(){
        mImageTop.setVisibility(VISIBLE);
        mImageBottom.setVisibility(VISIBLE);
        mImageBottomBack.setVisibility(INVISIBLE);
    }

    public void start(){
        if(!mShouldFlip){
//            Log.d("fLip", "set the number to flip to");
            return;
        }
        Animation animTopIn = AnimationUtils.loadAnimation(getContext(), R.anim.flip_top_in);
        animTopIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mImageTop.setVisibility(INVISIBLE);
                startAnimBottom();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mImageTop.startAnimation(animTopIn);


    }

    private void startAnimBottom(){
//        Animation animBottomIn = AnimationUtils.loadAnimation(getContext(), R.anim.flip_bottom_in);
//        mImageBottom.startAnimation(animBottomIn);
//        animBottomIn.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                mImageBottom.setVisibility(INVISIBLE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
        Animation animBottomOut = AnimationUtils.loadAnimation(getContext(), R.anim.flip_bottom_out);
        animBottomOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mImageBottomBack.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mImageBottom.setVisibility(INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mImageBottomBack.startAnimation(animBottomOut);
    }


}
