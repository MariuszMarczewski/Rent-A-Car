package pl.mmarczewski.rentacar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class CarControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /cars success")
    public void testFindAll() throws Exception {
        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /cars/1 success")
    public void testGetCarById() throws Exception {
        mockMvc.perform(get("/cars/1", 1L))
                .andExpect(status().isOk());
    }
}
