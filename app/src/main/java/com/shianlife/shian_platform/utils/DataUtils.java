package com.shianlife.shian_platform.utils;



import com.shianlife.shian_platform.mvp.order.bean.GoodsItemPerform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by zm.
 */

public class DataUtils {
    /**
     * 将list<GoodsItemPerform> 转换为map形式  条件为分类名称
     *
     * @param goodsItemPerforms
     * @return
     */
    public static Map<String, List<GoodsItemPerform>> getMapForGoodsItemPerform(List<GoodsItemPerform> goodsItemPerforms) {
        Map<String, List<GoodsItemPerform>> goodsListData = new HashMap<>();
        try {
            List<String> classList = new LinkedList<>();
            for (GoodsItemPerform item : goodsItemPerforms) {
                classList.add(item.getSpecOrderedAttr());
            }
            List<String> newClassList = new ArrayList(new HashSet(classList));
            for (String className : newClassList) {
                List<GoodsItemPerform> listItemData = new ArrayList<>();
                for (GoodsItemPerform item : goodsItemPerforms) {
                    if (item.getSpecOrderedAttr().equals(className)) {
                        listItemData.add(item);
                    }
                }
                goodsListData.put(className, listItemData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsListData;
    }


}
