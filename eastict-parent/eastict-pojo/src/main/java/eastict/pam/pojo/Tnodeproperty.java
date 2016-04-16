package eastict.pam.pojo;

public class Tnodeproperty {
    private Long propertyid;

    private Long nodeid;

    private String propertyname;

    private String propertyvalue;

    public Long getPropertyid() {
        return propertyid;
    }

    public void setPropertyid(Long propertyid) {
        this.propertyid = propertyid;
    }

    public Long getNodeid() {
        return nodeid;
    }

    public void setNodeid(Long nodeid) {
        this.nodeid = nodeid;
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname == null ? null : propertyname.trim();
    }

    public String getPropertyvalue() {
        return propertyvalue;
    }

    public void setPropertyvalue(String propertyvalue) {
        this.propertyvalue = propertyvalue == null ? null : propertyvalue.trim();
    }
}