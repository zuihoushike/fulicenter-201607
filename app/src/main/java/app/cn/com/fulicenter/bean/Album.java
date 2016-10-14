package app.cn.com.fulicenter.bean;

/**
 * Created by 最后时刻 on 2016/10/14.
 */
public class Album {
    private String id;
    private String pid;
    private String img_id;
    private String img_url;
    private String thumb_url;
    private String img_desc;

    public Album(String id, String img_desc, String img_id, String img_url, String pid, String thumb_url) {
        this.id = id;
        this.img_desc = img_desc;
        this.img_id = img_id;
        this.img_url = img_url;
        this.pid = pid;
        this.thumb_url = thumb_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg_desc() {
        return img_desc;
    }

    public void setImg_desc(String img_desc) {
        this.img_desc = img_desc;
    }

    public String getImg_id() {
        return img_id;
    }

    public void setImg_id(String img_id) {
        this.img_id = img_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", img_id='" + img_id + '\'' +
                ", img_url='" + img_url + '\'' +
                ", thumb_url='" + thumb_url + '\'' +
                ", img_desc='" + img_desc + '\'' +
                '}';
    }
}
