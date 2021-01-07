package pl.mmarczewski.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mmarczewski.rentacar.model.Car;


public interface CarRepository extends JpaRepository<Car, Long> {

}
