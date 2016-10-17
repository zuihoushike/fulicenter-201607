package app.cn.com.fulicenter.bean;

/**
 * Created by 最后时刻 on 2016/10/14.
 */
public class Contact{
    private String m_contact_id;
    private String m_contact_user_id;
    private String m_contact_user_name;
    private String m_contact_cid;
    private String m_contact_cname;

    public Contact(String m_contact_cid, String m_contact_cname, String m_contact_id, String m_contact_user_id, String m_contact_user_name) {
        this.m_contact_cid = m_contact_cid;
        this.m_contact_cname = m_contact_cname;
        this.m_contact_id = m_contact_id;
        this.m_contact_user_id = m_contact_user_id;
        this.m_contact_user_name = m_contact_user_name;
    }

    public String getM_contact_cid() {
        return m_contact_cid;
    }

    public void setM_contact_cid(String m_contact_cid) {
        this.m_contact_cid = m_contact_cid;
    }

    public String getM_contact_cname() {
        return m_contact_cname;
    }

    public void setM_contact_cname(String m_contact_cname) {
        this.m_contact_cname = m_contact_cname;
    }

    public String getM_contact_id() {
        return m_contact_id;
    }

    public void setM_contact_id(String m_contact_id) {
        this.m_contact_id = m_contact_id;
    }

    public String getM_contact_user_id() {
        return m_contact_user_id;
    }

    public void setM_contact_user_id(String m_contact_user_id) {
        this.m_contact_user_id = m_contact_user_id;
    }

    public String getM_contact_user_name() {
        return m_contact_user_name;
    }

    public void setM_contact_user_name(String m_contact_user_name) {
        this.m_contact_user_name = m_contact_user_name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "m_contact_cid='" + m_contact_cid + '\'' +
                ", m_contact_id='" + m_contact_id + '\'' +
                ", m_contact_user_id='" + m_contact_user_id + '\'' +
                ", m_contact_user_name='" + m_contact_user_name + '\'' +
                ", m_contact_cname='" + m_contact_cname + '\'' +
                '}';
    }
}
