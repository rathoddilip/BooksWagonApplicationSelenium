package com.selenium.bookswagon.test;

import com.selenium.bookswagon.base.BaseClass;
import com.selenium.bookswagon.pages.Home;
import com.selenium.bookswagon.pages.Login;
import com.selenium.bookswagon.utility.CustomListener;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
@Feature("Login to application")
public class AddToCart extends BaseClass {

    String username = "diliprathodtest@gmail.com";
    String password = "Login@123";
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Login")
    @Description("Login to application with valid credentials")
    @Test()
    public void add_to_wishlist_test() throws InterruptedException {

        Login login = new Login(driver);
        login.login_to_application_with_valid_credential(username, password);
        Home homePage = new Home(driver);
        String actual = homePage.add_to_cart();
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual, expected);
        System.out.println("Book is added to cart is successfully!!");
    }
}
