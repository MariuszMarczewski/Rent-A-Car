package pl.mmarczewski.rentacar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mmarczewski.rentacar.model.Car;
import pl.mmarczewski.rentacar.service.RentService;

import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
public class CarController {

    private final RentService rentService;

    public CarController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping("/cars")
    public List<Car> findAll(){
        return rentService.findAll();
    }

    @PostMapping(value = "/cars/add", consumes = "application/json")
    public ResponseEntity<Long> add(@RequestBody Car car) {
        return new ResponseEntity<>(rentService.addCar(car), HttpStatus.CREATED);
    }
    @PutMapping(value = "/cars/update", consumes = "application/json")
    public ResponseEntity<Car> update(@RequestBody Car car){
        return new ResponseEntity<>(rentService.updateCar(car), HttpStatus.CREATED);
    }

    @DeleteMapping("/cars/delete/{id}")
    public ResponseEntity<Void> removeReservation(@PathVariable Long id) {
        rentService.deleteCar(id);
        return noContent().build();
    }

    @GetMapping(value = "/cars/rent/{id}", produces = "application/json")
    public ResponseEntity<Car> rentCar(@PathVariable Long id) {
        rentService.rentCar(id);
        return ResponseEntity.ok(rentService.getCarByCarId(id));
    }

    @GetMapping(value = "cars/return/{id}", produces = "application/json")
    public ResponseEntity<Car> returnCar(@PathVariable Long id){
        return new ResponseEntity<>(rentService.returnCar(id), HttpStatus.OK);
    }

    @GetMapping(value = "/cars/{id}", produces = "application/json")
    public ResponseEntity<Car> findCarById(@PathVariable Long id){
        return new ResponseEntity<>(rentService.getCarByCarId(id), HttpStatus.OK);
    }

}
