package app.cn.com.fulicenter.bean;

/**
 * Created by 最后时刻 on 2016/10/14.
 */
public class Property {
    private String id;
    private String goods_id;
    private String colorid;
    private String colorname;
    private String colorcode;
    private String colorimg;
    private String colorurl;

    public Property(String colorcode, String colorid, String colorimg, String colorname, String colorurl, String goods_id, String id) {
        this.colorcode = colorcode;
        this.colorid = colorid;
        this.colorimg = colorimg;
        this.colorname = colorname;
        this.colorurl = colorurl;
        this.goods_id = goods_id;
        this.id = id;
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode;
    }

    public String getColorid() {
        return colorid;
    }

    public void setColorid(String colorid) {
        this.colorid = colorid;
    }

    public String getColorimg() {
        return colorimg;
    }

    public void setColorimg(String colorimg) {
        this.colorimg = colorimg;
    }

    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname;
    }

    public String getColorurl() {
        return colorurl;
    }

    public void setColorurl(String colorurl) {
        this.colorurl = colorurl;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Property{" +
                "colorcode='" + colorcode + '\'' +
                ", id='" + id + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", colorid='" + colorid + '\'' +
                ", colorname='" + colorname + '\'' +
                ", colorimg='" + colorimg + '\'' +
                ", colorurl='" + colorurl + '\'' +
                '}';
    }
}
