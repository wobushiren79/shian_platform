package com.shianlife.shian_platform.custom.view.fileupload;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.base.BaseLayout;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.mvp.fileup.bean.FileUpLoadBean;
import com.shianlife.shian_platform.mvp.fileup.bean.FileUpLoadResultBean;
import com.shianlife.shian_platform.mvp.fileup.presenter.IFileUpLoadPresenter;
import com.shianlife.shian_platform.mvp.fileup.presenter.impl.FileUpLoadPresenterImpl;
import com.shianlife.shian_platform.mvp.fileup.view.IFileUpLoadView;
import com.shianlife.shian_platform.ui.activity.ImagePreviewActivity;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.CheckUtils;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Created by zm.
 */

public class FileUpLoadButton extends BaseLayout implements IFileUpLoadView {

    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.pb_loading)
    ProgressBar pbLoading;


    private IFileUpLoadPresenter fileUpLoadPresenter;
    private FileUpLoadBean mFileData;
    private boolean isLoading = false;

    public FileUpLoadButton(Context context, String fileClass, String fileName) {
        super(context, R.layout.view_fileupload_button_normal);
        mFileData = new FileUpLoadBean();
        mFileData.setFileClass(fileClass);
        mFileData.setFileName(fileName);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        fileUpLoadPresenter = new FileUpLoadPresenterImpl(this);

    }

    @Override
    public String getFileClass() {
        return mFileData.getFileClass();
    }

    @Override
    public String getFileName() {
        return mFileData.getFileName();
    }

    @Override
    public String getFilePath() {
        return mFileData.getFilePath();
    }

    @Override
    public void fileUpLoadSuccess(FileUpLoadResultBean result) {
        isLoading = false;
        pbLoading.setVisibility(GONE);
        mFileData.setFilePath((String) result.getNameMap().get(mFileData.getFileClass()));
    }

    @Override
    public void fileUpLoadFail(String msg) {
        isLoading = false;
        pbLoading.setVisibility(GONE);
        mFileData.setFilePath(null);
        ivAdd.setImageResource(R.drawable.zhy_fileupload_button_normal);
        ToastUtils.showToastShort(getContext(), msg);
    }

    @Override
    public void fileUpLoadProgress(long total, float progress) {

    }

    @OnClick(R.id.iv_add)
    public void onViewClicked() {
        if (!isLoading) {
            if (mFileData.getFilePath() != null && !mFileData.getFilePath().isEmpty()) {
                checkDetails();
            } else {
                getAndUpPhoto();
            }
        }
    }


    @OnLongClick(R.id.iv_add)
    public boolean onViewLongClicked() {
        if (!isLoading) {
            if (mFileData.getFilePath() != null && !mFileData.getFilePath().isEmpty()) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setItems(new String[]{getContext().getString(R.string.fileupload_change), getContext().getString(R.string.fileupload_delete)}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        if (which == 0) {
                            getAndUpPhoto();
                        } else {
                            mFileData.setFilePath(null);
                            ivAdd.setImageResource(R.drawable.zhy_fileupload_button_normal);
                        }
                    }
                });
                dialog.show();
            }
        }
        return true;
    }

    /**
     * 查看圖片詳情
     */
    private void checkDetails() {
        new IntentUtils
                .Build(getContext(), ImagePreviewActivity.class)
                .setString(IntentUtils.INTENT_URL, Constants.QINIUURL + mFileData.getFilePath())
                .start();
    }

    /**
     * 獲取並且上傳照片
     */
    private void getAndUpPhoto() {
        CheckUtils.scanForActivity(getContext()).getPhoto(getContext());
        CheckUtils.scanForActivity(getContext()).setOnPhotoPickerListener(new BaseActivity.OnPhotoPickerListener() {
            @Override
            public void onPhoto(ArrayList<String> paths) {
                pbLoading.setVisibility(VISIBLE);
                mFileData.setFilePath(paths.get(0));
                AppUtils.loadPic(getContext(), ivAdd, "file://" + mFileData.getFilePath());
                isLoading = true;
                fileUpLoadPresenter.fileUpLoad();
            }
        });
    }


}
