package com.tongming.jianshu.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tongming on 2016/6/21.
 */
public class UserLatest implements Parcelable {


    /**
     * nickname : 小辉同学
     * sub_collections : [{"author":"司风惜语","avatar":"http://upload.jianshu.io/collections/images/614/t01f46be856fa835e2d.jpg?imageMogr/thumbnail/300x300","name":"大学攻略：告诉你真相","slug":"23a52bf4ddbe"},{"author":"简书","avatar":"http://upload.jianshu.io/collections/images/49/66ba9fdegw1e61syw6tk6j20bj0go0wo.jpg?imageMogr/thumbnail/300x300","name":"谈谈情，说说爱","slug":"GQ5FAs"},{"author":"简书","avatar":"http://upload.jianshu.io/collections/images/20/%E5%9B%BE.jpg?imageMogr/thumbnail/300x300","name":"青春","slug":"e2XTpa"},{"author":"简书","avatar":"http://upload.jianshu.io/collections/images/61/0__15815600_401_00.jpg?imageMogr/thumbnail/300x300","name":"连载","slug":"xYuZYD"},{"author":"塔塔酱","avatar":"http://upload.jianshu.io/collections/images/129/add_new.png?imageMogr/thumbnail/300x300","name":"有意思的文章","slug":"c3eced01da7e"},{"author":"方成學長","avatar":"http://upload.jianshu.io/collections/images/296/534813_%287%29.png?imageMogr/thumbnail/300x300","name":"自成诗歌","slug":"413e22ad82e7"},{"author":"刘汉皇","avatar":"http://upload.jianshu.io/collections/images/4987/android.graphics.Bitmap_86a0c44.jpeg?imageMogr/thumbnail/300x300","name":"野草诗会","slug":"abb7173acc46"},{"author":"刘汉皇","avatar":"http://upload.jianshu.io/collections/images/1855/android.graphics.Bitmap_13eedc6.jpeg?imageMogr/thumbnail/300x300","name":"花非花诗集","slug":"cbf5e4d6970f"}]
     * follower_num : 48
     * following_num : 9
     * collections : [{"title":" 自由诗","slug":"680258161a85"},{"title":" 你是我的小情诗","slug":"0b3806564527"},{"title":" 微诗","slug":"90db0767c996"},{"title":" 随笔散文集","slug":"7855ae1136fe"},{"title":" 书光电影","slug":"755483e0ebe7"},{"title":" 短篇小说\u2022故事","slug":"f1c49fbbaee7"}]
     * about : <p class="intro"> 大家好，我是小辉，<br>努力为亲提供多样化、多文风原创之文。<br>我是地理狗，为文学艺术而奔跑。<br>关注生活，思考生活，分享生活，快乐生活。<br>欢迎加微信公众号@小辉童鞋。</br></br></br></br></p>
     * avatar : http://upload.jianshu.io/collections/images/1855/android.graphics.Bitmap_13eedc6.jpeg?imageMogr/thumbnail/300x300
     * like_num : 287
     * sub_notebooks : [{"author":"小辉同学","name":"随笔散文","id":"4579405"}]
     * notebook_num : 1
     * books : [{"book_id":"4579404","book_name":" 日记本"},{"book_id":"4579405","book_name":" 随笔散文"},{"book_id":"4584491","book_name":" 自由诗"},{"book_id":"4584502","book_name":" 小说"},{"book_id":"4586984","book_name":" 微诗碎语"},{"book_id":"4599621","book_name":" 书光电影"},{"book_id":"4627499","book_name":" 你是我的小情诗"}]
     * subscription_num : 38
     * article_num : 28
     * followings : [{"nickname":"简书首席拒稿官","article_num":"6000","follower_num":"6000","following_num":"128","avatar":"http://upload.jianshu.io/users/upload_avatars/10914/23eb63e6d5eb?imageMogr/thumbnail/90x90/quality/100","slug":"aTFqFm"},{"nickname":"关邑笑","article_num":"27","follower_num":"27","following_num":"7","avatar":"http://upload.jianshu.io/users/upload_avatars/2267212/a395874b3a1e.jpg?imageMogr/thumbnail/90x90/quality/100","slug":"ca032851bf73"},{"nickname":"曜日黑","article_num":"132","follower_num":"132","following_num":"19","avatar":"http://upload.jianshu.io/users/upload_avatars/2098924/0fbe50df5be2.jpg?imageMogr/thumbnail/90x90/quality/100","slug":"7cfb667c82eb"},{"nickname":"徐昊昕","article_num":"62","follower_num":"62","following_num":"23","avatar":"http://upload.jianshu.io/users/upload_avatars/621637/63f64eab12fa?imageMogr/thumbnail/90x90/quality/100","slug":"bb694fae2bed"},{"nickname":"顾一宸","article_num":"3367","follower_num":"3367","following_num":"34","avatar":"http://upload.jianshu.io/users/upload_avatars/1669869/d86b6c44d188.jpg?imageMogr/thumbnail/90x90/quality/100","slug":"c1fed915ed12"},{"nickname":"枫小梦","article_num":"1048","follower_num":"1048","following_num":"210","avatar":"http://upload.jianshu.io/users/upload_avatars/1122063/014a603fb510.jpg?imageMogr/thumbnail/90x90/quality/100","slug":"6aa245e48ccc"},{"nickname":"迎刃","article_num":"6837","follower_num":"6837","following_num":"204","avatar":"http://upload.jianshu.io/users/upload_avatars/253140/b9adfdadef8a?imageMogr/thumbnail/90x90/quality/100","slug":"98ee768fc12b"},{"nickname":"陈子淏","article_num":"4212","follower_num":"4212","following_num":"18","avatar":"http://upload.jianshu.io/users/upload_avatars/1885157/411a9ff0db9b.jpg?imageMogr/thumbnail/90x90/quality/100","slug":"82f67aa37c8e"},{"nickname":"徐沪生","article_num":"8015","follower_num":"8015","following_num":"0","avatar":"http://upload.jianshu.io/users/upload_avatars/1330738/20313b2f6b35?imageMogr/thumbnail/90x90/quality/100","slug":"4a7aa0c3d39f"}]
     * latest_articles : [{"date":"2016-06-21 09:12:14","avatar":null,"author_slug":"3722cae8b566","read":"3633","comment":"90","title":"大学里应该知道的事情：爱情篇","author":"小辉同学","fav":"151","slug":"bcb7b1237887","img":null},{"date":"2016-06-20 11:22:14","avatar":null,"author_slug":"3722cae8b566","read":"48","comment":"0","title":"约炮真的是正常的吗","author":"小辉同学","fav":"2","slug":"b439daa285cd","img":null},{"date":"2016-06-19 14:50:51","avatar":null,"author_slug":"3722cae8b566","read":"33","comment":"0","title":"父亲（自由诗3）","author":"小辉同学","fav":"2","slug":"2f431345268e","img":null},{"date":"2016-06-19 13:38:12","avatar":null,"author_slug":"3722cae8b566","read":"9","comment":"0","title":"父亲，我爱你。","author":"小辉同学","fav":"1","slug":"a02c8b2ea6c5","img":null},{"date":"2016-06-18 21:34:36","avatar":null,"author_slug":"3722cae8b566","read":"55","comment":"4","title":"谈谈在公众场合喂乳","author":"小辉同学","fav":"4","slug":"2f6f4ae1b86c","img":null},{"date":"2016-06-18 15:24:33","avatar":null,"author_slug":"3722cae8b566","read":"18","comment":"0","title":"写给你的诗4：灯下","author":"小辉同学","fav":"4","slug":"54fe1d73bdce","img":null},{"date":"2016-06-17 12:36:59","avatar":null,"author_slug":"3722cae8b566","read":"16","comment":"0","title":"\u201c裸条背后\u201d，谈谈高利贷之害","author":"小辉同学","fav":"2","slug":"754a479e0267","img":null},{"date":"2016-06-16 21:57:15","avatar":null,"author_slug":"3722cae8b566","read":"20","comment":"0","title":"写给你的诗3：无题","author":"小辉同学","fav":"3","slug":"54db0f32a764","img":null},{"date":"2016-06-15 22:18:20","avatar":null,"author_slug":"3722cae8b566","read":"154","comment":"19","title":"谈谈恐怖袭击，愿世界和平。","author":"小辉同学","fav":"8","slug":"764c1b604ba0","img":null}]
     * collection_num : 8
     * fans : [{"articles_num":" 文章 0","article_info":"写了 0 字, 获得了 0 个喜欢","nickname":"阿森岛","notebooks_num":" 文集 0","following_num":"关注 20","avatar":"http://upload.jianshu.io/users/upload_avatars/1625844/c22b13fe5575.jpeg?imageMogr/thumbnail/90x90/quality/100","followers_num":" 粉丝 0","slug":"021ddf3b52cf"},{"articles_num":" 文章 7","article_info":"写了 6725 字, 获得了 11 个喜欢","nickname":"默及","notebooks_num":" 文集 2","following_num":"关注 19","avatar":"http://upload.jianshu.io/users/upload_avatars/2225901/ee4bcafad578.jpeg?imageMogr/thumbnail/90x90/quality/100","followers_num":" 粉丝 5","slug":"6f0f17bd5df6"},{"articles_num":" 文章 4","article_info":"写了 5935 字, 获得了 4 个喜欢","nickname":"陈七寻","notebooks_num":" 文集 2","following_num":"关注 4","avatar":"http://upload.jianshu.io/users/upload_avatars/1892574/c8bc54e86e09.jpeg?imageMogr/thumbnail/90x90/quality/100","followers_num":" 粉丝 5","slug":"c145f7047c29"},{"articles_num":" 文章 0","article_info":"写了 0 字, 获得了 0 个喜欢","nickname":"小呀么小泰勒","notebooks_num":" 文集 0","following_num":"关注 53","avatar":"http://upload.jianshu.io/users/upload_avatars/1394684/ca2291ac57ed?imageMogr/thumbnail/90x90/quality/100","followers_num":" 粉丝 1","slug":"5ff035314150"},{"articles_num":" 文章 0","article_info":"写了 0 字, 获得了 0 个喜欢","nickname":"荼靡f_","notebooks_num":" 文集 0","following_num":"关注 20","avatar":"http://upload.jianshu.io/users/upload_avatars/2099844/51a9f181e4bd?imageMogr/thumbnail/90x90/quality/100","followers_num":" 粉丝 0","slug":"ed2f15b07abf"},{"articles_num":" 文章 0","article_info":"写了 0 字, 获得了 0 个喜欢","nickname":"心里苦就要多吃糖","notebooks_num":" 文集 0","following_num":"关注 1","avatar":"http://upload.jianshu.io/users/upload_avatars/2311473/cf977e241dbe?imageMogr/thumbnail/90x90/quality/100","followers_num":" 粉丝 0","slug":"555ab9c83ebb"},{"articles_num":" 文章 0","article_info":"写了 0 字, 获得了 0 个喜欢","nickname":"莫大人kuwo","notebooks_num":" 文集 0","following_num":"关注 11","avatar":"http://upload.jianshu.io/users/upload_avatars/2146138/78798d1de00c?imageMogr/thumbnail/90x90/quality/100","followers_num":" 粉丝 0","slug":"309e911fcb82"},{"articles_num":" 文章 0","article_info":"写了 0 字, 获得了 0 个喜欢","nickname":"夏安豆","notebooks_num":" 文集 0","following_num":"关注 13","avatar":"http://upload.jianshu.io/users/upload_avatars/2225595/6f54c2a8a75a?imageMogr/thumbnail/90x90/quality/100","followers_num":" 粉丝 0","slug":"988a4eafc754"},{"articles_num":" 文章 2","article_info":"写了 2059 字, 获得了 1 个喜欢","nickname":"若梦forever","notebooks_num":" 文集 1","following_num":"关注 21","avatar":"http://upload.jianshu.io/users/upload_avatars/1442322/2863393ab808.jpeg?imageMogr/thumbnail/90x90/quality/100","followers_num":" 粉丝 1","slug":"4b62b2df9fe0"}]
     * page : 4
     * slug : 3722cae8b566
     * word_age : 34723
     */

