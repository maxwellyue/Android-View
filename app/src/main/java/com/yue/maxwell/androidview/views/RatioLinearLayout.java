package com.yue.maxwell.androidview.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.yue.maxwell.androidview.R;

/**
 * 2016/10/2 0002，由 Administrator 创建 .
 * <p>
 * 功能描述：
 * <p>
 * 说明：
 * ---------------------------
 * 修改时间：
 * 修改说明：
 * 修改人：
 */

public class RatioLinearLayout extends LinearLayout {

    private static final float DEFAULT_RATIO = 1;//默认宽高比

    private float ratio;

    public RatioLinearLayout(Context context) {
        this(context, null);
    }

    public RatioLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RatioLinearLayout);
        ratio = ta.getFloat(R.styleable.RatioLinearLayout_ratio, DEFAULT_RATIO);
        ta.recycle();
    }

    public void setRatio(float ratio){
        this.ratio = ratio;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        widthSize = widthSize - getPaddingLeft() - getPaddingRight();

        // int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        widthSize = widthSize - getPaddingLeft() - getPaddingRight();

        // 宽度是精确值，如果宽高比相反，这里的"*"变为"/"
        heightSize = (int) (widthSize / ratio + 0.5f);

        widthSize = widthSize + getPaddingLeft() + getPaddingRight();
        heightSize = heightSize + getPaddingTop() + getPaddingBottom();

        widthMeasureSpec = MeasureSpec.makeMeasureSpec(widthSize,
                MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize,
                MeasureSpec.EXACTLY);

        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

}
