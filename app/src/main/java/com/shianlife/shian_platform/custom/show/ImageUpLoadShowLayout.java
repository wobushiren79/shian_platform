package com.shianlife.shian_platform.custom.show;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
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

        FileUpLoadButton item = new FileUpLoadButton(getContext(), "testClass", "testName");
        llContent.addView(item);
        listFiles = new ArrayList<>();
        listFiles.add(item);
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
