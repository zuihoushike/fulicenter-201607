package app.cn.com.fulicenter.bean;

/**
 * Created by 最后时刻 on 2016/10/14.
 */
public class Collect {
    private String id;
    private String goods_id;
    private String userName;
    private String goodsName;
    private String goodsEnglishName;
    private String goodsThumb;
    private String goodsImg;
    private String addTime;

    public Collect(String addTime, String goods_id, String goodsEnglishName, String goodsImg, String goodsName, String goodsThumb, String id, String userName) {
        this.addTime = addTime;
        this.goods_id = goods_id;
        this.goodsEnglishName = goodsEnglishName;
        this.goodsImg = goodsImg;
        this.goodsName = goodsName;
        this.goodsThumb = goodsThumb;
        this.id = id;
        this.userName = userName;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoodsEnglishName() {
        return goodsEnglishName;
    }

    public void setGoodsEnglishName(String goodsEnglishName) {
        this.goodsEnglishName = goodsEnglishName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "addTime='" + addTime + '\'' +
                ", id='" + id + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", userName='" + userName + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsEnglishName='" + goodsEnglishName + '\'' +
                ", goodsThumb='" + goodsThumb + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                '}';
    }
}
