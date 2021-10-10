package com.pedromcarrion.hexagonalsample.infrastructure.controller;

import com.pedromcarrion.hexagonalsample.infrastructure.HexagonalSampleApplication;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = HexagonalSampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class IntegrationTestBase {

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.mockMvc(mvc);
    }
}
