package ru.netology.web.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiHelp {

    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    private ApiHelp() {
    }

    static DataGen.RegistrationDto sendRequest(DataGen.RegistrationDto user) {
        given()
                .spec(requestSpec)
                .body(user)
                .when().log().all()
                .post("/api/system/users")
                .then()
                .statusCode(200);
        return user;
    }
}