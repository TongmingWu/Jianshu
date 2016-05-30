package com.tongming.jianshu.bean;

import java.util.List;

/**
 * Created by Tongming on 2016/5/21.
 */
public class ArticleList {


    /**
     * banner : ["http://upload-images.jianshu.io/upload_images/1661508-a8cd574b1de121cb.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/640/h/240","http://upload-images.jianshu.io/upload_images/2053886-599b89cf88048cc0.JPG?imageMogr2/auto-orient/strip%7CimageView2/1/w/640/h/240","http://upload-images.jianshu.io/upload_images/1218896-8f4b9c4f94e74bc2.JPG?imageMogr2/auto-orient/strip%7CimageView2/1/w/640/h/240","http://upload-images.jianshu.io/upload_images/1122063-84283820bf94f14e.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/640/h/240","http://upload-images.jianshu.io/upload_images/1310352-9a6c815699b13335.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/640/h/240"]
     * count : 20
     * results : [{"author":"Sunflower_girl","read":"7348","slug":"f076a5caabc7","title":"大学室友教会我的那些事","fav":"356","img":"http://upload-images.jianshu.io/upload_images/1661508-a8cd574b1de121cb.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"433","avatar":"http://upload.jianshu.io/users/upload_avatars/1661508/7e3074c0cb15.jpg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-28 17:13:05"},{"author":"大肚子猫","read":"2966","slug":"474574d36219","title":"注意10个小细节，做个有教养的人","fav":"144","img":"http://upload-images.jianshu.io/upload_images/2053886-599b89cf88048cc0.JPG?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"26","avatar":"http://upload.jianshu.io/users/upload_avatars/2053886/3c7c0007bb6d.jpg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-28 20:07:44"},{"author":"superpoo好不好玩","read":"4021","slug":"b4d3f5f0a148","title":"该是你的，为什么不去争？","fav":"198","img":"http://upload-images.jianshu.io/upload_images/1218896-8f4b9c4f94e74bc2.JPG?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"55","avatar":"http://upload.jianshu.io/users/upload_avatars/1218896/6aaf992258cf.jpg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-28 11:35:12"},{"author":"枫小梦","read":"2218","slug":"e993baf6157e","title":"书看了就忘？其实是你不够认真","fav":"136","img":"http://upload-images.jianshu.io/upload_images/1122063-84283820bf94f14e.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"25","avatar":"http://upload.jianshu.io/users/upload_avatars/1122063/014a603fb510.jpg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-28 17:28:20"},{"author":"阿春牧羊犬","read":"9622","slug":"9a7a80988b37","title":"找个愿意吃你剩饭的男人","fav":"292","img":"http://upload-images.jianshu.io/upload_images/1310352-9a6c815699b13335.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"280","avatar":"http://upload.jianshu.io/users/upload_avatars/1310352/61c731438355.JPG?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-28 13:23:56"},{"author":"猪小闹","read":"880","slug":"892240ab573e","title":"为什么别人能谈笑风生，你却是冷场王？","fav":"34","img":"http://upload-images.jianshu.io/upload_images/1354061-d9679a297517f201.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"12","avatar":"http://upload.jianshu.io/users/upload_avatars/1354061/8220d93b17b9.jpeg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-28 20:36:29"},{"author":"简书日报","read":"7145","slug":"0ecdf7298833","title":"简书晚报160529\u2014\u2014《文章如何写出笔力？》","fav":"224","img":"http://upload-images.jianshu.io/upload_images/568470-412b5f481a605be8.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"10","avatar":"http://upload.jianshu.io/users/upload_avatars/568470/00a49b0d0567.jpeg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-29 10:40:33"},{"author":"江寒园","read":"9159","slug":"0f360583e4e6","title":"文章如何写出笔力？","fav":"845","img":"http://upload-images.jianshu.io/upload_images/193758-6785e0ed57dc6d35.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"116","avatar":"http://upload.jianshu.io/users/upload_avatars/193758/fae836c93cd8?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-28 16:40:00"},{"author":"袁小圆儿","read":"697","slug":"db986b6ac158","title":"高效学习的方法\u2014\u2014从个性出发，告别埋头苦读","fav":"42","img":"http://upload.jianshu.io/users/upload_avatars/1416219/e2c859d13461.jpg?imageMogr/thumbnail/200x200/quality/100","comment":"9","avatar":"http://upload.jianshu.io/users/upload_avatars/1416219/e2c859d13461.jpg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-28 19:48:01"},{"author":"韩大爷的杂货铺","read":"9278","slug":"a32030c25ef5","title":"时间教会我们的6件事","fav":"484","img":"http://upload-images.jianshu.io/upload_images/1767483-c4833e795b3f5980.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"220","avatar":"http://upload.jianshu.io/users/upload_avatars/1767483/1c03b1e7e325.jpeg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-28 13:20:06"},{"author":"简书活动精选","read":"9479","slug":"82a1f01535cc","title":"征集帖：给闺蜜的信 ｜六行书","fav":"288","img":"http://upload-images.jianshu.io/upload_images/654237-01a7932e74dc5d3b.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"778","avatar":"http://upload.jianshu.io/users/upload_avatars/654237/bd019828d682.jpg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-27 15:02:03"},{"author":"花落颜颜","read":"7839","slug":"8e1647e401bb","title":"没错呀，我就是要拉黑你，还要经过你同意吗？","fav":"220","img":"http://upload-images.jianshu.io/upload_images/1827809-87396cb344299d41.JPG?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"262","avatar":"http://upload.jianshu.io/users/upload_avatars/1827809/25fdfd3bf258.jpg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-28 13:02:45"},{"author":"简书播客","read":"1333","slug":"f15ce13c2c16","title":"简书播客#第十一期 有些人的一辈子 一天就过完了","fav":"23","img":"http://upload-images.jianshu.io/upload_images/1374926-1fc05bc2c98f35eb.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"5","avatar":"http://upload.jianshu.io/users/upload_avatars/1835826/fcfb7cdd47bd.jpg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-29 06:40:05"},{"author":"树獭先生","read":"5120","slug":"873f1ed7c54d","title":"怎样读书，才能转化为你的精神财富","fav":"296","img":"http://upload-images.jianshu.io/upload_images/1890381-9f881e556922c895.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"92","avatar":"http://upload.jianshu.io/users/upload_avatars/1890381/9d088eb49e94.jpeg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-28 13:49:31"},{"author":"简书","read":"5897","slug":"50f4d2f1b47c","title":"给简书找BUG赢好礼16.05.20\u2014\u2014简书android 1.10.8公测","fav":"29","img":"http://upload-images.jianshu.io/upload_images/259-2084aef093aad223.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"114","avatar":"http://upload.jianshu.io/users/upload_avatars/259/38c1de65b408.jpg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-20 21:16:05"},{"author":"共晴雨","read":"2042","slug":"f619c2a532d7","title":"你的文字值多少钱（六年的经验和总结）","fav":"171","img":"http://upload-images.jianshu.io/upload_images/1557406-341d3ef671b2bfd1.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"92","avatar":"http://upload.jianshu.io/users/upload_avatars/1557406/05f71792021f?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-28 15:18:24"},{"author":"简书活动精选","read":"1161","slug":"0114f0d253a7","title":"【特别策划】简书六一节活动召集：手工童话夜","fav":"22","img":"http://upload-images.jianshu.io/upload_images/75112-12f19080d6d108c9.JPG?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"3","avatar":"http://upload.jianshu.io/users/upload_avatars/654237/bd019828d682.jpg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-29 11:01:53"},{"author":"水若海澜_王澜","read":"915","slug":"47b9d53b130d","title":"成功没有捷径\u201490岁老人创造年利润7000万的传奇","fav":"40","img":"http://upload-images.jianshu.io/upload_images/1875031-eaac68c11011b922.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"19","avatar":"http://upload.jianshu.io/users/upload_avatars/1875031/ea6064af1226.jpg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-28 17:52:05"},{"author":"简书","read":"20135","slug":"4f1b7d4ef94e","title":"关于调整简书新浪联合认证标准的公告","fav":"274","img":"http://upload-images.jianshu.io/upload_images/259-5bab4699b76e4381.png?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300","comment":"217","avatar":"http://upload.jianshu.io/users/upload_avatars/259/38c1de65b408.jpg?imageMogr/thumbnail/90x90/quality/100","date":"2015-03-05 10:53:23"},{"author":"乘风律次方","read":"980","slug":"5c37a890bf8e","title":"6个问题后，你也是高效阅读者","fav":"58","img":"http://upload.jianshu.io/users/upload_avatars/2011165/374fdd3b96bd.jpeg?imageMogr/thumbnail/200x200/quality/100","comment":"8","avatar":"http://upload.jianshu.io/users/upload_avatars/2011165/374fdd3b96bd.jpeg?imageMogr/thumbnail/90x90/quality/100","date":"2016-05-28 17:16:12"}]
     * ids : ["4161556","4163685","4152043","3917977","4160443","4164289","4169527","4162052","4163189","4158266","4143202","4158323","4032403","4160679","4053565","4161375","4169918","4162763","751763","4161393"]
     * page : 2
     */

    private int count;
    private String page;
    private List<String> banner;
    /**
     * author : Sunflower_girl
     * read : 7348
     * slug : f076a5caabc7
     * title : 大学室友教会我的那些事
     * fav : 356
     * img : http://upload-images.jianshu.io/upload_images/1661508-a8cd574b1de121cb.jpg?imageMogr2/auto-orient/strip%7CimageView2/1/w/300/h/300
     * comment : 433
     * avatar : http://upload.jianshu.io/users/upload_avatars/1661508/7e3074c0cb15.jpg?imageMogr/thumbnail/90x90/quality/100
     * date : 2016-05-28 17:13:05
     */

    private List<ResultsBean> results;
    private List<String> ids;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<String> getBanner() {
        return banner;
    }

    public void setBanner(List<String> banner) {
        this.banner = banner;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public static class ResultsBean {
        private String author;
        private String read;
        private String slug;
        private String title;
        private String fav;
        private String img;
        private String comment;
        private String avatar;
        private String date;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getRead() {
            return read;
        }

        public void setRead(String read) {
            this.read = read;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFav() {
            return fav;
        }

        public void setFav(String fav) {
            this.fav = fav;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
