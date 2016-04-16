package eastict.pam.pojo;

public class Tfunction {
    private Long funcid;

    private Long appid;

    private String funceame;

    private String funccnname;

    private String description;

    private Boolean isgroup;

    private Long parentid;

    public Long getFuncid() {
        return funcid;
    }

    public void setFuncid(Long funcid) {
        this.funcid = funcid;
    }

    public Long getAppid() {
        return appid;
    }

    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public String getFunceame() {
        return funceame;
    }

    public void setFunceame(String funceame) {
        this.funceame = funceame == null ? null : funceame.trim();
    }

    public String getFunccnname() {
        return funccnname;
    }

    public void setFunccnname(String funccnname) {
        this.funccnname = funccnname == null ? null : funccnname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getIsgroup() {
        return isgroup;
    }

    public void setIsgroup(Boolean isgroup) {
        this.isgroup = isgroup;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }
}