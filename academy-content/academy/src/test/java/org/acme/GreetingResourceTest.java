package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }
    @Test
    void testHelloPersonEndpoint() {
        given()
                .when().get("/hello/person")
                .then()
                .statusCode(200)
                .body(is("[{\"id\":1,\"name\":\"João\"},{\"id\":2,\"name\":\"Maria\"}]"));
    }
}