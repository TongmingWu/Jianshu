package com.tongming.jianshu.bean;

/**
 * Created by Tongming on 2016/5/22.
 */
public class Detail {


    /**
     * id : 4059369
     * title : 为什么我就是想去大城市受苦受累？ - 简书
     * content :
     * comments_count : 433
     * url : http://www.jianshu.com/p/e9ba83e9b5d4
     * created_at : 2016.05.22 11:25
     * views_count : 14280
     * slug : e9ba83e9b5d4
     * wordage : 2072
     * image_url : http://cwb.assets.jianshu.io/notes/images/4059369/weibo/image_c809812e778e.jpg
     * rewards_total_count : 8
     * likes_count : 821
     * has_further_readings : false
     * abbr : 毕业季，面临各种选择，读研？工作？出国？但是无论走哪条路，关于日后的发展总是逃不开这个问题：“你以后想留在哪个城市？”不知从什么时候开始，“逃离北上广”的论调日渐甚嚣尘上，新闻报道的大多是大城市打拼的艰难困苦、小城市安家的逍遥自在，似乎选择“大城小床”可笑而愚蠢，选择“小城大床”才是准确而明智。“阶级固化”理论说，穷人向上流动的成本越来越高、动力越来越小，大城市的每一块砖瓦的缝隙之间都流动着户籍歧视、就业歧视、竞争激烈、人脉至上、拜金主义的冰冷血液，令人胆颤，让人心寒。电影里的大城市，X二代爱上穷人；现实里，X二代碾压穷人。大城里的小床可能第二天就被房东收走，小城里的大床却可以一直为我所...
     */

    private ArticleBean article;
    /**
     * uuid : 5079b620-025c-0134-350b-52540095852f
     */

    private UuidBean uuid;
    /**
     * id : 1484196
     * public_notes_count : 26
     * total_likes_count : 10039
     * font_count : 51797
     * followers_count : 3408
     * slug : 2d016299d2b5
     * nickname : 李小狼不狼
     * is_signed_author : true
     * is_current_user : false
     * avatar : http://upload.jianshu.io/users/upload_avatars/1484196/09845ba52f5d.jpg?imageMogr/thumbnail/90x90/quality/100
     */

    private AuthorBean author;

    public ArticleBean getArticle() {
        return article;
    }

    public void setArticle(ArticleBean article) {
        this.article = article;
    }

    public UuidBean getUuid() {
        return uuid;
    }

    public void setUuid(UuidBean uuid) {
        this.uuid = uuid;
    }

    public AuthorBean getAuthor() {
        return author;
    }

    public void setAuthor(AuthorBean author) {
        this.author = author;
    }

    public static class ArticleBean {
        private int id;
        private String title;
        private String content;
        private int comments_count;
        private String url;
        private String created_at;
        private int views_count;
        private String slug;
        private int wordage;
        private String image_url;
        private int rewards_total_count;
        private int likes_count;
        private boolean has_further_readings;
        private String abbr;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public int getViews_count() {
            return views_count;
        }

        public void setViews_count(int views_count) {
            this.views_count = views_count;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public int getWordage() {
            return wordage;
        }

        public void setWordage(int wordage) {
            this.wordage = wordage;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public int getRewards_total_count() {
            return rewards_total_count;
        }

        public void setRewards_total_count(int rewards_total_count) {
            this.rewards_total_count = rewards_total_count;
        }

        public int getLikes_count() {
            return likes_count;
        }

        public void setLikes_count(int likes_count) {
            this.likes_count = likes_count;
        }

        public boolean isHas_further_readings() {
            return has_further_readings;
        }

        public void setHas_further_readings(boolean has_further_readings) {
            this.has_further_readings = has_further_readings;
        }

        public String getAbbr() {
            return abbr;
        }

        public void setAbbr(String abbr) {
            this.abbr = abbr;
        }
    }

    public static class UuidBean {
        private String uuid;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }

    public static class AuthorBean {
        private int id;
        private int public_notes_count;
        private int total_likes_count;
        private String font_count;
        private int followers_count;
        private String slug;
        private String nickname;
        private boolean is_signed_author;
        private boolean is_current_user;
        private String avatar;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPublic_notes_count() {
            return public_notes_count;
        }

        public void setPublic_notes_count(int public_notes_count) {
            this.public_notes_count = public_notes_count;
        }

        public int getTotal_likes_count() {
            return total_likes_count;
        }

        public void setTotal_likes_count(int total_likes_count) {
            this.total_likes_count = total_likes_count;
        }

        public String getFont_count() {
            return font_count;
        }

        public void setFont_count(String font_count) {
            this.font_count = font_count;
        }

        public int getFollowers_count() {
            return followers_count;
        }

        public void setFollowers_count(int followers_count) {
            this.followers_count = followers_count;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public boolean isIs_signed_author() {
            return is_signed_author;
        }

        public void setIs_signed_author(boolean is_signed_author) {
            this.is_signed_author = is_signed_author;
        }

        public boolean isIs_current_user() {
            return is_current_user;
        }

        public void setIs_current_user(boolean is_current_user) {
            this.is_current_user = is_current_user;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
