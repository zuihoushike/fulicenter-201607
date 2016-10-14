package app.cn.com.fulicenter.bean;

/**
 * Created by 最后时刻 on 2016/10/14.
 */
public class NewAndBoutiqueGoods {
    private String cat_id;
    private String color_id;
    private String color_name;
    private String color_code;
    private String color_url;

    public NewAndBoutiqueGoods(String cat_id, String color_code, String color_id, String color_name, String color_url) {
        this.cat_id = cat_id;
        this.color_code = color_code;
        this.color_id = color_id;
        this.color_name = color_name;
        this.color_url = color_url;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getColor_code() {
        return color_code;
    }

    public void setColor_code(String color_code) {
        this.color_code = color_code;
    }

    public String getColor_id() {
        return color_id;
    }

    public void setColor_id(String color_id) {
        this.color_id = color_id;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public String getColor_url() {
        return color_url;
    }

    public void setColor_url(String color_url) {
        this.color_url = color_url;
    }

    @Override
    public String toString() {
        return "NewAndBoutiqueGoods{" +
                "cat_id='" + cat_id + '\'' +
                ", color_id='" + color_id + '\'' +
                ", color_name='" + color_name + '\'' +
                ", color_code='" + color_code + '\'' +
                ", color_url='" + color_url + '\'' +
                '}';
    }
}
