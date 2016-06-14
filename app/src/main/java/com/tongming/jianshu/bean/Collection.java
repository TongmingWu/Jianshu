package com.tongming.jianshu.bean;

import java.util.List;

/**
 * Created by Tongming on 2016/6/13.
 */
public class Collection {

    /**
     * title : 首页投稿
     * description : 玩转简书的第一步，从这个专题开始。 想上首页热门榜么？好内容想被更多人看到么？来投稿吧！如果被拒也不要灰心哦～入选文章会进一个队列挨个上首页，请耐心等待。 投稿必须原创。如果发现有非...
     * avatar : http://upload.jianshu.io/collections/images/47/rdn_4ddb18fddd2e9_%281%29.jpg?imageMogr/thumbnail/180x180
     * article_num : 65041
     * att_num : 106.4K
     */

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String title;
        private String description;
        private String avatar;
        private String article_num;
        private String att_num;
        private String collection_id;
        private String slug;

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getSlug() {

            return slug;
        }

        public String getCollection_id() {
            return collection_id;
        }

        public void setCollection_id(String collection_id) {
            this.collection_id = collection_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getArticle_num() {
            return article_num;
        }

        public void setArticle_num(String article_num) {
            this.article_num = article_num;
        }

        public String getAtt_num() {
            return att_num;
        }

        public void setAtt_num(String att_num) {
            this.att_num = att_num;
        }
    }
}
