package com.yun.usual.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yrz
 */
public class StringUtils {

    public static List<Integer> stringToArray(String str){

        String[] imgList = String.valueOf(str).split(",");

        List<Integer> b = new ArrayList<>();
        for (String s : imgList) {
            b.add(Integer.valueOf(s));
        }

        return b;
    }

}
