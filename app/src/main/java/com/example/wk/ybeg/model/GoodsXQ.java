package com.example.wk.ybeg.model;

import java.util.List;

/**
 * Created by WK on 2016/12/2.
 */
public class GoodsXQ {

    /**
     * goods : {"brand_id":"548","click_count":"78","give_integral":8,"goods_desc":"","goods_name":"阿尔卑斯原味糖150g","goods_number":"100","goods_sn":"6911316400030","goods_weight":"0.150","integral":0,"is_promote":"0","is_real":"1","market_price":"8.80","promote_atr":0,"promote_end_date":"0","promote_price":"0.00","promote_start_date":"0","rank_integral":8.8,"service_phone":"","shop_atr":8.8,"shop_logo":"","shop_price":8.8,"shopname":"网站自营","supplier_id":"0","volume":[]}
     * goods_attr : []
     * goods_gallery : [{"img_url":"images/201508/goods_img/2781_P_1440495410706.jpg"},{"img_url":"images/201508/goods_img/2781_P_1440495410756.jpg"},{"img_url":"images/201508/goods_img/2781_P_1440495411594.jpg"},{"img_url":"images/201508/goods_img/2781_P_1440495412750.jpg"},{"img_url":"images/201508/goods_img/2781_P_1440495419764.jpg"}]
     * is_collect_goods : false
     * use_storage : {"value":"1"}
     * user_rank_info : {}
     * user_rank_prices : [{"price":"￥8.80","price_promote":"￥0","price_shop":"￥8.80","rank_id":"5","rank_name":"银牌会员","show_price":"0"},{"price":"￥8.80","price_promote":"￥0","price_shop":"￥8.80","rank_id":"3","rank_name":"注册会员","show_price":"0"},{"price":"￥8.80","price_promote":"￥0","price_shop":"￥8.80","rank_id":"6","rank_name":"金牌会员","show_price":"0"},{"price":"￥8.80","price_promote":"￥0","price_shop":"￥8.80","rank_id":"7","rank_name":"钻石会员","show_price":"0"}]
     */

    private GoodsBean goods;
    private boolean is_collect_goods;
    private UseStorageBean use_storage;
    private UserRankInfoBean user_rank_info;
    private List<?> goods_attr;
    private List<GoodsGalleryBean> goods_gallery;
    private List<UserRankPricesBean> user_rank_prices;

    public GoodsBean getGoods() {
        return goods;
    }

    public void setGoods(GoodsBean goods) {
        this.goods = goods;
    }

    public boolean isIs_collect_goods() {
        return is_collect_goods;
    }

    public void setIs_collect_goods(boolean is_collect_goods) {
        this.is_collect_goods = is_collect_goods;
    }

    public UseStorageBean getUse_storage() {
        return use_storage;
    }

    public void setUse_storage(UseStorageBean use_storage) {
        this.use_storage = use_storage;
    }

    public UserRankInfoBean getUser_rank_info() {
        return user_rank_info;
    }

    public void setUser_rank_info(UserRankInfoBean user_rank_info) {
        this.user_rank_info = user_rank_info;
    }

    public List<?> getGoods_attr() {
        return goods_attr;
    }

    public void setGoods_attr(List<?> goods_attr) {
        this.goods_attr = goods_attr;
    }

    public List<GoodsGalleryBean> getGoods_gallery() {
        return goods_gallery;
    }

    public void setGoods_gallery(List<GoodsGalleryBean> goods_gallery) {
        this.goods_gallery = goods_gallery;
    }

    public List<UserRankPricesBean> getUser_rank_prices() {
        return user_rank_prices;
    }

    public void setUser_rank_prices(List<UserRankPricesBean> user_rank_prices) {
        this.user_rank_prices = user_rank_prices;
    }

    public static class GoodsBean {
        /**
         * brand_id : 548
         * click_count : 78
         * give_integral : 8
         * goods_desc :
         * goods_name : 阿尔卑斯原味糖150g
         * goods_number : 100
         * goods_sn : 6911316400030
         * goods_weight : 0.150
         * integral : 0
         * is_promote : 0
         * is_real : 1
         * market_price : 8.80
         * promote_atr : 0
         * promote_end_date : 0
         * promote_price : 0.00
         * promote_start_date : 0
         * rank_integral : 8.8
         * service_phone :
         * shop_atr : 8.8
         * shop_logo :
         * shop_price : 8.8
         * shopname : 网站自营
         * supplier_id : 0
         * volume : []
         */

        private String brand_id;
        private String click_count;
        private int give_integral;
        private String goods_desc;
        private String goods_name;
        private String goods_number;
        private String goods_sn;
        private String goods_weight;
        private int integral;
        private String is_promote;
        private String is_real;
        private String market_price;
        private int promote_atr;
        private String promote_end_date;
        private String promote_price;
        private String promote_start_date;
        private double rank_integral;
        private String service_phone;
        private double shop_atr;
        private String shop_logo;
        private double shop_price;
        private String shopname;
        private String supplier_id;
        private List<?> volume;