    private String nickname;
    private String follower_num;
    private int following_num;
    private String about;
    private String avatar;
    private String like_num;
    private int notebook_num;
    private String subscription_num;
    private String article_num;
    private int collection_num;
    private int page;
    private String slug;
    private String word_age;
    /**
     * author : 司风惜语
     * avatar : http://upload.jianshu.io/collections/images/614/t01f46be856fa835e2d.jpg?imageMogr/thumbnail/300x300
     * name : 大学攻略：告诉你真相
     * slug : 23a52bf4ddbe
     */

    private List<SubCollectionsBean> sub_collections;
    /**
     * title :  自由诗
     * slug : 680258161a85
     */

    private List<CollectionsBean> collections;
    /**
     * author : 小辉同学
     * name : 随笔散文
     * id : 4579405
     */

    private List<SubNotebooksBean> sub_notebooks;
    /**
     * book_id : 4579404
     * book_name :  日记本
     */

    private List<BooksBean> books;
    /**
     * nickname : 简书首席拒稿官
     * article_num : 6000
     * follower_num : 6000
     * following_num : 128
     * avatar : http://upload.jianshu.io/users/upload_avatars/10914/23eb63e6d5eb?imageMogr/thumbnail/90x90/quality/100
     * slug : aTFqFm
     */

