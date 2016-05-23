package com.tongming.jianshu.bean;

import java.util.List;

/**
 * Created by Tongming on 2016/5/23.
 */
public class Comment {

    /**
     * review_list : [{"avatar":"http://upload.jianshu.io/users/upload_avatars/1484196/09845ba52f5d.jpg?imageMogr/thumbnail/90x90/quality/100","floor":"2","content":"抢沙发","date":"2016.05.22 11:34","child_list":[{"replay_time":"2016.05.22 11:34","name":"呆萌作者学黑客","replay":"@李小狼不狼 小狼的文很理性啊！ "}],"author":"李小狼不狼"},{"avatar":"http://upload.jianshu.io/users/upload_avatars/2095750/8bb6127789dc.jpeg?imageMogr/thumbnail/90x90/quality/100","floor":"4","content":"即将前往上海","date":"2016.05.22 11:51","child_list":[{"replay_time":"2016.05.22 11:51","name":"李小狼不狼","replay":"@需要阴天 加油"}],"author":"需要阴天"},{"avatar":"http://upload.jianshu.io/users/upload_avatars/1487291/9c890c58f996.jpeg?imageMogr/thumbnail/90x90/quality/100","floor":"5","content":"中午好，小狼😊","date":"2016.05.22 12:01","child_list":[{"replay_time":"2016.05.22 12:01","name":"李小狼不狼","replay":"@夏知凉 好好好么么哒～"}],"author":"夏知凉"},{"avatar":"http://upload.jianshu.io/users/upload_avatars/1442902/701156d5daa2.jpg?imageMogr/thumbnail/90x90/quality/100","floor":"6","content":"我的老乡李小狼～","date":"2016.05.22 12:02","child_list":[{"replay_time":"2016.05.22 12:02","name":"李小狼不狼","replay":"@衷曲无闻_ "}],"author":"衷曲无闻_"},{"avatar":"http://upload.jianshu.io/users/upload_avatars/1716797/285b7aec4ffa?imageMogr/thumbnail/90x90/quality/100","floor":"7","content":"狼","date":"2016.05.22 12:07","child_list":[{"replay_time":"2016.05.22 12:07","name":"李小狼不狼","replay":"@江罗 罗"},{"replay_time":"2016.05.22 12:07","name":"江罗","replay":"@李小狼不狼 爱我么？"},{"replay_time":"2016.05.22 12:07","name":"李小狼不狼","replay":"@江罗 爱\u2026\u2026\u2026\u2026（嫌弃）"}],"author":"江罗"},{"avatar":"http://upload.jianshu.io/users/upload_avatars/30219/a7e4b3b74661?imageMogr/thumbnail/90x90/quality/100","floor":"8","content":"因为你帅啊","date":"2016.05.22 12:07","child_list":[{"replay_time":"2016.05.22 12:07","name":"李小狼不狼","replay":"@沈万九 ？？"}],"author":"沈万九"},{"avatar":"http://upload.jianshu.io/users/upload_avatars/2023474/f8b33f9c9128.jpeg?imageMogr/thumbnail/90x90/quality/100","floor":"9","content":"挺好的","date":"2016.05.22 12:19","child_list":[{"replay_time":"2016.05.22 12:19","name":"李小狼不狼","replay":"@大纤纤阿 "}],"author":"大纤纤阿"},{"avatar":"http://upload.jianshu.io/users/upload_avatars/628944/46a7d8684dc2.jpg?imageMogr/thumbnail/90x90/quality/100","floor":"10","content":"","date":"2016.05.22 12:31","child_list":[{"replay_time":"2016.05.22 12:31","name":"李小狼不狼","replay":"@沈挽冬 挽冬我才知道你是女孩子"},{"replay_time":"2016.05.22 12:31","name":"沈挽冬","replay":"@李小狼不狼 啊哈你可以把我当作男孩子"}],"author":"沈挽冬"},{"avatar":"http://upload.jianshu.io/users/upload_avatars/2038735/88990a26d078.jpg?imageMogr/thumbnail/90x90/quality/100","floor":"11","content":"我喜欢生命的这种未知，大城市有孤独，也有追求。","date":"2016.05.22 12:40","child_list":[{"replay_time":"2016.05.22 12:40","name":"李小狼不狼","replay":"@赵丽颖不笨 嗯"}],"author":"赵丽颖不笨"},{"avatar":"http://upload.jianshu.io/users/upload_avatars/1206754/521b1a720471.jpg?imageMogr/thumbnail/90x90/quality/100","floor":"12","content":"纵使生活再难再累也无法阻挡一颗想出去见识广阔天空的心，祝未来的我好","date":"2016.05.22 12:46","child_list":[{"replay_time":"2016.05.22 12:46","name":"李小狼不狼","replay":"@怪兽你别跑 祝你好"}],"author":"怪兽你别跑"},{"avatar":"http://upload.jianshu.io/users/upload_avatars/1483002/de2cf11783d1.jpg?imageMogr/thumbnail/90x90/quality/100","floor":"13","content":"说的好 也喜欢你不娇柔做作的文风","date":"2016.05.22 12:49","child_list":[{"replay_time":"2016.05.22 12:49","name":"李小狼不狼","replay":"@一个有理想的空姐 么么哒"}],"author":"一个有理想的空姐"},{"avatar":"http://upload.jianshu.io/users/upload_avatars/2012522/af2cd9b10f6d?imageMogr/thumbnail/90x90/quality/100","floor":"14","content":"家里的人们思想太狭隘，容不下跟他们不一样的想法和行动，只会说你傻，还好心的劝你别那么折腾了，安慰的日子不好么，真是可笑可笑。","date":"2016.05.22 12:49","child_list":[{"replay_time":"2016.05.22 12:49","name":"李小狼不狼","replay":"@茂密夏树 唉\u2026"}],"author":"茂密夏树"},{"avatar":"http://upload.jianshu.io/users/upload_avatars/1211050/79da0be500d6?imageMogr/thumbnail/90x90/quality/100","floor":"15","content":"赞同","date":"2016.05.22 12:53","child_list":[{"replay_time":"2016.05.22 12:53","name":"李小狼不狼","replay":"@总在路上 谢谢"}],"author":"总在路上"},{"avatar":"http://upload.jianshu.io/users/upload_avatars/2130980/ea18a3d471fb?imageMogr/thumbnail/90x90/quality/100","floor":"16","content":"+1","date":"2016.05.22 12:55","child_list":[{"replay_time":"2016.05.22 12:55","name":"李小狼不狼","replay":"@爱读书的miss +10086"}],"author":"爱读书的miss"},{"avatar":"http://upload.jianshu.io/users/upload_avatars/2116677/88b2a7e05e19.jpg?imageMogr/thumbnail/90x90/quality/100","floor":"17","content":"是真心的。我也不想在这一座小城终老，尽管心里知道这里是根。但我需要更好的发展空间，大城市正因为未知，才更加精彩！加油。向上的90！","date":"2016.05.22 12:58","child_list":[{"replay_time":"2016.05.22 12:58","name":"李小狼不狼","replay":"@人丑就要多读书95 加油"}],"author":"人丑就要多读书95"}]
     * results : 15
     * nid : 4059369
     */

