package app.cn.com.fulicenter.bean;

/**
 * Created by 最后时刻 on 2016/10/14.
 */
public class User {
    private String m_user_id;
    private String m_user_name;
    private String m_user_password;
    private String m_user_nick;
    private String m_user_unread_msg_count;

    public User(String m_user_id, String m_user_name, String m_user_nick, String m_user_password, String m_user_unread_msg_count) {
        this.m_user_id = m_user_id;
        this.m_user_name = m_user_name;
        this.m_user_nick = m_user_nick;
        this.m_user_password = m_user_password;
        this.m_user_unread_msg_count = m_user_unread_msg_count;
    }

    public String getM_user_id() {
        return m_user_id;
    }

    public void setM_user_id(String m_user_id) {
        this.m_user_id = m_user_id;
    }

    public String getM_user_name() {
        return m_user_name;
    }

    public void setM_user_name(String m_user_name) {
        this.m_user_name = m_user_name;
    }

    public String getM_user_nick() {
        return m_user_nick;
    }

    public void setM_user_nick(String m_user_nick) {
        this.m_user_nick = m_user_nick;
    }

    public String getM_user_password() {
        return m_user_password;
    }

    public void setM_user_password(String m_user_password) {
        this.m_user_password = m_user_password;
    }

    public String getM_user_unread_msg_count() {
        return m_user_unread_msg_count;
    }

    public void setM_user_unread_msg_count(String m_user_unread_msg_count) {
        this.m_user_unread_msg_count = m_user_unread_msg_count;
    }

    @Override
    public String toString() {
        return "User{" +
                "m_user_id='" + m_user_id + '\'' +
                ", m_user_name='" + m_user_name + '\'' +
                ", m_user_password='" + m_user_password + '\'' +
                ", m_user_nick='" + m_user_nick + '\'' +
                ", m_user_unread_msg_count='" + m_user_unread_msg_count + '\'' +
                '}';
    }
}
