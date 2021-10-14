package com.pedromcarrion.hexagonalsample.integrationtests.infrastructure.controller.ad;

import com.pedromcarrion.hexagonalsample.integrationtests.infrastructure.IntegrationTestBase;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;


class GetAdControllerFeature  extends IntegrationTestBase {

    @Test
    public void should_return_ok_when_we_get_for_an_ad() {
        String id = "6dad6597-a7bc-47f0-b94c-dd141b3c37f1";

        given()
                .get(
                        "/v1/ads/{id}",
                        id
                )
                .then()
                .statusCode(HttpURLConnection.HTTP_OK)
                .contentType("application/json");
        //.assertThat(content().json(loadStringFromFilePath("json/v1/ad.json")))
    }
}