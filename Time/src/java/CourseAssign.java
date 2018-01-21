public class CourseAssign {
    public String[][] coursetable={{null,null,null,null,null,null,null},{null,null,null,null,null,null,null},{null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null},{null,null,null,null,null,null,null},{null,null,null,null,null,null,null}};
    String cid,cname,brname,year,cdept,cteach,th,prt;
    CourseAssign(String a,String b,String c,String d,String e,String f,String g,String h){
        this.cid=a;
        this.cname=b;
        this.brname=c;
        this.year=d;
        this.cdept=e;
        this.cteach=f;
        this.th=g;
        this.prt=h;
    }

    public String getCid() {
        return cid;
    }

    public void setTh(String th) {
        this.th = th;
    }

    public void setPrt(String prt) {
        this.prt = prt;
    }

    public String getCname() {
        return cname;
    }

    public String getBrname() {
        return brname;
    }

    public String getYear() {
        return year;
    }

    public String getCdept() {
        return cdept;
    }

    public String getCteach() {
        return cteach;
    }

    public String getTh() {
        return th;
    }

    public String getPrt() {
        return prt;
    }
}
