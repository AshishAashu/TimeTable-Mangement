/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Use.ClassRoom;
import Use.EsConnection;
import Use.FinalTable;
import Use.Teacher;
import bean.Bean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AshishAashu
 */
@WebServlet(urlPatterns = {"/FinalTimeTable"})
public class FinalTimeTable extends HttpServlet {

    //@Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //public static void main(String[] args){
        Statement st=null;
        ResultSet rs;
        String sql;
        CourseAssign c = null;
        Teacher t=null;
        ClassRoom classroom=null;
        ArrayList<String> depts=new ArrayList();
        Bean bean=new Bean(); 
        int index[]={0,1,4},index1=0,index2=0,s,i1,totaltheory=0,teacherindex=0,classindex=0;
        ArrayList<CourseAssign> a=new ArrayList<CourseAssign>();
        ArrayList<Teacher> teachers=new ArrayList();
        ArrayList<ClassRoom> classrooms=new ArrayList<ClassRoom>();
        Connection con;
        for(int m=0;m<6;m++){
            for(int n=0;n<7;n++){
                FinalTable.ftable[m][n]=null;
            } 
        }
        try{
            con=EsConnection.getConnection();
            sql="select * from course";
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                a.add(new CourseAssign(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
                        rs.getString(6),rs.getString(7),rs.getString(8)));
                boolean f=false;
                for(int i=0;i<depts.size();i++){
                    if(depts.get(i).equals(rs.getString(5))){
                        f=true;
                        break;
                    }    
                }
                if(!f)
                    depts.add(rs.getString(5));
            }
        }catch(Exception e){}
        try{
            for(String d:depts){
                sql="select * from room where department='"+d+"'";
                rs=st.executeQuery(sql);
                while(rs.next()){
                    classrooms.add(new ClassRoom(rs.getString(1),rs.getString(2),rs.getString(3)));
                }
            }
        }catch(Exception e){}
        System.out.println(classrooms.size());
        for(ClassRoom cr:classrooms){
            
            System.out.println(cr.getRaf()+","+cr.getRdept()+","+cr.getRid());
        }
        for(s=0;s<a.size();s++){
            c=a.get(s);
            totaltheory+=Integer.parseInt(c.getTh());
            if(teachers.isEmpty()){
                teachers.add(new Teacher(c.getCteach()));
            }
            else{
                int find=0;
                for(Teacher t1:teachers){
                    if(t1.getTid().equals(c.getCteach())){
                        find=1;
                        break;
                    }
                }
                if(find==0){
                    teachers.add(new Teacher(c.getCteach()));
                }
            }
            /*int pract=Integer.parseInt(c.getPrt());
            if(pract!=0){
                index2=index[(int)(3*Math.random())];
                index1=(int)(6*Math.random());
                while(FinalTable.ftable[index1][index2]!=null&&FinalTable.ftable[index1][index2+1]!=null&&
                        FinalTable.ftable[index1][index2+2]!=null){
                    index2=index[(int)(3*Math.random())];
                    index1=(int)(6*Math.random());
                }
                
                FinalTable.ftable[index1][index2]=c.getCname()+",\n"+c.getCteach()+"\n(Practical)";
                FinalTable.ftable[index1][index2+1]="Previous";
                FinalTable.ftable[index1][index2+2]="Previous";
                c.setPrt(""+0);
                teachers.add(new Teacher(c.getCteach()));
            }*/
            
        }
        /*System.out.println(teachers.size());
        for(Teacher t1:teachers){
            System.out.println(t1.getTid());
        }*/
        for(s=0;s<a.size();s++){
            c=a.get(s);
            int flag=0;
            if(Integer.parseInt(c.getPrt())>0){
            for(Teacher t1:teachers){
                if(t1.getTid().equals(c.getCteach())){
                    t=t1;
                    System.out.println(t.getTid()+","+c.getCteach());
                }
            }
            for(ClassRoom cr:classrooms){
                if(cr.getRaf().equals("P")&&cr.getRdept().equals(c.getCdept())){
                    classroom=cr;
                }    
            }
                index2=index[(int)(3*Math.random())];
                index1=(int)(6*Math.random());
                while(flag==0){
                    if(index1==5&&index2>3){
                        index2=index[(int)(3*Math.random())];
                        index1=(int)(6*Math.random());
                        continue;
                    }
                        
                    else if(t.Teacherchart[index1][index2]==null&&t.Teacherchart[index1][index2+1]==null&&
                            t.Teacherchart[index1][index2+2]==null&&classroom.classchart[index1][index2]==null
                            &&classroom.classchart[index1][index2+1]==null&&classroom.classchart[index1][index2+2]==null&&
                            FinalTable.ftable[index1][index2]==null&&FinalTable.ftable[index1][index2+1]==null&&
                            FinalTable.ftable[index1][index2+2]==null){
                        classroom.classchart[index1][index2]=c.getCname()+","+c.getBrname()+","+c.getCteach()+","+c.getYear()+","+"(Lab)";
                        classroom.classchart[index1][index2+1]="(Lab)";
                        classroom.classchart[index1][index2+2]="(Lab)";    
                        t.Teacherchart[index1][index2]=c.getBrname()+","+c.getYear()+","+c.getCname()+","+classroom.getRid();
                        t.Teacherchart[index1][index2+1]="(Lab)";
                        t.Teacherchart[index1][index2+2]="(Lab)";
                        FinalTable.ftable[index1][index2]=c.getCname()+","+c.getCteach()+","+classroom.getRid()+","+"(Lab)";
                        FinalTable.ftable[index1][index2+1]="(Lab)";
                        FinalTable.ftable[index1][index2+2]="(Lab)";        
                        flag=1;
                    }
                    else{
                        index2=index[(int)(3*Math.random())];
                        index1=(int)(6*Math.random());
                    }
                }
            }
        }            
        while(!a.isEmpty()){
            c=a.get((int)(a.size()*Math.random()));
            if(c.getTh().equals("0")){
                a.remove(c);
                continue;
            }
            int flag=0;
            if(Integer.parseInt(c.getTh())>0){
                for(Teacher t1:teachers){
                    if(t1.getTid().equals(c.getCteach())){
                        t=t1;
                        //System.out.println(t.getTid()+","+c.getCteach());
                    }
                }
                /*for(ClassRoom cr:classrooms){
                    if(cr.getRaf().equals("T")&&cr.getRdept().equals(c.getCdept())){
                        classroom=cr;
                    }    
                }*/
                ClassRoom cr=classrooms.get((int)(classrooms.size()*Math.random()));
                while(flag==0){
                    if(cr.getRaf().equals("T")&&cr.getRdept().equals(c.getCdept())){
                        classroom=cr;
                        System.out.println("g:"+cr.getRaf()+","+cr.getRdept()+","+c.getCdept());
                        flag=1;
                    }
                    else{
                        cr=classrooms.get((int)(classrooms.size()*Math.random()));
                    }
                }
            }
            else{
                continue;
            }
            flag=0;
            index2=(int)(7*Math.random());
            index1=(int)(6*Math.random());
            while(flag==0){
                if(index1==5&&index2>3){
                    index2=(int)(7*Math.random());
                    index1=(int)(6*Math.random());
                    continue;
                }
                        
                else if(t.Teacherchart[index1][index2]==null&&classroom.classchart[index1][index2]==null&&
                        FinalTable.ftable[index1][index2]==null){
                    classroom.classchart[index1][index2]=c.getCname()+","+c.getBrname()+","+c.getCteach()+","+c.getYear();
                    t.Teacherchart[index1][index2]=c.getBrname()+","+c.getYear()+","+c.getCname()+","+classroom.getRid();
                    FinalTable.ftable[index1][index2]=c.getCname()+",\n"+c.getCteach()+","+classroom.getRid()+"(Theory)";
                    flag=1;
                    c.setTh(""+(Integer.parseInt(c.getTh())-1));
                
                }
                else{
                    if(index2<6){
                        ++index2;
                    } 
                    else{
                        index2=(int)(7*Math.random());
                        index1=(int)(6*Math.random());
                    }
                }
            }
            /*FinalTable.ftable[index1][index2]=c.getCname()+",\n"+c.getCteach()+"\n";
            --totaltheory;
            c.setTh(""+(Integer.parseInt(c.getTh())-1));
            boolean find=false;
                for (Teacher teacher: teachers) {
                    if(teacher.getTid().equals(c.getCteach())){
                        find=true;
                        t=teacher;
                        break;
                    }                    
                }
                if(find){
                    t.Teacherchart[index1][index2]=c.getBrname()+","+c.getYear()+","+c.getCname();
                }
                else{
                    t=new Teacher(c.getCteach());
                    t.Teacherchart[index1][index2]=c.getBrname()+","+c.getYear()+","+c.getCname();
                    teachers.add(t);
                }
            } */
        }
        /*for(int m=0;m<6;m++){
            for(int n=0;n<7;n++){
                System.out.print(FinalTable.ftable[m][n]+" ");
            }
            System.out.println("\n");
        }
        System.out.println(teachers.size());
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getTid());
            
        }*/
        bean.setT(teachers);
        bean.setC(classrooms);
        HttpSession session=req.getSession();
        session.setAttribute("teacherbean", bean);
        session.setAttribute("classbean", bean);
        resp.sendRedirect("FinalTimeTablejsp.jsp");
    }
    
}
