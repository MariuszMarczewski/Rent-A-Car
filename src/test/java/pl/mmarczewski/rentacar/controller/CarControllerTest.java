package pl.mmarczewski.rentacar.controller;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pl.mmarczewski.rentacar.model.Car;
import pl.mmarczewski.rentacar.service.RentService;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class CarControllerTest {

    @MockBean
    private RentService rentService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /cars success")
    public void testFindAll() throws Exception {
        Car car1 = new Car(1L, "Mark1", "model1", 11L);
        Car car2 = new Car(2L, "Mark2", "model2", 22L);
        doReturn(Lists.newArrayList(car1, car2)).when(rentService).findAll();
        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /cars/1 success")
    public void testGetCarById() throws Exception {
        Car car1 = new Car(1L, "Mark1", "model1", 11L);
        Car car2 = new Car(2L, "Mark2", "model2", 22L);
        doReturn(Lists.newArrayList(car1, car2)).when(rentService).findAll();
        mockMvc.perform(get("/cars/1", 1L))
                .andExpect(status().isOk());
    }
}
