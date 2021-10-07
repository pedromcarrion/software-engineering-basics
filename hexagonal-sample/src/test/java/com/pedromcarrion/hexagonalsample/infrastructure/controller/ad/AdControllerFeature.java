package com.pedromcarrion.hexagonalsample.infrastructure.controller.ad;


import com.pedromcarrion.hexagonalsample.domain.ad.Ad;
import com.pedromcarrion.hexagonalsample.domain.ad.AdId;
import com.pedromcarrion.hexagonalsample.domain.ad.AdRepository;
import com.pedromcarrion.hexagonalsample.infrastructure.HexagonalSampleApplication;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.net.HttpURLConnection;
import java.util.Optional;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = HexagonalSampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureMockMvc
class AdControllerFeature {

    @Autowired
    private MockMvc mvc;


    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.mockMvc(mvc);
    }

    @MockBean
    private AdRepository adRepository;

    @Test
    public void should_return_ok_when_we_get_for_an_ad() {
        String id = "fac36485-ec10-41c2-9795-070ae49f9823";
        AdId adId = new AdId(id);
        Ad ad = new Ad(adId, "title");
        Mockito.when(adRepository.find(adId)).thenReturn(Optional.of(ad));

        given()
                .get(
                        "/ads/{id}",
                        id
                )
                .then()
                .statusCode(HttpURLConnection.HTTP_OK);
        //.contentType("application/json").log();
        //.assertThat(content().json(loadStringFromFilePath("json/v1/ad.json")))
    }


}