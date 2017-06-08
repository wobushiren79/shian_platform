package com.shianlife.shian_platform.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.shianlife.shian_platform.R;
import com.shianlife.shian_platform.appenum.BaseTitleEnum;
import com.shianlife.shian_platform.base.BaseActivity;
import com.shianlife.shian_platform.common.Constants;
import com.shianlife.shian_platform.custom.dialog.CustomDialog;
import com.shianlife.shian_platform.custom.dialog.TipsDialog;
import com.shianlife.shian_platform.utils.AppUtils;
import com.shianlife.shian_platform.utils.IntentUtils;
import com.shianlife.shian_platform.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MapFindLocationActivity extends BaseActivity implements BaiduMap.OnMarkerClickListener, OnGetPoiSearchResultListener {
    @BindView(R.id.map_view)
    MapView mMapView;

    private BaiduMap mBaiduMap;
    private PoiSearch poiSearch;

    private String searchLocation;
    private List<Overlay> listMark;
    private LatLng myLocation;
    private CustomDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_find_location);
        //初始化地图
        initMap();
    }

    @Override
    protected void initView() {
        setTitle(getString(R.string.title_name_drvier_findlocation), BaseTitleEnum.BACKNORMALTITLE.getTitleType());
        mBaiduMap = mMapView.getMap();
    }

    @Override
    protected void initData() {
        listMark = new ArrayList<>();
        searchLocation = getIntent().getStringExtra(IntentUtils.INTENT_LOCATION);
    }


    private void initMap() {
        //去掉百度图标
        View child = mMapView.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)) {
            child.setVisibility(View.INVISIBLE);
        }
        //設置中心點
        setCenter(Constants.LOCAL_latitude, Constants.LOCAL_longitude);
        //初始化搜索
        poiSearch = PoiSearch.newInstance();
        poiSearch.setOnGetPoiSearchResultListener(this);

        //构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.drawable.zhy_map_point_2);
        //构建MarkerOption，用于在地图上添加Marker
        myLocation = new LatLng(Constants.LOCAL_latitude, Constants.LOCAL_longitude);
        OverlayOptions option = new MarkerOptions()
                .position(myLocation)
                .icon(bitmap);
        //在地图上添加Marker，并显示
        mBaiduMap.setOnMarkerClickListener(this);
        listMark.add(mBaiduMap.addOverlay(option));

        poiSearch.searchInCity((new PoiCitySearchOption())
                .city(Constants.LOCAL_CITY)
                .keyword(searchLocation));

        dialog = new CustomDialog(this);
        dialog.show();
    }

    private void setCenter(double latitude, double longitude) {
        //设定中心点坐标
        LatLng cenpt = new LatLng(latitude, longitude);
        //定义地图状态
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(cenpt)
                .zoom(18)
                .build();
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        //改变地图状态
        mBaiduMap.setMapStatus(mMapStatusUpdate);
    }

    @Override
    public void onGetPoiResult(PoiResult poiResult) {
        if (dialog != null)
            dialog.cancel();
        //获取POI检索结果
        List<PoiInfo> poiInfos = poiResult.getAllPoi();
        if (poiInfos != null) {
            for (PoiInfo poiInfo : poiInfos) {
                LatLng point = poiInfo.location;
                //构建Marker图标
                BitmapDescriptor bitmap = BitmapDescriptorFactory
                        .fromResource(R.drawable.zhy_map_point_1);
                //构建MarkerOption，用于在地图上添加Marker
                OverlayOptions option = new MarkerOptions()
                        .position(point)
                        .icon(bitmap);
                //在地图上添加Marker，并显示
                listMark.add(mBaiduMap.addOverlay(option));

            }
            zoomToSpan(listMark);
//            setCenter(poiInfos.get(0).location.latitude, poiInfos.get(0).location.longitude);
        } else {
            Toast.makeText(MapFindLocationActivity.this, "沒有找到位置", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {

    }

    @Override
    public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {

    }

    /**
     * mark点击事件
     *
     * @param marker
     * @return
     */
    @Override
    public boolean onMarkerClick(final Marker marker) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setItems(new String[]{getString(R.string.map_select_1)}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                if (which == 0) {
                    AppUtils.intentOtherMap(MapFindLocationActivity.this, myLocation, marker.getPosition(),Constants.LOCAL_ADDRESS,searchLocation);
                }
            }
        });
        dialog.show();
//        //生成一个TextView用户在地图中显示InfoWindow
//        TextView location = new TextView(this);
//        location.setBackgroundResource(R.color.app_bg);
//        location.setPadding(30, 20, 30, 50);
//        location.setText("test");
//        //将marker所在的经纬度的信息转化成屏幕上的坐标
//        final LatLng ll = marker.getPosition();
//        Point p = mBaiduMap.getProjection().toScreenLocation(ll);
//        p.y -= 50;
//        LatLng llInfo = mBaiduMap.getProjection().fromScreenLocation(p);
//        //为弹出的InfoWindow添加点击事件
//        InfoWindow mInfoWindow = new InfoWindow(location, llInfo, 1);
//        //显示InfoWindow
//        mBaiduMap.showInfoWindow(mInfoWindow);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        poiSearch.destroy();
        if (dialog != null)
            dialog.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
        if (dialog != null)
            dialog.cancel();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
        if (dialog != null)
            dialog.cancel();
    }

    /**
     * 缩放地图，使所有Overlay都在合适的视野内
     * <p>
     * 注： 该方法只对Marker类型的overlay有效
     * </p>
     */
    public void zoomToSpan(List<Overlay> mOverlayList) {
        if (mBaiduMap == null) {
            return;
        }
        if (mOverlayList.size() > 0) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Overlay overlay : mOverlayList) {
                // polyline 中的点可能太多，只按marker 缩放
                if (overlay instanceof Marker) {
                    builder.include(((Marker) overlay).getPosition());
                }
            }
            mBaiduMap.setMapStatus(MapStatusUpdateFactory
                    .newLatLngBounds(builder.build()));
        }
    }
}