    private List<FollowingsBean> followings;
    /**
     * date : 2016-06-21 09:12:14
     * avatar : null
     * author_slug : 3722cae8b566
     * read : 3633
     * comment : 90
     * title : 大学里应该知道的事情：爱情篇
     * author : 小辉同学
     * fav : 151
     * slug : bcb7b1237887
     * img : null
     */

    private List<Article> latest_articles;
    /**
     * articles_num :  文章 0
     * article_info : 写了 0 字, 获得了 0 个喜欢
     * nickname : 阿森岛
     * notebooks_num :  文集 0
     * following_num : 关注 20
     * avatar : http://upload.jianshu.io/users/upload_avatars/1625844/c22b13fe5575.jpeg?imageMogr/thumbnail/90x90/quality/100
     * followers_num :  粉丝 0
     * slug : 021ddf3b52cf
     */

    private List<FansBean> fans;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFollower_num() {
        return follower_num;
    }

    public void setFollower_num(String follower_num) {
        this.follower_num = follower_num;
    }

    public int getFollowing_num() {
        return following_num;
    }

    public void setFollowing_num(int following_num) {
        this.following_num = following_num;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLike_num() {
        return like_num;
    }

    public void setLike_num(String like_num) {
        this.like_num = like_num;
    }

    public int getNotebook_num() {
        return notebook_num;
    }

    public void setNotebook_num(int notebook_num) {
        this.notebook_num = notebook_num;
    }

    public String getSubscription_num() {
        return subscription_num;
    }

    public void setSubscription_num(String subscription_num) {
        this.subscription_num = subscription_num;
    }

    public String getArticle_num() {
        return article_num;
    }

    public void setArticle_num(String article_num) {
        this.article_num = article_num;
    }

    public int getCollection_num() {
        return collection_num;
    }

    public void setCollection_num(int collection_num) {
        this.collection_num = collection_num;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getWord_age() {
        return word_age;
    }

    public void setWord_age(String word_age) {
        this.word_age = word_age;
    }

    public List<SubCollectionsBean> getSub_collections() {
        return sub_collections;
    }

    public void setSub_collections(List<SubCollectionsBean> sub_collections) {
        this.sub_collections = sub_collections;
    }

    public List<CollectionsBean> getCollections() {
        return collections;
    }

    public void setCollections(List<CollectionsBean> collections) {
        this.collections = collections;
    }

    public List<SubNotebooksBean> getSub_notebooks() {
        return sub_notebooks;
    }

    public void setSub_notebooks(List<SubNotebooksBean> sub_notebooks) {
        this.sub_notebooks = sub_notebooks;
    }

    public List<BooksBean> getBooks() {
        return books;
    }

    public void setBooks(List<BooksBean> books) {
        this.books = books;
    }

    public List<FollowingsBean> getFollowings() {
        return followings;
    }

    public void setFollowings(List<FollowingsBean> followings) {
        this.followings = followings;
    }

    public List<Article> getLatest_articles() {
        return latest_articles;
    }

    public void setLatest_articles(List<Article> latest_articles) {
        this.latest_articles = latest_articles;
    }

    public List<FansBean> getFans() {
        return fans;
    }

    public void setFans(List<FansBean> fans) {
        this.fans = fans;
    }

    public static class SubCollectionsBean {
        private String author;
        private String avatar;
        private String name;
        private String slug;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }
    }

    public static class CollectionsBean {
        private String title;
        private String slug;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }
    }

