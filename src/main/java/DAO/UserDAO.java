package DAO;

import model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    
    public UserDAO(){
    }

       public void createTable() throws SQLException {
        Statement stmt= DBHelper.getConnection().createStatement();
        stmt.execute("create table if not exists user_db (id bigint auto_increment, name varchar(256),primary key(id))");
        stmt.close();
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> res = new ArrayList<>();
        Statement stmt = DBHelper.getConnection().createStatement();
        stmt.execute("select*from user_db");
        ResultSet resultSet = stmt.getResultSet();

        while (resultSet.next()) {
            res.add(new User(resultSet.getLong(1), resultSet.getString(2)));
        }
        stmt.close();
        return res;
    }

    public void addUser(User user) throws SQLException {
        PreparedStatement pstmt = DBHelper.getConnection().prepareStatement("insert into user_db set name=(?)");
        pstmt.setString(1,user.getName());
        pstmt.execute();
        pstmt.close();
    }

    public void updateUser(String name, Long id) throws SQLException {
        PreparedStatement pstmt=DBHelper.getConnection().prepareStatement("Update user_db set name=(?) where id=(?)");
        pstmt.setString(1,name);
        pstmt.setLong(2,id);
        pstmt.execute();
        pstmt.close();
    }

    public void deleteUser(Long id) throws SQLException {
        PreparedStatement pstmt=DBHelper.getConnection().prepareStatement("delete from user_db where id=(?)");
        pstmt.setLong(1,id);
        pstmt.execute();
        pstmt.close();
    }

    public User getUserById(Long id) throws SQLException {
        PreparedStatement pstmt = DBHelper.getConnection().
                prepareStatement("select*from user_db where id=(?)");
        pstmt.setLong(1, id);
        ResultSet resultSet = pstmt.executeQuery();
        resultSet.next();
        String name = resultSet.getString(2);
        pstmt.close();
        return new User(id,name);
    }
}
