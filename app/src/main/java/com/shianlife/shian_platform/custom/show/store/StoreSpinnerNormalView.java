package com.shianlife.shian_platform.custom.show.store;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.base.BaseLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zm.
 */

public class StoreSpinnerNormalView extends BaseLayout implements AdapterView.OnItemSelectedListener {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.sp_content)
    Spinner spContent;
    @BindView(R.id.tv_check)
    TextView tvCheck;

    private String[] data;

    public StoreSpinnerNormalView(Context context) {
        super(context, R.layout.layout_store_spinner_normal_view);
    }

    public StoreSpinnerNormalView(Context context, @Nullable AttributeSet attrs) {
        super(context, R.layout.layout_store_spinner_normal_view, attrs);
    }

    @Override
    protected void initView() {
        tvTitle.setText(titleName);
    }

    @Override
    protected void initData() {

    }

    public void initSpinner(int arrayId) {
        data = getContext().getResources().getStringArray(arrayId);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spContent.setAdapter(adapter);
        spContent.setOnItemSelectedListener(this);
    }

    public String getData() {
        return data[spContent.getSelectedItemPosition()];
    }

    @OnClick(R.id.tv_check)
    public void onViewClicked() {
        spContent.performClick();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
