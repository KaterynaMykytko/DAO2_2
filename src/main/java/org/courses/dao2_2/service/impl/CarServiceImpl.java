package org.courses.dao2_2.service.impl;

import org.courses.dao2_2.dao.CrudDAO;
import org.courses.dao2_2.dao.impl.CarDaoImpl;
import org.courses.dao2_2.domain.Car;
import org.courses.dao2_2.service.CrudService;

import java.sql.SQLException;
import java.util.List;

public class CarServiceImpl implements CrudService<Car> {
    private CrudDAO<Car> dao;

    public CarServiceImpl() {
        dao = new CarDaoImpl();
    }

    @Override
    public void insert(Car car) throws SQLException {
        dao.insert(new Car(car.getId(), car.getModel(), car.getModelYear()));
    }

    @Override
    public void update(int id) throws SQLException {
        dao.update(id);

    }
    @Override
    public void deleteById(int id) throws SQLException {
        dao.deleteById(id);
    }

    @Override
    public Car findById(int id) throws SQLException {
        Car result = dao.findById(id);
        return result;
    }
    @Override
    public List<Car> findAll() throws SQLException {
        List<Car> cars = dao.findAll();
        return cars;
    }
}







