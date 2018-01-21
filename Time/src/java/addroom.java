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
@WebServlet(urlPatterns = {"/addroom"})
public class addroom extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try{
        Connection con=EsConnection.getConnection();
        String sql="insert into room values (?,?,?)";
        PreparedStatement pst=con.prepareStatement(sql);
        pst.setString(1, req.getParameter("roomid"));
        pst.setString(2, req.getParameter("rdept"));
        pst.setString(3, req.getParameter("af"));
        pst.executeUpdate();
        pst.close();
        resp.sendRedirect("welcome.jsp");
        }catch(Exception e){} 
    }
    
}
