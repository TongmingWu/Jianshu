package com.tongming.jianshu.util;

import java.util.List;

/**
 * Created by Tongming on 2016/5/21.
 */
public class URLUtil {
    //    public static String SERVER = "http://192.168.191.1:5000/";
//    public static String SERVER = "http://10.12.243.252:5000/";
    public static String SERVER = "http://45.78.25.201/";
    //获取其他类别的文章
    public static String CATEGORY = SERVER + "article/";
    //获取首页热门的文章
    public static String HOT = SERVER + "hot";
    //获取七日热门的文章
    public static String WEEKLY = SERVER + "weekly";
    //获取三十日热门的文章
    public static String MONTHLY = SERVER + "monthly";
    //获取2015年每月一篇好文章
    public static String ZODIAC = SERVER + "zodiac";
    //获取文章详情
    public static String DETAIL = SERVER + "detail/";
    //获取文章的评论
    public static String COMMENT = SERVER + "comment/";
    //加载更多文章
    public static String MORE = SERVER + "more/hot/";
    //获取专题信息
    public static String COLLECTION = SERVER + "collections/";
    //获取专题详细信息
    public static String COLLECTION_DETAIL = SERVER + "collection/";

    public static String getMore(List<String> list, String page) {
        for (int i = 0; i < list.size(); i++) {
            MORE += "note_ids%5B%5D=" + list.get(i) + "&";
        }
        return MORE + "page=" + page;
    }

    public static String LOAD_NORMAL = SERVER + "more/normal/";

    //搜索
    public static String SEARCH = SERVER + "search/";

    //用户信息
    public static String getUserLatest(String slug) {
        return SERVER + "users/" + slug + "/latest_articles";
    }

    public static String getUserTop(String slug) {
        return SERVER + "users/" + slug + "/top_articles";
    }

    public static String getUserTimeline(String slug) {
        return SERVER + "users/" + slug + "/timeline";
    }

}
