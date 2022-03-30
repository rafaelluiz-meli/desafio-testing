package com.mercadolivre.grupo4.desafiotesting.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolivre.grupo4.desafiotesting.model.Room;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("biggestRoom endpoint should return status OK")
    public void biggestRoomOutput() throws Exception {
        this.mvc.perform(
                MockMvcRequestBuilders
                        .get("/property/biggestRoom/{propertyId}", 1))
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    @DisplayName("property/value endpoint should return status OK")
    public void propertyValueOutput() throws Exception {
        this.mvc.perform(
                MockMvcRequestBuilders
                        .get("/property/value/{propertyId}", 1))
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    @DisplayName("totalArea endpoint should return status OK")
    public void totalAreaOutput() throws Exception {
        this.mvc.perform(
                MockMvcRequestBuilders
                        .get("/property/totalArea/{propertyId}", 1))
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    @DisplayName("allRoomsArea endpoint should return status OK")
    public void allRoomsAreaOutput() throws Exception {
        this.mvc.perform(
                MockMvcRequestBuilders
                        .get("/property/allRoomsArea/{propertyId}", 1))
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }
}
