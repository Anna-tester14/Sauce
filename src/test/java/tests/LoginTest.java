package tests;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AllureUtils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    @Epic("Модуль логина интернет-магазина")
    @Feature("TMS-56")
    @Story("TNS-56.67")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Anna")
    @TmsLink("UrnSu")
    @Test (description = "авторизация под верными данными")
    @Issue("3")
    @Description ("Проверка входа в систему интернет-магазина")
    @Flaky
    public void correctLogin() {
        loginPage.open();
        loginPage.login(user, password);
        // AllureUtils.takeScreenshot(driver);
        assertEquals(productsPage.getTitle(), "Products");
        assertTrue(productsPage.isDispl(), "");

    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"standard_users", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"}
        };
    }

    @Test(dataProvider = "loginData")
    public void lockedUserLogin(String user, String pass, String errorMsg) {
        loginPage.open();
        loginPage.login(user, pass);
        assertEquals(loginPage.getErrorMessage(), errorMsg);
    }
}