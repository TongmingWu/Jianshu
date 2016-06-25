package com.tongming.jianshu.bean;

import java.util.List;

/**
 * Created by Tongming on 2016/6/21.
 */
public class UserTimeLine {

    /**
     * action :  树獭先生 评论了文章 《只能耳听的爱情，喂狗去吧》
     * category : comment
     * date : 6月21日 00:22
     * content :  @_夏医生 是的。
     */

    private List<TrendsBean> trends;

    public List<TrendsBean> getTrends() {
        return trends;
    }

    public void setTrends(List<TrendsBean> trends) {
        this.trends = trends;
    }

    public static class TrendsBean {
        private String action;
        private String category;
        private String date;
        private String content;
        private String avatar;

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getAvatar() {

            return avatar;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
