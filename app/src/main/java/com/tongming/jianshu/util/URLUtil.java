package com.tongming.jianshu.util;

/**
 * Created by Tongming on 2016/5/21.
 */
public class URLUtil {
    public static String SERVER = "http://192.168.191.1:5000/";
//    public static String SERVER = "http://10.12.243.252:5000/";
    //获取其他类别的文章
    public static String CATEGORY = SERVER+"article/";
    //获取首页热门的文章
    public static String HOT = SERVER+"hot";
    //获取七日热门的文章
    public static String WEEKLY = SERVER+"weekly";
    //获取三十日热门的文章
    public static String MONTHLY = SERVER+"monthly";
    //获取2015年每月一篇好文章
    public static String ZODIAC = SERVER+"zodiac";
    //获取文章详情
    public static String DETAIL = SERVER+"detail/";
    //获取文章的评论
    public static String COMMENT = SERVER+"comment/";
}
