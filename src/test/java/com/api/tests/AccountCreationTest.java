package com.api.tests;

import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

    @Test(description = "Verify if Login API is working...")
    public void createAccountTest() {

        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .username("ashwin2004")
                .email("ashwin2004@gmail.com")
                .firstName("ashwin")
                .password("ashwin2004")
                .lastName("saklecha")
                .mobileNumber("9977777776")
                .build();

        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);
        System.out.println(response.asPrettyString());
        
    }
}
