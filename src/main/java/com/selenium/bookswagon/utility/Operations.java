package com.selenium.bookswagon.utility;

import com.selenium.bookswagon.base.BaseClass;
import com.selenium.bookswagon.pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class Operations extends BaseClass {


    @FindBy(xpath = "//input[@id='ctl00_TopSearch1_txtSearch']")
    WebElement search_bar;
    @FindBy(xpath = "//input[@id='ctl00_TopSearch1_Button1']")
    WebElement search_enter;
    @FindBy(xpath = "//div[@id='listSearchResult']")
    List<WebElement> search_list;
    @FindBy(xpath = "/html/body/form/div[4]/div[2]/div[3]/div[2]/div[2]/div[4]/div[5]/a[1]/input")
    WebElement buy_now;
    @FindBy(name = "BookCart$lvCart$imgPayment")
    WebElement place_order;
    @FindBy(xpath = "//span[@class='cart-item-count']")
    WebElement cart;
    @FindBy(xpath = "//a[normalize-space()='Remove']")
    WebElement remove_from_cart;
    @FindBy(name = "BookCart$lvCart$ctrl0$txtQty")
    WebElement quantity;
    @FindBy(xpath = "//input[@id='ctl00_cpBody_txtEmail']")
    WebElement sign_in_email;
    @FindBy(xpath = "//input[@id='ctl00_cpBody_txtPassword']")
    WebElement sign_in_pwd;
    @FindBy(xpath = "//input[@id='ctl00_cpBody_imgLogin']")
    WebElement login;
    @FindBy(name = "ctl00$cpBody$txtNewRecipientName")
    WebElement recipient_name;
    @FindBy(name = "ctl00$cpBody$txtNewAddress")
    WebElement recipient_address;
    @FindBy(xpath = "//select[@id='ctl00_cpBody_ddlNewCountry']//option[@value='India'][normalize-space()='India']")
    WebElement recipient_country;
    @FindBy(xpath = "//select[@id='ctl00_cpBody_ddlNewState']//option[@value='Maharashtra'][normalize-space()='Maharashtra']")
    WebElement recipient_state;
    @FindBy(xpath = "//option[@value='Jalgaon']")
    WebElement recipient_city;
    @FindBy(name = "ctl00$cpBody$txtNewPincode")
    WebElement recipient_pincode;
    @FindBy(name = "ctl00$cpBody$txtNewMobile")
    WebElement recipient_mobile;
    @FindBy(name = "ctl00$cpBody$imgSaveNew")
    WebElement submit_details;
    @FindBy(xpath = "//input[@id='ctl00_cpBody_ShoppingCart_lvCart_savecontinue']")
    WebElement save_and_continue;
    @FindBy(xpath = "//div[@id='cboxClose']")
    WebElement checkbox;
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logout_btn;

    public Operations(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String buy_book() throws InterruptedException, IOException {
        LogClass.info("click on search bar");
        search_bar.click();
        Thread.sleep(1000);
        LogClass.info("entering book name");
        search_bar.sendKeys("Java");
        Thread.sleep(2000);
        LogClass.info("click on search button");
        search_enter.click();
        Thread.sleep(1000);
        System.out.println(search_list.size());
        Thread.sleep(3000);
        search_list.get(0).click();
        Thread.sleep(4000);
        LogClass.info("click on buy button");
        buy_now.click();
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        Thread.sleep(4000);
        LogClass.info("clearing the quantity size");
        quantity.clear();
        LogClass.info("updating quantity size");
        quantity.sendKeys("3");
        Thread.sleep(3000);
        LogClass.info("click on place order");
        place_order.click();
        Thread.sleep(500);
        driver.switchTo().parentFrame();
        Thread.sleep(2000);
        LogClass.info("sending username");
        sign_in_email.sendKeys(ObjectRepositoryLibrary.getLocatorProperty(Login.propertyFilePath,"usernameFromRepo"));
        Thread.sleep(1000);
        LogClass.info("sending password");
        sign_in_pwd.sendKeys(ObjectRepositoryLibrary.getLocatorProperty(Login.propertyFilePath,"passwordFromRepo"));
        Thread.sleep(1000);
        LogClass.info("clicking on login button");
        login.click();
        Thread.sleep(500);
        LogClass.info("sending name");
        recipient_name.sendKeys(ObjectRepositoryLibrary.getLocatorProperty(Login.propertyFilePath,"name"));
        Thread.sleep(1000);
        LogClass.info("sending addresss");
        recipient_address.sendKeys(ObjectRepositoryLibrary.getLocatorProperty(Login.propertyFilePath,"address"));
        Thread.sleep(500);
        LogClass.info("selecting country option");
        recipient_country.click();
        Thread.sleep(500);
        LogClass.info("selecting state option");
        recipient_state.click();
        Thread.sleep(500);
        LogClass.info("selecting city option");
        recipient_city.click();
        Thread.sleep(500);
        LogClass.info("sending pin code");
        recipient_pincode.sendKeys(ObjectRepositoryLibrary.getLocatorProperty(Login.propertyFilePath,"pinCode"));
        Thread.sleep(500);
        LogClass.info("sending mobile number");
        recipient_mobile.sendKeys(ObjectRepositoryLibrary.getLocatorProperty(Login.propertyFilePath,"mobile"));
        Thread.sleep(500);
        LogClass.info("click on submit button");
        submit_details.click();
        Thread.sleep(1500);
        LogClass.info("click on save and continue button");
        save_and_continue.click();
        Thread.sleep(1000);
        logout_btn.click();
        LogClass.info("you're logout successfully");
        Thread.sleep(2000);
        return driver.getTitle();
    }

    public String remove_from_cart() throws InterruptedException {
        LogClass.info("click on cart");
        cart.click();
        Thread.sleep(1000);
        LogClass.info("switch to cart window");
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        LogClass.info("remove cart frame");
        remove_from_cart.click();
        LogClass.info("successfully book removed from cart");
        Thread.sleep(500);
        driver.switchTo().parentFrame();
        checkbox.click();
        Thread.sleep(2000);
        return driver.getTitle();
    }
}

