
package Use;

public class Teacher {
    public String[][] Teacherchart={{null,null,null,null,null,null,null},{null,null,null,null,null,null,null},{null,null,null,null,null,null,null},
        {null,null,null,null,null,null,null},{null,null,null,null,null,null,null},{null,null,null,null,null,null,null}};
    public  String tid,brname,year,courseid,coursename,dept;

    public Teacher(String tid) {
        this.tid=tid;
    }

    public String getTid() {
        return this.tid;
    }
    
}
