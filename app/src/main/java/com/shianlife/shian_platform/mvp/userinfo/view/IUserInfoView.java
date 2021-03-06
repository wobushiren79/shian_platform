package com.shianlife.shian_platform.mvp.userinfo.view;

import android.content.Context;

/**
 * Created by zm.
 */

public interface IUserInfoView {
    Context getContext();

    void ChangeHeadImage(String imageUrl);

    void ChangeName(String name);

    void ChangePhone(String phone);

    void ChangePoint(String point);

    void ChangeOrderNum(String num);
}
