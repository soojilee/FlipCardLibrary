package com.mellolabs.sooji.flipviewdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by soojilee on 2017-02-01.
 */

public class FlipList extends LinearLayout {
    private static final String TAG = "FLIPLIST";
    private ArrayList<Integer> mDigits;
    private int mCurrentNum;
    private int mNumDigitLimit=0;
    private LinearLayout mNumContainer;
    private ArrayList<Integer> mNewDigits;

    public FlipList(Context context) {
        super(context);
        init();
    }

    public FlipList(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FlipList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mDigits = new ArrayList<>();
        mNewDigits = new ArrayList<>();
        mNumContainer = new LinearLayout(getContext());
        mNumContainer.setOrientation(HORIZONTAL);
    }

    public void setNumber(int num){
        mCurrentNum = num;
        while(num > 0) {
            ++mNumDigitLimit;
            mDigits.add(num % 10);
            num = num / 10;
        }

        for(int i = mDigits.size()-1; i==0; --i){
            Flip flip = new Flip(getContext());
            flip.setOrigNum(mDigits.get(i));
            mNumContainer.addView(flip);
        }

    }

    private int getNumDigits(int num){
        int numdigits = 0;
        while(num > 0){
            ++numdigits;
            num = num/10;
        }
        return numdigits;
    }

    public void flipToNumber(int num){
        if(getNumDigits(num) > mNumDigitLimit || num < 0){
            Log.e(TAG,"Cannot flip to number: "+num+". Out of Range");
            return;
        }

        while(num > 0) {
            ++mNumDigitLimit;
            mNewDigits.add(num % 10);
            num = num / 10;
        }

        

    }
}