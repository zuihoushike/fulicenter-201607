package app.cn.com.fulicenter.bean;

/**
 * Created by 最后时刻 on 2016/10/14.
 */
public class CategoryGood {
    private String id;
    private String goods_id;
    private String cat_id;
    private String goods_name;
    private String goods_english_name;
    private String goods_brief;
    private String shop_price;
    private String currency_price;
    private String promote_price;
    private String rank_price;
    private String is_promote;
    private String goods_thumb;
    private String goods_img;
    private String add_time;
    private String share_url;

    public CategoryGood(String add_time, String cat_id, String currency_price, String goods_brief, String goods_english_name, String goods_id, String goods_img, String goods_name, String goods_thumb, String id, String is_promote, String promote_price, String rank_price, String share_url, String shop_price) {
        this.add_time = add_time;
        this.cat_id = cat_id;
        this.currency_price = currency_price;
        this.goods_brief = goods_brief;
        this.goods_english_name = goods_english_name;
        this.goods_id = goods_id;
        this.goods_img = goods_img;
        this.goods_name = goods_name;
        this.goods_thumb = goods_thumb;
        this.id = id;
        this.is_promote = is_promote;
        this.promote_price = promote_price;
        this.rank_price = rank_price;
        this.share_url = share_url;
        this.shop_price = shop_price;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getCurrency_price() {
        return currency_price;
    }

    public void setCurrency_price(String currency_price) {
        this.currency_price = currency_price;
    }

    public String getGoods_brief() {
        return goods_brief;
    }

    public void setGoods_brief(String goods_brief) {
        this.goods_brief = goods_brief;
    }

    public String getGoods_english_name() {
        return goods_english_name;
    }

    public void setGoods_english_name(String goods_english_name) {
        this.goods_english_name = goods_english_name;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIs_promote() {
        return is_promote;
    }

    public void setIs_promote(String is_promote) {
        this.is_promote = is_promote;
    }

    public String getPromote_price() {
        return promote_price;
    }

    public void setPromote_price(String promote_price) {
        this.promote_price = promote_price;
    }

    public String getRank_price() {
        return rank_price;
    }

    public void setRank_price(String rank_price) {
        this.rank_price = rank_price;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getShop_price() {
        return shop_price;
    }

    public void setShop_price(String shop_price) {
        this.shop_price = shop_price;
    }

    @Override
    public String toString() {
        return "CategoryGood{" +
                "add_time='" + add_time + '\'' +
                ", id='" + id + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", cat_id='" + cat_id + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", goods_english_name='" + goods_english_name + '\'' +
                ", goods_brief='" + goods_brief + '\'' +
                ", shop_price='" + shop_price + '\'' +
                ", currency_price='" + currency_price + '\'' +
                ", promote_price='" + promote_price + '\'' +
                ", rank_price='" + rank_price + '\'' +
                ", is_promote='" + is_promote + '\'' +
                ", goods_thumb='" + goods_thumb + '\'' +
                ", goods_img='" + goods_img + '\'' +
                ", share_url='" + share_url + '\'' +
                '}';
    }
}
