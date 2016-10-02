package com.yue.maxwell.androidview.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.yue.maxwell.androidview.R;

/**
 * 作者：maxwellyue
 * 说明：
 * （1）ratio = 宽度：长度 ；
 * （2）使用时，设定宽度即可，高度任意。
 * （3）代码中调用setRadio会覆盖xml中定义的比例，以setRadio为准。
 *
 *
 */
public class RatioImageView extends ImageView {

    private static final float DEFAULT_RATIO = 1;//默认宽高比

    private float ratio;
    public RatioImageView(Context context) {
        this(context, null);
    }

    public RatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RatioImageView);
        ratio = ta.getFloat(R.styleable.RatioImageView_ratio, DEFAULT_RATIO);
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

        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);//两者等价
    }
}
