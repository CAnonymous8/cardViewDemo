package com.neil.as.notificationmodeltext;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

/**
 * Created by As on 2017/5/20.
 */

public class NotificationAnimatorUtils {

    /**
     *
     * @param startIv 放大动画imageview
     * @param scaleIv 缩小动画imageview
     */
    public static void startAnimator(ImageView startIv,ImageView scaleIv){
        ObjectAnimator startScaleX = ObjectAnimator.ofFloat(startIv, "scaleX", 1.0f, 1.6f);
        ObjectAnimator startScaleY = ObjectAnimator.ofFloat(startIv, "scaleY", 1.0f, 1.6f);

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(scaleIv, "scaleX", 1.6f, 1.0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(scaleIv, "scaleY", 1.6f, 1.0f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.playTogether(startScaleX,startScaleY,scaleX,scaleY);

        animatorSet.start();

    }

}