    public static class SubNotebooksBean {
        private String author;
        private String name;
        private String id;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class BooksBean {
        private String book_id;
        private String book_name;

        public String getBook_id() {
            return book_id;
        }

        public void setBook_id(String book_id) {
            this.book_id = book_id;
        }

        public String getBook_name() {
            return book_name;
        }

        public void setBook_name(String book_name) {
            this.book_name = book_name;
        }
    }

    public static class FollowingsBean {
        private String nickname;
        private String article_num;
        private String follower_num;
        private String following_num;
        private String avatar;
        private String slug;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getArticle_num() {
            return article_num;
        }

        public void setArticle_num(String article_num) {
            this.article_num = article_num;
        }

        public String getFollower_num() {
            return follower_num;
        }

        public void setFollower_num(String follower_num) {
            this.follower_num = follower_num;
        }

        public String getFollowing_num() {
            return following_num;
        }

        public void setFollowing_num(String following_num) {
            this.following_num = following_num;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }
    }

    public static class FansBean {
        private String articles_num;
        private String article_info;
        private String nickname;
        private String notebooks_num;
        private String following_num;
        private String avatar;
        private String followers_num;
        private String slug;

        public String getArticles_num() {
            return articles_num;
        }

        public void setArticles_num(String articles_num) {
            this.articles_num = articles_num;
        }

