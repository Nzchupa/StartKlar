package de.startklar.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test für {@link StatusController}. Vorlage für Tests weiterer Controller.
 *
 * <p>{@code @WebMvcTest} startet nur die Web-Schicht (ohne Services und Repositories).
 * Mit {@link MockMvc} wird eine HTTP-Anfrage simuliert, ohne echten Server.</p>
 */
@WebMvcTest(StatusController.class)
class StatusControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getStatusReturnsOk() throws Exception {
        mockMvc.perform(get("/api/status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("ok"))
                .andExpect(jsonPath("$.application").value("StartKlar"));
    }
}
