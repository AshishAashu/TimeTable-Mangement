/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Use.EsConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;


@WebServlet(urlPatterns = {"/addteacher"})
public class addteacher extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
        Connection con=EsConnection.getConnection();
        String sql="insert into teacher values (?,?,?,?)";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1, req.getParameter("tid"));
        pst.setString(2, req.getParameter("tname").toUpperCase());
        pst.setString(3, req.getParameter("tdept").toUpperCase());
        pst.setString(4, req.getParameter("tadd").toUpperCase());
        pst.executeUpdate();
        //Statement st=con.createStatement();
        //sql="insert into department values('"+req.getParameter("tdept")+"')";
        //st.executeQuery(sql);
        //st.close();
        pst.close();
        resp.sendRedirect("welcome.jsp");
        }catch(Exception e){}
    }
    
}