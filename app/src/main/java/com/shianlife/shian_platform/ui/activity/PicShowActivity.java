package com.shianlife.shian_platform.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.custom.view.carousel.CarouselView;
import com.shianlife.shian_platform.utils.IntentUtils;

import java.util.ArrayList;

import butterknife.BindView;

public class PicShowActivity extends BaseActivity {

    @BindView(R.id.layout_carouse)
    CarouselView layoutCarouse;

    private ArrayList<String> listData = new ArrayList<>();
    private String titleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_show);
        initView();
        initData();
    }

    protected void initView() {

    }

    protected void initData() {
        listData = (ArrayList<String>) getIntent().getSerializableExtra(IntentUtils.INTENT_LIST_DATA);
        titleName = getIntent().getStringExtra(IntentUtils.INTENT_DATA);
        if (!titleName.isEmpty())
            setTitle(titleName, BaseTitleEnum.BACKNORMALTITLE.getTitleType());
        else
            setTitle("图片", BaseTitleEnum.BACKNORMALTITLE.getTitleType());
        layoutCarouse.setData(listData);
    }
}
