package de.startklar.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/** Prüft die REST-Schnittstelle mit der Testdatenbank. */
@SpringBootTest
@AutoConfigureMockMvc
class BusinessPlanControllerTest {
    @Autowired MockMvc mvc;
    @Test void createPlan() throws Exception {
        mvc.perform(post("/api/plans").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"Café\",\"industry\":\"GASTRONOMIE\"}"))
            .andExpect(status().isCreated()).andExpect(jsonPath("$.id").exists()).andExpect(jsonPath("$.chapters.length()").value(5));
    }
    @Test void listAndIndustries() throws Exception {
        mvc.perform(get("/api/plans")).andExpect(status().isOk());
        mvc.perform(get("/api/industries")).andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(5));
    }
    @Test void missingAndInvalid() throws Exception {
        mvc.perform(get("/api/plans/-1")).andExpect(status().isNotFound()).andExpect(jsonPath("$.message").exists());
        mvc.perform(post("/api/plans").contentType(MediaType.APPLICATION_JSON).content("{\"name\":\"\",\"industry\":\"HANDWERK\"}"))
            .andExpect(status().isBadRequest()).andExpect(jsonPath("$.message").exists());
    }
}
