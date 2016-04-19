package eastict.pojo.pam;

public class Tapp {
    private Long appid;

    private Long viewid;

    private String appname;

    private String description;

    public Long getAppid() {
        return appid;
    }

    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public Long getViewid() {
        return viewid;
    }

    public void setViewid(Long viewid) {
        this.viewid = viewid;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname == null ? null : appname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}