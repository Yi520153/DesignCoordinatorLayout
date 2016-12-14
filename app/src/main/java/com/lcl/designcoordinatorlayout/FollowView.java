package com.lcl.designcoordinatorlayout;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lcl on 2016/12/12.
 */

public class FollowView extends View {

    private Context context;
    private int x;
    private int y;
    private int lastX;
    private int lastY;
    private int width;
    private int heigh;


    public FollowView(Context context) {
        super(context);
        init(context);
    }

    public FollowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FollowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        this.context=context;
        //获取屏幕宽高
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        width = display.widthPixels;
        heigh = display.heightPixels;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int) event.getRawX();
        y = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) getLayoutParams();

                //在上次的基础上偏移
                int left = layoutParams.leftMargin + x - lastX;
                int top = layoutParams.topMargin + y - lastY;

                layoutParams.leftMargin = left;
                layoutParams.topMargin = top;
                setLayoutParams(layoutParams);

                //重新设置位置
                requestLayout();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        lastX=x;
        lastY=y;
        return true;
    }
}
