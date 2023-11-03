import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.ChangePassPojo;
import pojo.SignUpPojo;
import pojo.SingInPojo;
import request.PassUpdateRequest;
import request.SignUpRequest;
import request.SingInRequest;
import service.AuthService;

public class AuthTests extends BaseTest {

    // allure + log4j + ITestListener + Retry
    // create suite.xml -> testNG
    // run suite from terminal

    @Test
    public void checkRegister() {
        SignUpRequest signUpPojo = new SignUpRequest();
        //signUpPojo.setPassword("");

        SignUpPojo signUpResponse = AuthService.registration(signUpPojo);

        Assert.assertEquals(signUpResponse.message.get(0), "User registration successfully");
    }

    @Test
    public void checkLogin() {
        SignUpRequest signUpPojo = new SignUpRequest();
        SingInRequest singInRequest = new SingInRequest();
        singInRequest.setUsername(signUpPojo.getUsername());

        AuthService.registration(signUpPojo);
        SingInPojo singInResponse = AuthService.login(singInRequest);

        Assert.assertEquals(singInResponse.access_token.length(), 121);
    }

    @Test
    public void putPassword() {
        SignUpRequest signUpRequest = new SignUpRequest();
        PassUpdateRequest passUpdateRequest = new PassUpdateRequest();
        passUpdateRequest.setPassword(signUpRequest.getPassword());
        passUpdateRequest.setUsername(signUpRequest.getUsername());

        AuthService.registration(signUpRequest);
        ChangePassPojo changePassPojo = AuthService.changePassword(passUpdateRequest);

        Assert.assertEquals(changePassPojo.message, "Password update");
    }

//    @Test
//    public void newStudent1() {
//        String email = String.format("dmk.makukhin%s@gmail.com", System.currentTimeMillis());
//
//        JSONObject student1 = new JSONObject();
//        student1.put("name", "nameDIMAAAAAAA");
//        student1.put("email", email);
//        student1.put("office", "kalinovka");
//        student1.put("mentor", "andrii");
//        student1.put("signed_up", "2023-10-25T09:23:55.229Z");
//
//
//        Response response = (Response) RestAssured
//                .given()
//                .header("Authorization", "Bearer " + getToken())
//                .contentType(ContentType.JSON)
//                .log().all()
//                .body(student1.toString())
//                .when()
//                .post("/student");
//        Student student = response.as(Student.class);
//
//        student1.put("office", "kiev");
//        RestAssured
//                .given()
//                .header("Authorization", "Bearer " + getToken())
//                .contentType(ContentType.JSON)
//                .log().all()
//                .body(student1.toString())
//                .when()
//                .put("/student");
//
//
//        System.out.println(student.email);
//        RestAssured
//                .given()
//                .header("Authorization", "Bearer " + getToken())
//                .contentType(ContentType.JSON)
//                .log().all()
//                .body(student.email)
//                .when()
//                .delete("/student");
//    }

}