        public String getArticle_info() {
            return article_info;
        }

        public void setArticle_info(String article_info) {
            this.article_info = article_info;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getNotebooks_num() {
            return notebooks_num;
        }

        public void setNotebooks_num(String notebooks_num) {
            this.notebooks_num = notebooks_num;
        }

        public String getFollowing_num() {
            return following_num;
        }

        public void setFollowing_num(String following_num) {
            this.following_num = following_num;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getFollowers_num() {
            return followers_num;
        }

        public void setFollowers_num(String followers_num) {
            this.followers_num = followers_num;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nickname);
        dest.writeString(this.follower_num);
        dest.writeInt(this.following_num);
        dest.writeString(this.about);
        dest.writeString(this.avatar);
        dest.writeString(this.like_num);
        dest.writeInt(this.notebook_num);
        dest.writeString(this.subscription_num);
        dest.writeString(this.article_num);
        dest.writeInt(this.collection_num);
        dest.writeInt(this.page);
        dest.writeString(this.slug);
        dest.writeString(this.word_age);
        dest.writeList(this.sub_collections);
        dest.writeList(this.collections);
        dest.writeList(this.sub_notebooks);
        dest.writeList(this.books);
        dest.writeList(this.followings);
        dest.writeList(this.latest_articles);
        dest.writeList(this.fans);
    }

    public UserLatest() {
    }

    protected UserLatest(Parcel in) {
        this.nickname = in.readString();
        this.follower_num = in.readString();
        this.following_num = in.readInt();
        this.about = in.readString();
        this.avatar = in.readString();
        this.like_num = in.readString();
        this.notebook_num = in.readInt();
        this.subscription_num = in.readString();
        this.article_num = in.readString();
        this.collection_num = in.readInt();
        this.page = in.readInt();
        this.slug = in.readString();
        this.word_age = in.readString();
        this.sub_collections = new ArrayList<SubCollectionsBean>();
        in.readList(this.sub_collections, SubCollectionsBean.class.getClassLoader());
        this.collections = new ArrayList<CollectionsBean>();
        in.readList(this.collections, CollectionsBean.class.getClassLoader());
        this.sub_notebooks = new ArrayList<SubNotebooksBean>();
        in.readList(this.sub_notebooks, SubNotebooksBean.class.getClassLoader());
        this.books = new ArrayList<BooksBean>();
        in.readList(this.books, BooksBean.class.getClassLoader());
        this.followings = new ArrayList<FollowingsBean>();
        in.readList(this.followings, FollowingsBean.class.getClassLoader());
        this.latest_articles = new ArrayList<Article>();
        in.readList(this.latest_articles, Article.class.getClassLoader());
        this.fans = new ArrayList<FansBean>();
        in.readList(this.fans, FansBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<UserLatest> CREATOR = new Parcelable.Creator<UserLatest>() {
        @Override
        public UserLatest createFromParcel(Parcel source) {
            return new UserLatest(source);
        }

        @Override
        public UserLatest[] newArray(int size) {
            return new UserLatest[size];
        }
    };
}
