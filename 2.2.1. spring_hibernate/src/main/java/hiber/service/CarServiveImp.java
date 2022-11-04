package hiber.service;

import hiber.dao.CarDAO;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class CarServiveImp implements CarService {
    @Autowired
    private CarDAO carDAO;

    @Override
    @Transactional
    public void add(Car car) {
        carDAO.add(car);
    }

    @Override
    @Transactional
    public List<Car> listCars() {
        return carDAO.listCars();
    }
}
