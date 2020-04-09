package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {


    public static Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();
            url.append("jdbc:mysql://").
                    append("localhost:").
                    append("3306/").
                    append("preproject?").
                    append("user=javamentor&").
                    append("password=java");
            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (InstantiationException | SQLException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

}
