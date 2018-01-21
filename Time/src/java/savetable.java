/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Use.ClassRoom;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Use.FinalTable;
import Use.Teacher;
import bean.Bean;
import java.io.File;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
/**
 *
 * @author AshishAashu
 */
@WebServlet(urlPatterns = {"/savetable"})
public class savetable extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw=resp.getWriter();
        HttpSession ses=req.getSession();
        Bean bean=(Bean)ses.getAttribute("teacherbean");
        ArrayList<Teacher> teachers=bean.getT();
        ArrayList<ClassRoom> classrooms=bean.getC();
        /*for(int m=0;m<6;m++){
            for(int n=0;n<7;n++){
                pw.println(FinalTable.ftable[m][n]);
            } 
        }*/
        try{
        WritableWorkbook wb=Workbook.createWorkbook(new File("C:\\Users\\AshishAashu\\Desktop\\TimeTable\\MasterChart\\TimeTable.xls"));
        WritableSheet excelSheet = wb.createSheet("Sheet 1", 0);
        WritableCellFormat wcf=new WritableCellFormat();
        WritableFont f1=new WritableFont(WritableFont.COURIER, 14,WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE);
        wcf.setFont(f1);
        Label l1=new Label(0,0,"Day",wcf);
        Label l2=new Label(0,1,"Monday",wcf);
        Label l3=new Label(0,2,"Tuesday",wcf);
        Label l4=new Label(0,3,"Wednesday",wcf);
        Label l5=new Label(0,4,"Thurshday",wcf);
        Label l6=new Label(0,5,"Friday",wcf);
        Label l7=new Label(0,6,"Sturday",wcf);
        for(int m=0;m<6;m++){
            for(int n=0;n<7;n++){
                if(FinalTable.ftable[m][n]==null)
                    excelSheet.addCell(new Label(n+1,m+1,"--------------",wcf));
                else
                excelSheet.addCell(new Label(n+1,m+1,FinalTable.ftable[m][n],wcf));
            } 
        }
        excelSheet.addCell(l1);
        excelSheet.addCell(l2);
        excelSheet.addCell(l3);
        excelSheet.addCell(l4);
        excelSheet.addCell(l5);
        excelSheet.addCell(l6);
        excelSheet.addCell(l7);
            wb.write();
            wb.close();
            for(Teacher teacher:teachers){
                wb=Workbook.createWorkbook(new File("C:\\Users\\AshishAashu\\Desktop\\TimeTable\\TeacherChart\\"+teacher.getTid()+".xls"));
                excelSheet = wb.createSheet("Sheet 1", 0);
                l1=new Label(0,0,"Day",wcf);
                l2=new Label(0,1,"Monday",wcf);
                l3=new Label(0,2,"Tuesday",wcf);
                l4=new Label(0,3,"Wednesday",wcf);
                l5=new Label(0,4,"Thurshday",wcf);
                l6=new Label(0,5,"Friday",wcf);
                l7=new Label(0,6,"Sturday",wcf);
                for(int m=0;m<6;m++){
                    for(int n=0;n<7;n++){
                        if(teacher.Teacherchart[m][n]==null)
                            excelSheet.addCell(new Label(n+1,m+1,"--------------",wcf));
                        else
                            excelSheet.addCell(new Label(n+1,m+1,teacher.Teacherchart[m][n],wcf));
                    } 
                }
                excelSheet.addCell(l1);
                excelSheet.addCell(l2);
                excelSheet.addCell(l3);
                excelSheet.addCell(l4);
                excelSheet.addCell(l5);
                excelSheet.addCell(l6);
                excelSheet.addCell(l7);
                wb.write();
                wb.close();
            }
            for(ClassRoom classroom:classrooms){
                wb=Workbook.createWorkbook(new File("C:\\Users\\AshishAashu\\Desktop\\TimeTable\\ClassRoomChart\\"+classroom.getRid()+".xls"));
                excelSheet = wb.createSheet("Sheet 1", 0);
                l1=new Label(0,0,"Day",wcf);
                l2=new Label(0,1,"Monday",wcf);
                l3=new Label(0,2,"Tuesday",wcf);
                l4=new Label(0,3,"Wednesday",wcf);
                l5=new Label(0,4,"Thurshday",wcf);
                l6=new Label(0,5,"Friday",wcf);
                l7=new Label(0,6,"Sturday",wcf);
                for(int m=0;m<6;m++){
                    for(int n=0;n<7;n++){
                        if(classroom.classchart[m][n]==null)
                            excelSheet.addCell(new Label(n+1,m+1,"--------------",wcf));
                        else
                            excelSheet.addCell(new Label(n+1,m+1,classroom.classchart[m][n],wcf));
                    } 
                }
                excelSheet.addCell(l1);
                excelSheet.addCell(l2);
                excelSheet.addCell(l3);
                excelSheet.addCell(l4);
                excelSheet.addCell(l5);
                excelSheet.addCell(l6);
                excelSheet.addCell(l7);
                wb.write();
                wb.close();
            }
        }catch(Exception e){}
        pw.print("Data Saved.");
    }

    
}