    private int results;
    private String nid;
    /**
     * avatar : http://upload.jianshu.io/users/upload_avatars/1484196/09845ba52f5d.jpg?imageMogr/thumbnail/90x90/quality/100
     * floor : 2
     * content : 抢沙发
     * date : 2016.05.22 11:34
     * child_list : [{"replay_time":"2016.05.22 11:34","name":"呆萌作者学黑客","replay":"@李小狼不狼 小狼的文很理性啊！ "}]
     * author : 李小狼不狼
     */

    private List<ReviewListBean> review_list;

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public List<ReviewListBean> getReview_list() {
        return review_list;
    }

    public void setReview_list(List<ReviewListBean> review_list) {
        this.review_list = review_list;
    }

    public static class ReviewListBean {
        private String avatar;
        private String floor;
        private String content;
        private String date;
        private String author;
        /**
         * replay_time : 2016.05.22 11:34
         * name : 呆萌作者学黑客
         * replay : @李小狼不狼 小狼的文很理性啊！
         */

        private List<ChildListBean> child_list;

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public List<ChildListBean> getChild_list() {
            return child_list;
        }

        public void setChild_list(List<ChildListBean> child_list) {
            this.child_list = child_list;
        }

        public static class ChildListBean {
            private String replay_time;
            private String name;
            private String replay;

            public String getReplay_time() {
                return replay_time;
            }

            public void setReplay_time(String replay_time) {
                this.replay_time = replay_time;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getReplay() {
                return replay;
            }

            public void setReplay(String replay) {
                this.replay = replay;
            }
        }
    }
}
