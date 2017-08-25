package com.shianlife.shian_platform.mvp.base;

import android.content.Context;

/**
 * Created by zm.
 */

public interface BaseMVPView {
    Context getContext();

    void showToast(String msg);
}
