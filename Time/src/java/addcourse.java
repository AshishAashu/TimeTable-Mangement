/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Use.EsConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AshishAashu
 */
@WebServlet(urlPatterns = {"/addcourse"})
public class addcourse extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
        Connection con=EsConnection.getConnection();
        String sql="insert into course values (?,?,?,?,?,?,?,?)";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1, req.getParameter("Cid"));
        pst.setString(2, req.getParameter("Cname").toUpperCase());
        pst.setString(3, req.getParameter("brname"));
        pst.setString(4, req.getParameter("Cy"));
        pst.setString(5, req.getParameter("Cdept").toUpperCase());
        pst.setString(6, req.getParameter("Cteach").toUpperCase());
        pst.setString(7, req.getParameter("theory"));
        pst.setString(8, req.getParameter("practicals"));
        pst.executeUpdate();
        pst.close();
        PrintWriter pw=resp.getWriter();
        pw.println("<script>alert('Course Added');</script>");
        resp.sendRedirect("welcome.jsp");
        }catch(Exception e){}
    }
   
}
