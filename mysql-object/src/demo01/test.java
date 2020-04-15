package demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/wrok";
            String user = "root";
            String password = "static";
            Connection connection = DriverManager.getConnection(url,user,password);

            Statement statement = connection.createStatement();
            String sql = "delete from staff where staff_name= '刘大大'";

            int rows = statement.executeUpdate(sql);
            System.out.println(rows);
            if (rows>0){
                System.out.println("删除成功");
            }else{
                System.out.println("更新失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
