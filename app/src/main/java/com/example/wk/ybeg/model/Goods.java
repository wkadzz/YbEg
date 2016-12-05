package com.example.wk.ybeg.model;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by WK on 2016/12/1.
 */
@Table(name = "goods")
public class Goods {

    /**
     * add_time : 2016-01-19 03:01
     * click_count : 160
     * goods_brief :
     * goods_id : 3184
     * goods_name : 徐福记1250新年糖
     * goods_thumb : images/201601/thumb_img/3184_thumb_G_1453172679494.jpg
     * is_best : 1
     * is_hot : 1
     * is_new : 1
     * is_promote : 0
     * promote_end_date : 0
     * promote_price : 0.00
     * promote_start_date : 0
     * shop_price : 55.00
     */
    @Column(name = "add_time")
    private String add_time;
    @Column(name = "click_count")
    private String click_count;
    @Column(name = "goods_brief")
    private String goods_brief;
    @Column(name = "id" ,isId = true,autoGen = false)
    private String goods_id;
    @Column(name = "goods_name")
    private String goods_name;
    @Column(name = "goods_thumb")
    private String goods_thumb;
    @Column(name = "is_best")
    private String is_best;
    @Column(name = "is_hot")
    private String is_hot;
    @Column(name = "is_new")
    private String is_new;
    @Column(name = "is_promote")
    private String is_promote;
    @Column(name = "promote_end_date")
    private String promote_end_date;
    @Column(name = "promote_price")
    private String promote_price;
    @Column(name = "promote_start_date")
    private String promote_start_date;
    @Column(name = "shop_price")
    private String shop_price;

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getClick_count() {
        return click_count;
    }

    public void setClick_count(String click_count) {
        this.click_count = click_count;
    }

    public String getGoods_brief() {
        return goods_brief;
    }

    public void setGoods_brief(String goods_brief) {
        this.goods_brief = goods_brief;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_thumb() {
        return goods_thumb;
    }

    public void setGoods_thumb(String goods_thumb) {
        this.goods_thumb = goods_thumb;
    }

    public String getIs_best() {
        return is_best;
    }

    public void setIs_best(String is_best) {
        this.is_best = is_best;
    }

    public String getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(String is_hot) {
        this.is_hot = is_hot;
    }

    public String getIs_new() {
        return is_new;
    }

    public void setIs_new(String is_new) {
        this.is_new = is_new;
    }

    public String getIs_promote() {
        return is_promote;
    }

    public void setIs_promote(String is_promote) {
        this.is_promote = is_promote;
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

    public String getShop_price() {
        return shop_price;
    }

    public void setShop_price(String shop_price) {
        this.shop_price = shop_price;
    }
}
