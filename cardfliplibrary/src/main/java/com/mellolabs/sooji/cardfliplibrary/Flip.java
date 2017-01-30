package com.mellolabs.sooji.cardfliplibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;

/**
 * Created by soo-ji on 17-01-20.
 */
public class Flip extends View {
    private Bitmap b;
    private Matrix m;

    public Flip(Context context) {
        super(context);
//        b = BitmapFactory.decodeResource(getResources(), R.drawable.parts_0_bottom);
//        m = new Matrix();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        int bw = b.getWidth();
//        int bh = b.getHeight();
//        float[] src = {0, 0, 0, bh, bw, bh, bw, 0};
//        int DX = 100;
//        float[] dst = {0 + DX, 0, 0, h, w, h, w - DX, 0};
//        m.setPolyToPoly(src, 0, dst, 0, 4);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawBitmap(b, m, null);
    }
}
