package com.selenium.bookswagon.test;

import com.selenium.bookswagon.base.BaseClass;
import com.selenium.bookswagon.pages.Home;
import com.selenium.bookswagon.pages.Login;
import com.selenium.bookswagon.utility.CustomListener;
import com.selenium.bookswagon.utility.DataProviderClass;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
@Feature("Login to application")
public class LoginByUsingDataProvider extends BaseClass {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Login to application with valid credentials")
    @Story("Test login account by using data provider credentials ")
    @Test(priority = 1,dataProvider = "testDataSetFromExcelFile", dataProviderClass = DataProviderClass.class)
    public void login_to_application_using_dataProvider_data(String emailId, String passwd) throws InterruptedException {

        Login login = new Login(driver);
        login.login_to_application_with_valid_credential(emailId, passwd);
        Home home = new Home(driver);
        home.logout_from_account();
        String expectedUrl = "https://www.bookswagon.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}
