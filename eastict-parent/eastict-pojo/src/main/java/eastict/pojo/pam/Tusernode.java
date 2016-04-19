package eastict.pojo.pam;

public class Tusernode {
    private Long viewid;

    private Long nodeid;

    private String userid;

    public Long getViewid() {
        return viewid;
    }

    public void setViewid(Long viewid) {
        this.viewid = viewid;
    }

    public Long getNodeid() {
        return nodeid;
    }

    public void setNodeid(Long nodeid) {
        this.nodeid = nodeid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}