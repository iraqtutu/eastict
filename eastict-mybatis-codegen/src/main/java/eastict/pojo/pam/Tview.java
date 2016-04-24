package eastict.pojo.pam;

public class Tview {
    private Long viewid;

    private String viewname;

    public Long getViewid() {
        return viewid;
    }

    public void setViewid(Long viewid) {
        this.viewid = viewid;
    }

    public String getViewname() {
        return viewname;
    }

    public void setViewname(String viewname) {
        this.viewname = viewname == null ? null : viewname.trim();
    }
}