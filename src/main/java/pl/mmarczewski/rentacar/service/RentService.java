package pl.mmarczewski.rentacar.service;

import org.springframework.stereotype.Service;
import pl.mmarczewski.rentacar.exception.CarNotFoundException;
import pl.mmarczewski.rentacar.model.Car;
import pl.mmarczewski.rentacar.repository.CarRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalLong;

@Service
public class RentService {

    private final CarRepository carRepository;

    public RentService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Long addCar(Car car) {
        return carRepository.save(car).getId();
    }

    public void deleteCar(Long id) {
//        carRepository.deleteById(id);
        Car carToDelete = carRepository.findAll().stream()
                .filter(car -> car.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException("Car is not available."));
        carRepository.delete(carToDelete);
    }

    public Car updateCar(Car car) {
        return carRepository.save(car);
    }

    public Car getCarByCarId(Long id) {
        return carRepository.findAll().stream()
                .filter(car -> car.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException("Car is not available."));
    }

    public Car rentCar(Long id) {
        Car carToRent = carRepository.findAll().stream()
                .filter(car -> car.getId().equals(id))
                .filter(car -> car.getReturnDate() == null)
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException("Car is not available."));
        carToRent.setReturnDate(LocalDate.now().plusDays(30));
        return carToRent;
    }

    public Car returnCar(Long id) {
        Car returnedCar = carRepository.findAll().stream()
                .filter(car -> car.getId().equals(id))
                .filter(car -> car.getReturnDate() == null)
                .findFirst()
                .orElseThrow(() -> new CarNotFoundException("Car is not available."));
        returnedCar.setReturnDate(null);
        return returnedCar;
    }

}
