package com.selenium.bookswagon.test;

import com.selenium.bookswagon.base.BaseClass;
import com.selenium.bookswagon.pages.Home;
import com.selenium.bookswagon.pages.Login;
import com.selenium.bookswagon.utility.CustomListener;
import com.selenium.bookswagon.utility.Operations;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
@Feature("Login to application")
public class RemoveBookFromCart extends BaseClass {

    String username = "diliprathodtest@gmail.com";
    String password = "Login@123";

    @Severity(SeverityLevel.CRITICAL)
    @Story("Test Login")
    @Description("Login to application with valid credentials")
    @Test()
    public void login_to_application() throws InterruptedException {

        Login login = new Login(driver);
        String actual = login.login_to_application_with_valid_credential(username, password);
        String expected = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual, expected);
    }

    @Severity(SeverityLevel.MINOR)
    @Description("remove_book_test method is depends  on the login_to_application method  ")
    @Test(dependsOnMethods = {"login_to_application"})
    public void remove_book_test() throws InterruptedException {

        Operations operations = new Operations(driver);
        String actual_title = operations.remove_from_cart();
        String expected_title = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actual_title, expected_title);
        System.out.println("book is removed successfully");
        Home home = new Home(driver);
        home.logout_from_account();
        String expectedUrl = "https://www.bookswagon.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}
