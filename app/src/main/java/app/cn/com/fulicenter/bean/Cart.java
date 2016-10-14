package app.cn.com.fulicenter.bean;

/**
 * Created by 最后时刻 on 2016/10/14.
 */
public class Cart {
    private String id;
    private String goods_id;
    private String goodsThumb;
    private String userName;
    private String count;
    private String isChecked;

    public Cart(String count, String goods_id, String goodsThumb, String id, String isChecked, String userName) {
        this.count = count;
        this.goods_id = goods_id;
        this.goodsThumb = goodsThumb;
        this.id = id;
        this.isChecked = isChecked;
        this.userName = userName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoodsThumb() {
        return goodsThumb;
    }

    public void setGoodsThumb(String goodsThumb) {
        this.goodsThumb = goodsThumb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "count='" + count + '\'' +
                ", id='" + id + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", goodsThumb='" + goodsThumb + '\'' +
                ", userName='" + userName + '\'' +
                ", isChecked='" + isChecked + '\'' +
                '}';
    }
}
