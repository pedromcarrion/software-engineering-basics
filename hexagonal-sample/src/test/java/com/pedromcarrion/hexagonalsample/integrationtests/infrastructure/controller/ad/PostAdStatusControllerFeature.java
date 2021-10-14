package com.pedromcarrion.hexagonalsample.integrationtests.infrastructure.controller.ad;

import com.pedromcarrion.hexagonalsample.integrationtests.infrastructure.IntegrationTestBase;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;


public class PostAdStatusControllerFeature extends IntegrationTestBase {

    @Test
    public void should_return_ok_when_we_post_new_status_for_an_existing_ad() {
        String id = "c9827c5b-8086-4612-a961-c49a70c600cb";

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
