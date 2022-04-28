

package percobaan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    public static Connection mysqlconfig;
   public static Connection koneksi()throws SQLException{    
       try{
           String url="jdbc:mysql://localhost:3306/atk";
           String user="root";
           String pass ="";
           DriverManager.registerDriver(new com.mysql.jdbc.Driver());
           mysqlconfig=DriverManager.getConnection(url, user, pass);
       }catch (Exception e){
           System.err.println("Koneksi Gagal"+e.getMessage());
       }
       return mysqlconfig;
   }
}
