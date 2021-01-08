package pl.mmarczewski.rentacar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Car {

    @Id
    @GeneratedValue(generator = "carSeq")
    @SequenceGenerator(name = "carSeq", sequenceName = "car_seq", allocationSize = 1)
    private Long id;
    private String mark;
    private String model;
    private Long mileage;
    private LocalDate returnDate;

    public Car() {
    }

    public Car(Long id, String mark, String model, Long mileage) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.mileage = mileage;
    }

    public Car(String mark, String model, Long mileage, LocalDate returnDate) {
        this.mark = mark;
        this.model = model;
        this.mileage = mileage;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(mark, car.mark) &&
                Objects.equals(model, car.model) &&
                Objects.equals(mileage, car.mileage) &&
                Objects.equals(returnDate, car.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, model, mileage, returnDate);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                ", returnDate=" + returnDate +
                '}';
    }
}
