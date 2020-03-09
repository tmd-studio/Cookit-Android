package com.tmd.core_lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class ResizeImageView extends AppCompatImageView {

    public static final int WIDTH = 0;
    public static final int HEIGHT = 1;

    private float ratio;
    private int base;

    public ResizeImageView(Context context) {
        this(context, null);
    }

    public ResizeImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ResizeImageView);
        ratio = typedArray.getFloat(R.styleable.ResizeImageView_resize_ratio, -1);
        base = typedArray.getInt(R.styleable.ResizeImageView_resize_base, -1);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (ratio > 0) {
            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = MeasureSpec.getSize(heightMeasureSpec);
            switch (base) {
                case WIDTH:
                    height = (int) Math.ceil((float) width * ratio);
                    break;
                case HEIGHT:
                    width = (int) Math.ceil((float) height * ratio);
                    break;
            }
            setMeasuredDimension(width, height);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
        invalidate();
    }

}
