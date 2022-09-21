package client;

import io.restassured.response.ValidatableResponse;
import model.User;

import static io.restassured.RestAssured.given;

public class UserClient extends RestClient {
    public ValidatableResponse login(User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
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
    public ValidatableResponse create(User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post("/api/auth/register")
                .then();
    }
}
