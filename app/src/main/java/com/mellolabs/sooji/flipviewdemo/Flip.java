package com.mellolabs.sooji.flipviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
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

    public void reset(){
        mImageTop.setVisibility(VISIBLE);
        mImageBottom.setVisibility(VISIBLE);
        mImageBottomBack.setVisibility(INVISIBLE);
    }

    public void start(){

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
