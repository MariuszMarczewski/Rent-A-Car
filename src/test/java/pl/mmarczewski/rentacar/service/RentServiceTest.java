package pl.mmarczewski.rentacar.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.mmarczewski.rentacar.model.Car;

import javax.transaction.Transactional;
import java.time.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RentServiceTest {

    @Autowired
    private RentService sut;

    @Test
    @Transactional
    public void shouldAddCar(){
        // given
        Car car = new Car("Subaru", "WRC", 13872L, null);

        //when
        Long actual = sut.addCar(car);

        //then
        assertThat(actual).isEqualTo(5L);
    }

    @Test
    @Transactional
    public void shouldDeleteCar(){
        //given
        Car car = new Car("Subaru", "WRC", 13872L, null);

        //when
        Long isToDelete = sut.addCar(car);
        sut.deleteCar(isToDelete);
        int actual = sut.findAll().size();

        //then
        assertThat(actual).isEqualTo(4);
    }

    @Test     /* this test method is to be executed separately */
    @Transactional
    public void shouldReturnCarById(){
        //given
        Car car = new Car("Subaru", "WRC", 13872L, null);

        //when
        Long idToAdd = sut.addCar(car);
        Car actual = sut.getCarByCarId(5L);

        //then
        assertThat(actual).isEqualTo(car);
    }

    @Test
    @Transactional
    public void shouldUpdateCar(){
        //given
        Car carToUpdate = new Car("Lada", "Samara", 25464L, null);
        Long id = sut.addCar(carToUpdate);
        Car car = new Car("Lada", "Niva", 25464L, null);

        //when
        Car actual = sut.updateCar(car);

        //then
        assertThat(actual).isEqualTo(car);
    }

    @Test
    @Transactional
    public void shouldReturnCarWithNullAsReturnDate() {
        //given
        Car car = new Car("Subaru", "WRC", 13872L,
                LocalDate.of(2021, 12, 12));

        //when
        Long id = sut.addCar(car);
        Car actual = sut.returnCar(id);

        //then
        assertThat(actual.getReturnDate()).isNull();
    }
}
