package com.huige.library.widget.likeview;

import android.animation.TypeEvaluator;

/**
 * 颜色渐变动画
 * Created by lzh on 2017/8/1.
 */

public class ArgbEvaluator implements TypeEvaluator{
    private static ArgbEvaluator mArgbEvaluator = null;

    public static ArgbEvaluator getInstance(){
        if(mArgbEvaluator == null){
            synchronized(ArgbEvaluator.class){
                if(mArgbEvaluator == null){
                    mArgbEvaluator = new ArgbEvaluator();
                }
            }
        }
        return mArgbEvaluator;
    }

    public Object evaluate(float fraction, Object startValue, Object endValue) {
        int startInt = (Integer) startValue;
        int startA = (startInt >> 24) & 0xff;
        int startR = (startInt >> 16) & 0xff;
        int startG = (startInt >> 8) & 0xff;
        int startB = startInt & 0xff;

        int endInt = (Integer) endValue;
        int endA = (endInt >> 24) & 0xff;
        int endR = (endInt >> 16) & 0xff;
        int endG = (endInt >> 8) & 0xff;
        int endB = endInt & 0xff;

        return (int)((startA + (int)(fraction * (endA - startA))) << 24) |
                (int)((startR + (int)(fraction * (endR - startR))) << 16) |
                (int)((startG + (int)(fraction * (endG - startG))) << 8) |
                (int)((startB + (int)(fraction * (endB - startB))));
    }
}
