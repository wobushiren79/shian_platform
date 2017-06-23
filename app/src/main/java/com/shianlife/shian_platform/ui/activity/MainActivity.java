package com.shianlife.shian_platform.ui.activity;


import android.content.Context;
import android.os.Bundle;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import com.baidu.android.pushservice.CustomPushNotificationBuilder;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.appenum.MainChangeItemEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.base.BaseApplication;
import com.shianlife.shian_platform.base.BaseFragment;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.common.local.LocationService;
import com.shianlife.shian_platform.custom.view.mainchange.MainChangeLayout;
import com.shianlife.shian_platform.http.base.BaseDataResult;
import com.shianlife.shian_platform.mvp.main.bean.AppUpDateResultBean;
import com.shianlife.shian_platform.mvp.main.presenter.IAppUpDatePresenter;
import com.shianlife.shian_platform.mvp.main.presenter.IChangeItemPresenter;
import com.shianlife.shian_platform.mvp.main.presenter.impl.AppUpDatePresenterImpl;
import com.shianlife.shian_platform.mvp.main.presenter.impl.ChangeItemPresenterImpl;
import com.shianlife.shian_platform.mvp.main.view.IAppUpDateView;
import com.shianlife.shian_platform.mvp.main.view.IChangeItemView;
import com.shianlife.shian_platform.ui.fragment.DriverOrderFragment;
import com.shianlife.shian_platform.ui.fragment.FindFragment;
import com.shianlife.shian_platform.ui.fragment.HomeFragment;
import com.shianlife.shian_platform.ui.fragment.MyFragment;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.CheckUtils;
import com.shianlife.shian_platform.utils.PushUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements IChangeItemView, IAppUpDateView {
    @BindView(R.id.fl_fragment)
    FrameLayout flFragment;
    @BindView(R.id.main_change_layout)
    MainChangeLayout mainChangeLayout;

    private IChangeItemPresenter changeItemPresenter;
    private IAppUpDatePresenter appUpDatePresenter;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mTranscation;
    private long firstTime = 0;

    private LocationService locationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        mainChangeLayout.setChangeCallBack(mainChangeCallBack);
    }

    MainChangeLayout.MainChangeCallBack mainChangeCallBack = new MainChangeLayout.MainChangeCallBack() {
        @Override
        public void onClick(int itemId) {
            BaseFragment baseFragment = null;
            if (itemId == MainChangeItemEnum.DIRVERORDER.getItemId()) {
                baseFragment = new DriverOrderFragment();
                setTitle(MainChangeItemEnum.DIRVERORDER.getTitle(), BaseTitleEnum.NORMALTITLE.getTitleType());
            } else if (itemId == MainChangeItemEnum.FIND.getItemId()) {
                baseFragment = new FindFragment();
                setTitle(MainChangeItemEnum.FIND.getTitle(), BaseTitleEnum.NORMALTITLE.getTitleType());
            } else if (itemId == MainChangeItemEnum.MAIN.getItemId()) {
                baseFragment = new HomeFragment();
                setTitle(MainChangeItemEnum.MAIN.getTitle(), BaseTitleEnum.NORMALTITLE.getTitleType());
            } else if (itemId == MainChangeItemEnum.MY.getItemId()) {
                baseFragment = new MyFragment();
                setTitle(MainChangeItemEnum.MY.getTitle(), BaseTitleEnum.NORMALTITLE.getTitleType());
            }
            changeContent(baseFragment);
        }
    };


    @Override
    protected void initData() {
        mFragmentManager = getSupportFragmentManager();
        changeItemPresenter = new ChangeItemPresenterImpl(this);
        appUpDatePresenter = new AppUpDatePresenterImpl(this);
        changeItemPresenter.setChangeItemData();
        appUpDatePresenter.getAppUpDateInfo();
    }


    @Override
    public void setItemData(List<MainChangeItemEnum> listData) {
        for (int i = 0; i < listData.size(); i++) {
            mainChangeLayout.addMainData(
                    listData.get(i).getTitle(),
                    listData.get(i).getUnCheckIconId(),
                    listData.get(i).getCheckIconId(),
                    listData.get(i).getItemId());
        }
        mainChangeLayout.setState(MainChangeItemEnum.MAIN.getItemId(), true);
    }

    @Override
    public void changeContent(BaseFragment fragment) {
        mTranscation = mFragmentManager.beginTransaction();
        if (fragment == null) {
            fragment = new BaseFragment();
        }
        mTranscation.replace(R.id.fl_fragment, fragment);
        mTranscation.commitAllowingStateLoss();
    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void getAppUpDateInfoSuccess(AppUpDateResultBean result) {
        CheckUtils.checkAppUpDate(this, result, false);
    }


    @Override
    public void getAppUpDateInfoFail(String msg) {

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    //如果两次按键时间间隔大于2秒，则不退出
                    ToastUtils.showToastShort(this, getString(R.string.main_back));
                    firstTime = secondTime;//更新firstTime
                    return true;
                } else {
                    //两次按键小于2秒时，退出应用
                    System.exit(0);
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }


    @Override
    protected void onStart() {
        super.onStart();
        // -----------location config ------------
        locationService = ((BaseApplication) getApplication()).locationService;
        // 获取locationservice实例，建议应用中只初始化1个location实例，然后使用，可以参考其他示例的activity，都是通过此种方式获取locationservice实例的
        locationService.registerListener(mLocationListener);
        // 注册监听
        locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        locationService.start();
        // 定位SDK
        // start之后会默认发起一次定位请求，开发者无须判断isstart并主动调用request
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationService.unregisterListener(mLocationListener); // 注销掉监听
        locationService.stop(); // 停止定位服务
    }

    /**
     * 定位监听
     */
    private BDLocationListener mLocationListener = new BDLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // TODO Auto-generated method stub
            if (null != location && location.getLocType() != BDLocation.TypeServerError) {
                if (location.getAddrStr() == null) return;
                Constants.LocalString = location.getAddrStr();
                Constants.LOCAL_PROVINCE = location.getAddress().province;
                Constants.LOCAL_CITY = location.getAddress().city;
                Constants.LOCAL_COUNTY = location.getAddress().district;
                Constants.LOCAL_STREET = location.getAddress().street;
                Constants.LOCAL_STREETNUM = location.getAddress().streetNumber;
                Constants.LOCAL_ADDRESS = location.getAddress().address;
                Constants.LOCAL_latitude = location.getLatitude();
                Constants.LOCAL_longitude = location.getLongitude();
            }
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }

    };
}
