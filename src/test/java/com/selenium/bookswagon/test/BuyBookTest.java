    package com.selenium.bookswagon.test;

import com.selenium.bookswagon.base.BaseClass;
import com.selenium.bookswagon.utility.CustomListener;
import com.selenium.bookswagon.utility.Operations;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(CustomListener.class)
@Feature("Login to application")
public class BuyBookTest extends BaseClass {

    @Severity(SeverityLevel.CRITICAL)
    @Story("Buy Book")
    @Description("Search the book whatever we want and add to wishlist after that login and place the order on valid address ")
    @Test()
    public void buy_book_test() throws InterruptedException, IOException {

        Operations operations = new Operations(driver);
        String actualTitle = operations.buy_book();
        String expectedTitle = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