        public String getBrand_id() {
            return brand_id;
        }

        public void setBrand_id(String brand_id) {
            this.brand_id = brand_id;
        }

        public String getClick_count() {
            return click_count;
        }

        public void setClick_count(String click_count) {
            this.click_count = click_count;
        }

        public int getGive_integral() {
            return give_integral;
        }

        public void setGive_integral(int give_integral) {
            this.give_integral = give_integral;
        }

        public String getGoods_desc() {
            return goods_desc;
        }

        public void setGoods_desc(String goods_desc) {
            this.goods_desc = goods_desc;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getGoods_number() {
            return goods_number;
        }

        public void setGoods_number(String goods_number) {
            this.goods_number = goods_number;
        }

        public String getGoods_sn() {
            return goods_sn;
        }

        public void setGoods_sn(String goods_sn) {
            this.goods_sn = goods_sn;
        }

        public String getGoods_weight() {
            return goods_weight;
        }

        public void setGoods_weight(String goods_weight) {
            this.goods_weight = goods_weight;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public String getIs_promote() {
            return is_promote;
        }

        public void setIs_promote(String is_promote) {
            this.is_promote = is_promote;
        }

        public String getIs_real() {
            return is_real;
        }

        public void setIs_real(String is_real) {
            this.is_real = is_real;
        }

        public String getMarket_price() {
            return market_price;
        }

        public void setMarket_price(String market_price) {
            this.market_price = market_price;
        }

        public int getPromote_atr() {
            return promote_atr;
        }

        public void setPromote_atr(int promote_atr) {
            this.promote_atr = promote_atr;
        }

        public String getPromote_end_date() {
            return promote_end_date;
        }

        public void setPromote_end_date(String promote_end_date) {
            this.promote_end_date = promote_end_date;
        }

        public String getPromote_price() {
            return promote_price;
        }

        public void setPromote_price(String promote_price) {
            this.promote_price = promote_price;
        }

        public String getPromote_start_date() {
            return promote_start_date;
        }

        public void setPromote_start_date(String promote_start_date) {
            this.promote_start_date = promote_start_date;
        }

        public double getRank_integral() {
            return rank_integral;
        }

        public void setRank_integral(double rank_integral) {
            this.rank_integral = rank_integral;
        }

        public String getService_phone() {
            return service_phone;
        }

        public void setService_phone(String service_phone) {
            this.service_phone = service_phone;
        }

        public double getShop_atr() {
            return shop_atr;
        }

        public void setShop_atr(double shop_atr) {
            this.shop_atr = shop_atr;
        }

        public String getShop_logo() {
            return shop_logo;
        }

        public void setShop_logo(String shop_logo) {
            this.shop_logo = shop_logo;
        }

        public double getShop_price() {
            return shop_price;
        }

        public void setShop_price(double shop_price) {
            this.shop_price = shop_price;
        }

        public String getShopname() {
            return shopname;
        }

        public void setShopname(String shopname) {
            this.shopname = shopname;
        }

        public String getSupplier_id() {
            return supplier_id;
        }

        public void setSupplier_id(String supplier_id) {
            this.supplier_id = supplier_id;
        }

        public List<?> getVolume() {
            return volume;
        }

        public void setVolume(List<?> volume) {
            this.volume = volume;
        }
    }

    public static class UseStorageBean {
    }

    public static class UserRankInfoBean {
    }

    public static class GoodsGalleryBean {
        /**
         * img_url : images/201508/goods_img/2781_P_1440495410706.jpg
         */

        private String img_url;

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }
    }

    public static class UserRankPricesBean {
        /**
         * price : ￥8.80
         * price_promote : ￥0
         * price_shop : ￥8.80
         * rank_id : 5
         * rank_name : 银牌会员
         * show_price : 0
         */

        private String price;
        private String price_promote;
        private String price_shop;
        private String rank_id;
        private String rank_name;
        private String show_price;

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPrice_promote() {
            return price_promote;
        }

        public void setPrice_promote(String price_promote) {
            this.price_promote = price_promote;
        }

        public String getPrice_shop() {
            return price_shop;
        }

        public void setPrice_shop(String price_shop) {
            this.price_shop = price_shop;
        }

        public String getRank_id() {
            return rank_id;
        }

        public void setRank_id(String rank_id) {
            this.rank_id = rank_id;
        }

        public String getRank_name() {
            return rank_name;
        }

        public void setRank_name(String rank_name) {
            this.rank_name = rank_name;
        }

        public String getShow_price() {
            return show_price;
        }

        public void setShow_price(String show_price) {
            this.show_price = show_price;
        }
    }
}
