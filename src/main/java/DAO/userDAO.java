package DAO;

import Bean.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class userDAO {
    private static InputStream is;
    private static Properties properties;
    static{
        is = userDAO.class.getClassLoader().getResourceAsStream("mysqlConfig.properties");
        properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<User> RetrieveAll(){
        String sql = "select * from userInfo";
        List<User> users = new ArrayList<User>();

        try(Connection conn = getConnection();PreparedStatement pstm = conn.prepareStatement(sql)){
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                User user = new User(rs.getString(2), rs.getString(3));
                users.add(user);
            }
            return users;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
