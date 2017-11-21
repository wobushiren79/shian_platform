package com.shianlife.shian_platform.custom.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseDialog;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.custom.show.EditTextShowLayout;
import com.shianlife.shian_platform.custom.show.ImageUpLoadShowLayout;
import com.shianlife.shian_platform.mvp.driver.bean.BaseDriverOrderResultItemBean;
import com.shianlife.shian_platform.mvp.driver.bean.ServiceOngoingResultBean;
import com.shianlife.shian_platform.mvp.driver.presenter.IServiceOngoingPresenter;
import com.shianlife.shian_platform.mvp.driver.presenter.impl.ServiceOngoingPresenterImpl;
import com.shianlife.shian_platform.mvp.driver.view.IServiceOngoingView;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.List;

/**
 * Created by zm.
 */

public class DriverOrderDataDialog extends BaseDialog implements IServiceOngoingView {

    EditTextShowLayout showNowcarlocation;
    EditTextShowLayout showNowmileageText;
    ImageUpLoadShowLayout showNowmileagePic;

    String locationText;
    String mileageText;
    String photoText;

    private int styleType = -1;
    private CallBack callBack;
    private BaseDriverOrderResultItemBean data;
    private IServiceOngoingPresenter serviceOngoingPresenter;
    //没有图片的布局
    public final static int STYLE_NOPIC = 1;
    //有图片的布局
    public final static int STYLE_PIC = 2;
    //fileClass
    public final static String FILECLASS = "order/driver";

    public DriverOrderDataDialog(Context context, int styleType, BaseDriverOrderResultItemBean data) {
        super(context);
        serviceOngoingPresenter = new ServiceOngoingPresenterImpl(this);
        this.styleType = styleType;
        this.data = data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewItem = LayoutInflater.from(getContext()).inflate(R.layout.dialog_driverorderdata, null);
        init();
        setView(mViewItem);
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public void setLocationText(String locationText) {
        this.locationText = locationText;
    }

    public void setMileageText(String mileageText) {
        this.mileageText = mileageText;
    }

    public void setPhoteText(String photoText) {
        this.photoText = photoText;
    }

    /**
     * 初始化
     */
    private void init() {
        showNowcarlocation = (EditTextShowLayout) mViewItem.findViewById(R.id.show_nowcarlocation);
        showNowmileageText = (EditTextShowLayout) mViewItem.findViewById(R.id.show_nowmileage_text);
        showNowmileagePic = (ImageUpLoadShowLayout) mViewItem.findViewById(R.id.show_nowmileage_pic);

        showNowcarlocation.setTitle(locationText);
        showNowmileageText.setTitle(mileageText);
        showNowmileagePic.setTitle(photoText);
        showNowmileageText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        showNowcarlocation.setUncheck(false);
        showNowcarlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocation();
            }
        });
        showNowcarlocation.setCallBack(new EditTextShowLayout.CallBack() {
            @Override
            public void clickMap() {
                setLocation();
            }

            @Override
            public void clickContent() {
                setLocation();
            }
        });
        showNowmileagePic.setBaseData(FILECLASS);
        if (styleType == STYLE_NOPIC) {
            showNowmileagePic.setVisibility(View.GONE);
        } else if (styleType == STYLE_PIC) {
            showNowmileagePic.setVisibility(View.VISIBLE);
        }

        setLocation();
    }

    private void setLocation() {
        if (Constants.LOCAL_ADDRESS.isEmpty()) {
            ToastUtils.showToastShort(getContext(), getContext().getString(R.string.bug_text_2));
            return;
        }
        showNowcarlocation.setContent(Constants.LOCAL_ADDRESS);
    }


    @Override
    public void show() {
        super.show();
        setLayout();
        setButton();
    }

    private void setButton() {
        setTopButton(getContext().getString(R.string.dialog_false_3), new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        setBottomButton(getContext().getString(R.string.dialog_true_3), new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                serviceOngoingPresenter.saveServiceOngoing();
            }
        });
    }

    private void setLayout() {
        outMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = (int) (outMetrics.widthPixels * 0.96);
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER;
        getWindow().setAttributes(params);
    }

    @Override
    public void saveServiceOngoingSuccess(ServiceOngoingResultBean result) {
        if (callBack != null)
            callBack.getDataSuccess(result);
        ToastUtils.showToastShort(getContext(), getContext().getString(R.string.driver_order_serviceonoing_success));
        this.cancel();
    }

    @Override
    public void saveServiceOngoingFail(String msg) {
        if (callBack != null)
            callBack.getDataFail(msg);
        ToastUtils.showToastShort(getContext(), getContext().getString(R.string.driver_order_serviceonoing_fail));

    }

    @Override
    public Long getOrderId() {
        return data.getOrderId();
    }

    @Override
    public String getLongitude() {
        return Constants.LOCAL_longitude + "";
    }

    @Override
    public String getLatitude() {
        return Constants.LOCAL_latitude + "";
    }

    @Override
    public String getAddress() {
        return Constants.LOCAL_ADDRESS;
    }

    @Override
    public String getFiles() {
        return showNowmileagePic.getDataString();
    }

    @Override
    public String getKM() {
        return showNowmileageText.getData();
    }

    @Override
    public int getServiceStep() {
        return data.getOrderState();
    }

    @Override
    public int getLayoutType() {
        return styleType;
    }

    public interface CallBack {
        void getDataSuccess(ServiceOngoingResultBean result);

        void getDataFail(String msg);
    }
}
