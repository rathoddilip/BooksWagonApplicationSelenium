package com.selenium.bookswagon.test;

import com.selenium.bookswagon.base.BaseClass;
import com.selenium.bookswagon.pages.Login;
import com.selenium.bookswagon.utility.CustomListener;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(CustomListener.class)
@Feature("Login to application")
public class LoginUsingObjectRepo extends BaseClass {

    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Login")
    @Description("Login to application with invalid credentials from object repository property file")
    @Test()
    public void login_to_application_with_invalid_credential() throws InterruptedException, IOException {

        Login login = new Login(driver);
        String actual = login.login_to_application_with_invalid_from_object_repo_lib();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual, expected);
    }
}
