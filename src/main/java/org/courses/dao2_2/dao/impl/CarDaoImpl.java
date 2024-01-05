package org.courses.dao2_2.dao.impl;

import org.courses.dao2_2.dao.CrudDAO;
import org.courses.dao2_2.domain.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarDaoImpl implements CrudDAO<Car> {

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

    @Override
    public void insert(Car car) throws SQLException {
        String query = "INSERT INTO Car(car_id, model, modelYear) " +
                "VALUES(?,?,?)";

        PreparedStatement statement = getConnection().prepareStatement(query);

        statement.setInt(1, car.getId());
        statement.setString(2, car.getModel());
        statement.setInt(3, car.getModelYear());

        try (statement) {
            statement.executeUpdate();
        }
    }

    @Override
    public void update(int id) throws SQLException {
        String query = "UPDATE Car SET model = 'corolla' WHERE car_id = ?";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setInt(1, id);

        try (statement) {
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteById(int id) throws SQLException {
        String query = "DELETE FROM Car WHERE car_id = ?";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setInt(1, id);

        try (statement) {
            statement.executeUpdate();
        }

    }

    @Override
    public Car findById(int id) throws SQLException {
        String query = "SELECT * FROM Car WHERE car_id = ?";
        PreparedStatement statement = getConnection().prepareStatement(query);
        statement.setInt(1, id);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                int car_id = resultSet.getInt("car_id");
                String model = resultSet.getString("model");
                int modelYear = resultSet.getInt("modelYear");
                System.out.println(car_id + "\t\t" + model + "\t\t" + modelYear);
                Car car = new Car(car_id, model, modelYear);
                return car;
            }
        }
        return null;
    }

    @Override
    public List<Car> findAll() throws SQLException {
        String query = "SELECT * FROM Car";

        PreparedStatement statement = getConnection().prepareStatement(query);
        try (ResultSet resultSet = statement.executeQuery()) {
            List<Car> car = new ArrayList<>();
            while (resultSet.next()) {
                int car_id = resultSet.getInt("car_id");
                String model = resultSet.getString("model");
                int modelYear = resultSet.getInt("modelYear");
                car.add(new Car(car_id, model, modelYear));
            }
            return car;
        }
    }
}
