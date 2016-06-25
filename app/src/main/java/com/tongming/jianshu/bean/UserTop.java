package com.tongming.jianshu.bean;

import java.util.List;

/**
 * Created by Tongming on 2016/6/21.
 */
public class UserTop {


    /**
     * page : 5
     * hot_articles : [{"fav":"436","title":"别骂了，春晚本来就不是拍给你们看的","avatar":null,"img":"http://upload-images.jianshu.io/upload_images/1346541-43b9397c5655a8b3.png?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","date":"2016-02-07 22:22:02","read":"43597","slug":"723367118231","comment":"467","author":"李清浅"},{"fav":"333","title":"优秀的人天生精力充沛？是你天生太懒好么","avatar":null,"img":"http://upload-images.jianshu.io/upload_images/1346541-9335a3ea7ec41183?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","date":"2016-06-20 09:54:36","read":"7266","slug":"c0395fba6b41","comment":"126","author":"李清浅"},{"fav":"308","title":"一年减掉25斤，我是这么做到的","avatar":null,"img":"http://upload-images.jianshu.io/upload_images/1346541-c1ac55496c9453e6?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","date":"2016-02-05 12:34:49","read":"7694","slug":"ad2592c6ae18","comment":"69","author":"李清浅"},{"fav":"264","title":"单身的原因是太挑？你别逗我了","avatar":null,"date":"2016-02-18 11:46:56","read":"11798","slug":"f3493eab6a0f","comment":"176","author":"李清浅","img":null},{"fav":"256","title":"别拿穷当不要脸的借口","avatar":null,"img":"http://upload-images.jianshu.io/upload_images/1346541-d64714e9995b21fb.jpeg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","date":"2016-02-07 14:05:37","read":"7788","slug":"55c5ca248162","comment":"82","author":"李清浅"},{"fav":"207","title":"你想了那么久，为什么还没去做？","avatar":null,"img":"http://upload-images.jianshu.io/upload_images/1346541-7a67e2b65a1fba88?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","date":"2016-01-20 11:03:54","read":"4160","slug":"e8a8bc75e1b4","comment":"28","author":"李清浅"},{"fav":"183","title":"你所谓的辛苦，在别人眼中不过是安逸的代名词","avatar":null,"img":"http://upload-images.jianshu.io/upload_images/1346541-b323d522117814b4.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","date":"2016-03-13 20:09:14","read":"4705","slug":"9da38682aec1","comment":"47","author":"李清浅"},{"fav":"152","title":"你都没有认真付出，有什么资格抱怨命运不公","avatar":null,"img":"http://upload-images.jianshu.io/upload_images/1346541-b5a6cbc234c4ea4c.png?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","date":"2016-02-22 22:24:41","read":"3258","slug":"4eef55a622b0","comment":"41","author":"李清浅"},{"fav":"151","title":"瞧，那个特别努力的死屌丝","avatar":null,"img":"http://upload-images.jianshu.io/upload_images/1346541-ae890a51e8b50678?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","date":"2016-03-12 20:10:08","read":"5431","slug":"c3a778075848","comment":"76","author":"李清浅"}]
     */

    private int page;
    /**
     * fav : 436
     * title : 别骂了，春晚本来就不是拍给你们看的
     * avatar : null
     * img : http://upload-images.jianshu.io/upload_images/1346541-43b9397c5655a8b3.png?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300
     * date : 2016-02-07 22:22:02
     * read : 43597
     * slug : 723367118231
     * comment : 467
     * author : 李清浅
     */

    private List<Article> hot_articles;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Article> getHot_articles() {
        return hot_articles;
    }

    public void setHot_articles(List<Article> hot_articles) {
        this.hot_articles = hot_articles;
    }
}
