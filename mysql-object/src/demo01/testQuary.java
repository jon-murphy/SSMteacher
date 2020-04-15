package demo01;

import java.sql.*;

public class testQuary {
    public static void main(String[] args) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/wrok";
            String user="root";
            String password="static";
            connection = DriverManager.getConnection(url, user, password);


            statement = connection.createStatement();


            String sql = "select * from staff";


            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString("staff_name");
                int num = resultSet.getInt("staff_id");
                System.out.println(id + "-" + name + "-" + num);

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                } finally {
                    try {
                        if (statement != null) {
                            statement.close();
                        }
                    } finally {
                        try {
                            if (connection != null) {
                                connection.close();
                            }
                        } finally {

                        }
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
