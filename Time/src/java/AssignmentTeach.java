
import java.util.ArrayList;
import Use.*;
import java.sql.*;
public class AssignmentTeach {
    public static void main(String args[]){
        CourseAssign c = null;
        int index[]={1,2,4},index1=0,index2=0,s,i1,totaltheory=0;
        ArrayList<CourseAssign> a=new ArrayList<CourseAssign>();
        Connection con;
        try{
            con=EsConnection.getConnection();
            String sql="select * from course";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                a.add(new CourseAssign(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        }catch(Exception e){}
        for(s=0;s<a.size();s++){
            c=a.get(s);
            totaltheory+=Integer.parseInt(c.getTh());
            int pract=Integer.parseInt(c.getPrt());
            if(pract!=0){
                index2=index[(int)(3*Math.random())];
                index1=(int)(6*Math.random());
                while(FinalTable.ftable[index1][index2]!=null&&FinalTable.ftable[index1][index2+1]!=null&&
                        FinalTable.ftable[index1][index2+2]!=null){
                    index2=index[(int)(3*Math.random())];
                    index1=(int)(6*Math.random());
                }
                FinalTable.ftable[index1][index2]=c.getBrname()+"\n"+c.getYear()+"\n"+c.getCname()+"\n"+c.getCteach()+"\n";
                FinalTable.ftable[index1][index2+1]="Previous";
                FinalTable.ftable[index1][index2+2]="Previous";
                c.setPrt(""+0);
            }      
        }
        while(totaltheory!=0){
            c=a.get((int)(a.size()*Math.random()));
            if(Integer.parseInt(c.getTh())>0){
            index1=(int)(6*Math.random());
            index2=(int)(7*Math.random());
            while(FinalTable.ftable[index1][index2]!=null){
                index2=(int)(7*Math.random());
                index1=(int)(6*Math.random());
            }
            FinalTable.ftable[index1][index2]=c.getBrname()+"\n"+c.getYear()+"\n"+c.getCname()+"\n"+c.getCteach()+"\n";
            --totaltheory;
            c.setTh(""+(Integer.parseInt(c.getTh())-1));
            }
            else
                continue;
        }
        for(int m=0;m<6;m++){
            for(int n=0;n<7;n++){
                System.out.print(FinalTable.ftable[m][n]+" ");
            }
            System.out.println("\n");
        }
    }
}
