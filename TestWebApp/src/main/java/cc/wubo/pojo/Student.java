package cc.wubo.pojo;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private String no;

    private String sname;

    private Date sage;

    private String ssex;

    private static final long serialVersionUID = 1L;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public Date getSage() {
        return sage;
    }

    public void setSage(Date sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex == null ? null : ssex.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", no=").append(no);
        sb.append(", sname=").append(sname);
        sb.append(", sage=").append(sage);
        sb.append(", ssex=").append(ssex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}