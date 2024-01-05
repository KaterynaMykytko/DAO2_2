package org.courses.dao2_2;

import org.courses.dao2_2.domain.Car;
import org.courses.dao2_2.service.CrudService;
import org.courses.dao2_2.service.impl.CarServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // CrudDAO<Car> carDao= new CarDaoImpl();
        //carDao.findById(3);
        //carDao.findById(2);
       // carDao.update(4);
        //Car car1 = new Car(6, "LC-200", 2023);
        //carDao.insert(car1);
       // carDao.deleteById(2);
        //List<Car> cars = carDao.findAll();
        //System.out.println(cars);

        CrudService<Car> carService = new CarServiceImpl();
        //carService.insert(new Car(7, "Hilux", 2023));
       //carService.update(4);
        //carService.insert(new Car(8, "Fortuner", 2020));
        //carService.deleteById(7);
        carService.findById(5);
        List<Car> cars = carService.findAll();
        System.out.println(cars);
    }
}
