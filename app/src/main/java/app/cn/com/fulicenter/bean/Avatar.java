package app.cn.com.fulicenter.bean;

/**
 * Created by 最后时刻 on 2016/10/14.
 */
public class Avatar {
    private String m_avatar_id;
    private String m_avatar_user_id;
    private String m_avatar_user_name;
    private String m_avatar_path;
    private String m_avatar_type;

    public Avatar(String m_avatar_id, String m_avatar_path, String m_avatar_type, String m_avatar_user_id, String m_avatar_user_name) {
        this.m_avatar_id = m_avatar_id;
        this.m_avatar_path = m_avatar_path;
        this.m_avatar_type = m_avatar_type;
        this.m_avatar_user_id = m_avatar_user_id;
        this.m_avatar_user_name = m_avatar_user_name;
    }

    public String getM_avatar_id() {
        return m_avatar_id;
    }

    public void setM_avatar_id(String m_avatar_id) {
        this.m_avatar_id = m_avatar_id;
    }

    public String getM_avatar_path() {
        return m_avatar_path;
    }

    public void setM_avatar_path(String m_avatar_path) {
        this.m_avatar_path = m_avatar_path;
    }

    public String getM_avatar_type() {
        return m_avatar_type;
    }

    public void setM_avatar_type(String m_avatar_type) {
        this.m_avatar_type = m_avatar_type;
    }

    public String getM_avatar_user_id() {
        return m_avatar_user_id;
    }

    public void setM_avatar_user_id(String m_avatar_user_id) {
        this.m_avatar_user_id = m_avatar_user_id;
    }

    public String getM_avatar_user_name() {
        return m_avatar_user_name;
    }

    public void setM_avatar_user_name(String m_avatar_user_name) {
        this.m_avatar_user_name = m_avatar_user_name;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "m_avatar_id='" + m_avatar_id + '\'' +
                ", m_avatar_user_id='" + m_avatar_user_id + '\'' +
                ", m_avatar_user_name='" + m_avatar_user_name + '\'' +
                ", m_avatar_path='" + m_avatar_path + '\'' +
                ", m_avatar_type='" + m_avatar_type + '\'' +
                '}';
    }
}
