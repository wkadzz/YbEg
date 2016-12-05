package com.example.wk.ybeg.model;

import java.util.List;

/**
 * Created by WK on 2016/11/29.
 */
public class FeiLeiModel {

    /**
     * cat_id : 513
     * cat_name : 休闲食品零食
     * list : [{"cat_id":"526","cat_name":"糖果/巧克力","children":[{"cat_id":"603","cat_name":"软糖"},{"cat_id":"612","cat_name":"巧克力"},{"cat_id":"611","cat_name":"太妃糖"},{"cat_id":"610","cat_name":"泡泡糖"},{"cat_id":"609","cat_name":"棒棒糖"},{"cat_id":"608","cat_name":"瑞士糖"},{"cat_id":"607","cat_name":"橡皮糖"},{"cat_id":"606","cat_name":"奶糖"},{"cat_id":"605","cat_name":"润喉糖"},{"cat_id":"604","cat_name":"口香糖"},{"cat_id":"602","cat_name":"硬糖"}]},{"cat_id":"527","cat_name":"果冻/布丁类","children":[{"cat_id":"613","cat_name":"杯装果冻"},{"cat_id":"614","cat_name":"吸吸果冻"},{"cat_id":"615","cat_name":"袋装果冻"},{"cat_id":"616","cat_name":"礼包果冻"},{"cat_id":"617","cat_name":"碎碎冰"},{"cat_id":"618","cat_name":"布丁"}]},{"cat_id":"528","cat_name":"饼干类","children":[{"cat_id":"619","cat_name":"咸味饼干"},{"cat_id":"620","cat_name":"甜味饼干"},{"cat_id":"621","cat_name":"夹心饼干"},{"cat_id":"622","cat_name":"曲奇饼干"},{"cat_id":"623","cat_name":"粗粮饼干"},{"cat_id":"624","cat_name":"威化"},{"cat_id":"625","cat_name":"儿童饼干"},{"cat_id":"626","cat_name":"米饼"},{"cat_id":"627","cat_name":"饼干礼盒"}]},{"cat_id":"529","cat_name":"派/蛋糕/糕点类","children":[{"cat_id":"639","cat_name":"派/蛋糕"},{"cat_id":"640","cat_name":"糕点"},{"cat_id":"641","cat_name":"\r\n桃酥"},{"cat_id":"642","cat_name":"\r\n蛋卷"},{"cat_id":"643","cat_name":"\r\n草饼/雪丽糍"},{"cat_id":"644","cat_name":"\r\n沙琪玛"},{"cat_id":"645","cat_name":"\r\n面包"},{"cat_id":"646","cat_name":"\r\n煎饼/麻花"},{"cat_id":"647","cat_name":"\r\n法饼"}]},{"cat_id":"530","cat_name":"膨化类","children":[{"cat_id":"672","cat_name":"薯条"},{"cat_id":"673","cat_name":"\r\n袋装薯片/罐装薯片"},{"cat_id":"674","cat_name":"\r\n米制/玉米膨化"},{"cat_id":"675","cat_name":"\r\n虾片/虾条"},{"cat_id":"676","cat_name":"\r\n香芋/爆米/锅巴"}]},{"cat_id":"531","cat_name":"炒货类","children":[{"cat_id":"693","cat_name":"葵瓜子"},{"cat_id":"694","cat_name":"\r\n西瓜子"},{"cat_id":"695","cat_name":"\r\n茶瓜子等"},{"cat_id":"696","cat_name":"\r\n花生"},{"cat_id":"697","cat_name":"\r\n豆类"},{"cat_id":"698","cat_name":"坚果"},{"cat_id":"1028","cat_name":"南瓜子"}]},{"cat_id":"532","cat_name":"肉干/海产类","children":[{"cat_id":"701","cat_name":"牛肉干"},{"cat_id":"702","cat_name":"\r\n猪肉干"},{"cat_id":"703","cat_name":"\r\n即食海苔/紫菜"},{"cat_id":"704","cat_name":"\r\n海产/鱼"}]},{"cat_id":"533","cat_name":"干果/蜜饯类","children":[{"cat_id":"709","cat_name":"\r\n蜜枣/干枣"},{"cat_id":"716","cat_name":"\r\n蜜饯"},{"cat_id":"715","cat_name":"枣糕"},{"cat_id":"714","cat_name":"\r\n梅子"},{"cat_id":"713","cat_name":"葡萄干"},{"cat_id":"708","cat_name":"干果"},{"cat_id":"712","cat_name":"\r\n加应子"},{"cat_id":"711","cat_name":"\r\n姜类"},{"cat_id":"710","cat_name":"\r\n山楂"},{"cat_id":"717","cat_name":"\r\n陈皮/槟榔/橄榄/果脯"}]},{"cat_id":"534","cat_name":"休闲熟食","children":[{"cat_id":"726","cat_name":"综合礼包"},{"cat_id":"734","cat_name":"豆制品"},{"cat_id":"733","cat_name":"\r\n素食"},{"cat_id":"732","cat_name":"\r\n牛板筋"},{"cat_id":"731","cat_name":"\r\n蛋"},{"cat_id":"730","cat_name":"\r\n鸡"},{"cat_id":"729","cat_name":"鱼"},{"cat_id":"728","cat_name":"\r\n休闲鸭制品"},{"cat_id":"727","cat_name":"\r\n鸭（精装）"},{"cat_id":"735","cat_name":"肉品"}]}]
     */

    private String cat_id;
    private String cat_name;
    private List<ListBean> list;
    private boolean ischecked;

    public boolean ischecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * cat_id : 526
         * cat_name : 糖果/巧克力
         * children : [{"cat_id":"603","cat_name":"软糖"},{"cat_id":"612","cat_name":"巧克力"},{"cat_id":"611","cat_name":"太妃糖"},{"cat_id":"610","cat_name":"泡泡糖"},{"cat_id":"609","cat_name":"棒棒糖"},{"cat_id":"608","cat_name":"瑞士糖"},{"cat_id":"607","cat_name":"橡皮糖"},{"cat_id":"606","cat_name":"奶糖"},{"cat_id":"605","cat_name":"润喉糖"},{"cat_id":"604","cat_name":"口香糖"},{"cat_id":"602","cat_name":"硬糖"}]
         */

        private String cat_id;
        private String cat_name;
        private int spanCount=1;
        private List<ChildrenBean> children;

        public int getSpanCount() {
            return spanCount;
        }

        public void setSpanCount(int spanCount) {
            this.spanCount = spanCount;
        }

        public String getCat_id() {
            return cat_id;
        }

        public void setCat_id(String cat_id) {
            this.cat_id = cat_id;
        }

        public String getCat_name() {
            return cat_name;
        }

        public void setCat_name(String cat_name) {
            this.cat_name = cat_name;
        }

        public List<ChildrenBean> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBean> children) {
            this.children = children;
        }

        public static class ChildrenBean {
            /**
             * cat_id : 603
             * cat_name : 软糖
             */

            private String cat_id;
            private String cat_name;
            private int spanCount=1;

            public int getSpanCount() {
                return spanCount;
            }

            public void setSpanCount(int spanCount) {
                this.spanCount = spanCount;
            }

            public String getCat_id() {
                return cat_id;
            }

            public void setCat_id(String cat_id) {
                this.cat_id = cat_id;
            }

            public String getCat_name() {
                return cat_name;
            }

            public void setCat_name(String cat_name) {
                this.cat_name = cat_name;
            }
        }
    }
}
