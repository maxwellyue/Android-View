package com.yue.maxwell.android_view.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 固定宽度：长度 = ratio的自定义LinearLayout
 * Created by Administrator on 2016/7/12 0012.
 *
 */
public class RatioImageView extends ImageView {
    private float ratio = 1.33333333f;//默认宽高比
    public RatioImageView(Context context) {
        super(context);
    }

    public RatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RatioImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setRatio(float ratio){
        this.ratio = ratio;
        invalidate();
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

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // setMeasuredDimension(measuredWidth, measuredHeight);//两者等价
    }
}
