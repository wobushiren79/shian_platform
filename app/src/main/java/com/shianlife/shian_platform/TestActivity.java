package com.shianlife.shian_platform;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.custom.view.ptr.CustomPtrFramelayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class TestActivity extends BaseActivity {

    @BindView(R.id.listview)
    ListView listview;
    @BindView(R.id.ll_content)
    RelativeLayout llContent;
    @BindView(R.id.ptr)
    CustomPtrFramelayout ptr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);


    }

    @Override
    protected void initView() {
        ptr.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                try {
                    Thread.sleep(1000);
                    ptr.refreshComplete();
                } catch (InterruptedException e) {


                }
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                try {
                    Thread.sleep(1000);
                    ptr.refreshComplete();
                } catch (InterruptedException e) {


                }
            }
        });
    }

    @Override
    protected void initData() {
        listview.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 100;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = new TextView(TestActivity.this);
                textView.setText(position + "");
                return textView;
            }
        });
    }
}
