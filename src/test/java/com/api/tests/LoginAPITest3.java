package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest3 {

    @Test(description = "Verify if Login API is working...")
    public void loginTest() {
    	
    	LoginRequest loginRequest = new LoginRequest("shreyans1999","shreyans1999");
        // Create instance of AuthService (inherits base setup from BaseService)
        AuthService authService = new AuthService();

        // Send POST request to /api/auth/login
        Response response = authService.login(loginRequest);

        LoginResponse loginResponse = response.as(LoginResponse.class);
        
        // Print the formatted response
        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getEmail());
        System.out.println(loginResponse.getId());
        
        Assert.assertTrue(loginResponse.getToken() != null);
        Assert.assertEquals(loginResponse.getEmail(), "saklechashreyans1999@gmail.com");
        Assert.assertEquals(loginResponse.getId(), 3209);
    }
}
