package com.pedromcarrion.hexagonalsample.infrastructure.controller.ad;

import com.pedromcarrion.hexagonalsample.domain.ad.Ad;
import com.pedromcarrion.hexagonalsample.domain.ad.AdId;
import com.pedromcarrion.hexagonalsample.domain.ad.AdRepository;
import com.pedromcarrion.hexagonalsample.infrastructure.controller.IntegrationTestBase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.net.HttpURLConnection;
import java.util.Optional;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;


public class PostAdStatusControllerFeature extends IntegrationTestBase {

    @MockBean
    private AdRepository adRepository;

    @Test
    public void should_return_ok_when_we_post_new_status_for_an_existing_ad() {
        String id = "fac36485-ec10-41c2-9795-070ae49f9823";
        AdId adId = new AdId(id);
        Ad ad = new Ad(adId, "title");
        Mockito.when(adRepository.find(adId)).thenReturn(Optional.of(ad));

        given()
                .contentType("application/json")
                .body(
                        "{ \"status\":\"nook\" }"
                )
                .post(
                        "/v1/ads/{id}",
                        id
                )
                .then()
                .statusCode(HttpURLConnection.HTTP_OK);
    }
}
