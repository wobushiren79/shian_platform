package com.shianlife.shian_platform.custom.show;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseLayout;
import com.shianlife.shian_platform.custom.view.fileupload.FileUpLoadButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by zm.
 */

public class ImageUpLoadShowLayout extends BaseLayout implements ILayoutDataView {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ll_content)
    LinearLayout llContent;

    public List<FileUpLoadButton> listFiles;

    private String fileClass;
    private String fileName;

    public ImageUpLoadShowLayout(Context context) {
        this(context, null);
    }

    public ImageUpLoadShowLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, R.layout.layout_show_imageupload, attrs);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        setTitle(titleName);
        listFiles = new ArrayList<>();
        fileClass = "unknown";
    }

    public void setBaseData(String fileClass) {
        this.fileClass = fileClass;
        addView();
    }


    private void addView() {
        FileUpLoadButton button = new FileUpLoadButton(getContext(), fileClass, fileClass);
        button.setCallBack(itemCallBack);
        listFiles.add(button);
        llContent.addView(button);
    }

    FileUpLoadButton.CallBack itemCallBack = new FileUpLoadButton.CallBack() {
        @Override
        public void fileUpLoadSuccess(View view) {
            //判斷是否已经有一个待添加按钮
            boolean isHasAdd = false;
            for (FileUpLoadButton item : listFiles) {
                if (item.getFilePath() == null) {
                    isHasAdd = true;
                }
            }
            if (!isHasAdd)
                addView();
        }

        @Override
        public void fileUpLoadFail(View view) {

        }

        @Override
        public void fileDelete(View view) {
            listFiles.remove(view);
            llContent.removeView(view);
        }
    };

    /**
     * 获取数据
     * @return
     */
    public List<String> getData() {
        List<String> data = new ArrayList<>();
        for (FileUpLoadButton item : listFiles) {
            if (item.getFileUrl() != null && !item.getFileUrl().isEmpty()) {
                data.add(item.getFileUrl());
            }
        }
        return data;
    }

    @Override
    public void setTitle(String name) {
        tvTitle.setText(name);
    }

    @Override
    public void setContent(String content) {

    }

    @Override
    public void setContentBold() {

    }

    @Override
    public void setState(int state) {

    }


}
