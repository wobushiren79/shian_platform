package com.shianlife.shian_platform.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

/**
 * Created by zm.
 */

public class AnimUtils {
    public static void startScaleToSelf(View view, int duration, float fromX, float toX, float fromY, float toY, Animation.AnimationListener animationListener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation
                (fromX, toX, fromY, toY,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(duration);
        scaleAnimation.setAnimationListener(animationListener);
        view.startAnimation(scaleAnimation);
    }


    public static void startRotateToSelf(View view, int duration, int fromDegrees, int toDegrees, Animation.AnimationListener animationListener) {
        RotateAnimation rotateAnimation = new RotateAnimation
                (fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(duration);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setAnimationListener(animationListener);
        view.startAnimation(rotateAnimation);
    }
}
