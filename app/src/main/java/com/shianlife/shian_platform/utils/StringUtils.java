package com.shianlife.shian_platform.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zm.
 */

public class StringUtils {
    public static List<String> getSplitList(String data, String split) {
        List<String> listData = new ArrayList<>();
        if (data != null && data.length() != 0 && split != null) {
            String[] list = data.split(split);
            if (list != null)
                listData = Arrays.asList(list);
        }
        return listData;
    }
}
