package service;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojo.ChangePassPojo;
import pojo.SignUpPojo;
import pojo.SingInPojo;
import request.PassUpdateRequest;
import request.SignUpRequest;
import request.SingInRequest;

public class AuthService {

    protected static final Logger logger = LogManager.getLogger();

    @Step("Sign up user")
    public static SignUpPojo registration(SignUpRequest requestBody) {
        logger.info("Register user");
        return new BaseService()
                .setEndPoint("sign-up")
                .postRequest(requestBody)
                .as(SignUpPojo.class);
    }

    public static SingInPojo login(SingInRequest requestBody) {
        return new BaseService()
                .setEndPoint("/sign-in")
                .postRequest(requestBody)
                .as(SingInPojo.class);
    }

    public static ChangePassPojo changePassword(PassUpdateRequest requestBody) {
        return new BaseService()
                .setEndPoint("user/password")
                .putRequest(requestBody)
                .as(ChangePassPojo.class);
    }

    public static String getToken() {
        SignUpRequest signUpRequest = new SignUpRequest();
        SingInRequest singInRequest = new SingInRequest();
        singInRequest.setUsername(signUpRequest.getUsername());

        registration(signUpRequest);

        return new BaseService()
                .setEndPoint("/sign-in")
                .postRequest(singInRequest)
                .as(SingInPojo.class).access_token;
    }
}
