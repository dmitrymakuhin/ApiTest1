package service;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static service.AuthService.getToken;

public class BaseService {

    private final RequestSpecification requestSpecification;

    public BaseService() {
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://192.168.68.233:3000/api/v1")
                .build();
    }

    public BaseService auth() {
        requestSpecification.header("Authorization", "Bearer " + getToken());
        return this;
    }

    public BaseService setEndPoint(String endPoint) {
        requestSpecification.basePath(endPoint);
        return this;
    }

    public Response postRequest(Object requestBody) {
        requestSpecification.body(requestBody);
        return RestAssured
                .given()
                .log().all()
                .spec(requestSpecification)
                .when()
                .post()
                .then()
                .log().all()
                .extract().response();
    }

    public Response putRequest(Object requestBody) {
        requestSpecification.body(requestBody);
        return RestAssured
                .given()
                .log().all()
                .spec(requestSpecification)
                .when()
                .put()
                .then()
                .log().all()
                .extract().response();
    }
}
