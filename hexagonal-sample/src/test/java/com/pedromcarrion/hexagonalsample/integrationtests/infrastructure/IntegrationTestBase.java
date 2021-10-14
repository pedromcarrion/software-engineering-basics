package com.pedromcarrion.hexagonalsample.integrationtests.infrastructure;

import com.pedromcarrion.hexagonalsample.infrastructure.HexagonalSampleApplication;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;

import static java.lang.System.setProperty;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = HexagonalSampleApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "spring.profiles.active=test")
@AutoConfigureMockMvc
public class IntegrationTestBase {

    @Autowired
    private MockMvc mvc;

    private static PostgreSQLContainer database = new PostgreSQLContainer("postgres:11.2")
            .withDatabaseName("hexagonalsample")
            .withUsername("hexagonalsample")
            .withPassword("hexagonalsample");

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.mockMvc(mvc);
    }


    @BeforeAll
    static void up() {
        database.start();
        setProperty("datasource.url", database.getJdbcUrl());
        setProperty("database.port", database.getMappedPort(5432).toString());
    }

    @AfterAll
    static void down() {
        database.stop();
    }


}
