package app.cn.com.fulicenter.bean;

/**
 * Created by xiaomiao on 2016/10/14.
 */
public class ColorBean {
    private int colorId;
    private String colorName;
    private String colorCode;
    private String colorUrl;

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getColorUrl() {
        return colorUrl;
    }

    public void setColorUrl(String colorUrl) {
        this.colorUrl = colorUrl;
    }

    public ColorBean() {
    }

    @Override
    public String toString() {
        return "ColorBean{" +
                "colorId=" + colorId +
                ", colorName='" + colorName + '\'' +
                ", colorCode='" + colorCode + '\'' +
                ", colorUrl='" + colorUrl + '\'' +
                '}';
    }
}
