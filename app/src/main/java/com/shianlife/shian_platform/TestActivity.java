package com.shianlife.shian_platform;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.shianlife.shian_platform.base.BaseActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.builder.PostStringBuilder;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.request.RequestCall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Response;

public class TestActivity extends BaseActivity {


    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.bt_other)
    Button btOther;
    @BindView(R.id.bt_other1)
    Button btOther1;

    private String tempCookie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);


    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.bt_login, R.id.bt_other, R.id.bt_other1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                login();
                break;
            case R.id.bt_other:
                other();
                break;
            case R.id.bt_other1:
                other1();
                break;
        }
    }


    private void login() {



        final PostStringBuilder getBuilder = OkHttpUtils.postString();

        getBuilder.url("http://192.168.0.35:8199/ki4so-web/applogin");
//        if (header != null)
//            getBuilder.headers(header);
        getBuilder.mediaType(MediaType.parse("application/json; charset=utf-8"));
        getBuilder.content("\n" +
                "{\"content\":{\n" +
                "\"userName\":\"test\",\n" +
                "\"userPwd\":\"1\"\n" +
                "}}");

        final RequestCall requestCall = getBuilder.build();
        requestCall.execute(new Callback() {
            @Override
            public Object parseNetworkResponse(Response response, int id) throws Exception {
                List<String> cookie = response.headers("Set-Cookie");
                StringBuffer stringBuffer = new StringBuffer();
                for (String itemCookie : cookie) {
                    stringBuffer.append(itemCookie);
                }

                tempCookie = stringBuffer.toString();
                return null;
            }

            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(Object response, int id) {
                Object obj = response;
            }
        });

    }

    private void other() {

        final PostFormBuilder getBuilder = OkHttpUtils.post();
        getBuilder.url("http://192.168.0.35:8299/goods/demo/A");
        final RequestCall requestCall = getBuilder.build();
        requestCall.execute(new Callback() {
            @Override
            public Object parseNetworkResponse(Response response, int id) throws Exception {
                Response response1 = response;
                return null;
            }

            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(Object response, int id) {
                Object obj = response;
            }
        });
    }

    private void other1() {


        final PostFormBuilder getBuilder = OkHttpUtils.post();
        getBuilder.url("http://192.168.0.35:8299/goods/demo/B");
        final RequestCall requestCall = getBuilder.build();
        requestCall.execute(new Callback() {
            @Override
            public Object parseNetworkResponse(Response response, int id) throws Exception {
                Response response2 = response;
                return null;
            }

            @Override
            public void onError(Call call, Exception e, int id) {

            }

            @Override
            public void onResponse(Object response, int id) {
                Object obj = response;
            }
        });
    }
}
