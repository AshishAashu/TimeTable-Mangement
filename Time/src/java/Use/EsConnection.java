package Use;


import java.sql.Connection;
import java.sql.DriverManager;


public class EsConnection {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin://@localhost:1521:XE","ashish","ashish");
         }catch(Exception e){}
        return con;
    }
    
}
