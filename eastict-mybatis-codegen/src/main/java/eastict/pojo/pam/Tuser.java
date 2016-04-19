package eastict.pojo.pam;

import java.util.Date;

public class Tuser {
    private String userid;

    private String logonname;

    private String displayname;

    private String pwdmd5;

    private Date createtime;

    private Boolean enabled;

    private String pictureurl;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getLogonname() {
        return logonname;
    }

    public void setLogonname(String logonname) {
        this.logonname = logonname == null ? null : logonname.trim();
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname == null ? null : displayname.trim();
    }

    public String getPwdmd5() {
        return pwdmd5;
    }

    public void setPwdmd5(String pwdmd5) {
        this.pwdmd5 = pwdmd5 == null ? null : pwdmd5.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl == null ? null : pictureurl.trim();
    }
}