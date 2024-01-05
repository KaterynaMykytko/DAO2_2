package org.courses.dao2_2;

import org.courses.dao2_2.domain.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class DBConnector {
    private static Connection connection;
    public static final String URL = "jdbc:mysql://localhost:3306/MyCarsShop?serverTimezone=CET";
    public static final String USER_NAME = "jdbc_user";
    public static final String PASSWORD = "1234567890";

    public static Connection getConnection() throws SQLException {
        if (Objects.isNull(connection)) {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        }
        return connection;
    }







}