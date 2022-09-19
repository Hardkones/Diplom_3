package pageobjects;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserRequests extends RestClient{
    public ValidatableResponse login(UserLogin userLogin) {
        return given()
                .spec(getBaseSpec())
                .body(userLogin)
                .post("/api/auth/login")
                .then();
    }
    public ValidatableResponse delete(String accessToken) {
        return given()
                .spec(getBaseSpec())
                .header("Authorization", accessToken)
                .when()
                .delete("/api/auth/user")
                .then();
    }
    public ValidatableResponse create(UserCreate userCreate) {
        return given()
                .spec(getBaseSpec())
                .body(userCreate)
                .when()
                .post("/api/auth/register")
                .then();
    }
}
