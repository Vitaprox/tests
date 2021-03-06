package test;

import hooks.Hooks;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import listenersMethods.CustomListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import steps.HeaderSteps;
import steps.HomePageSteps;

@Listeners(CustomListener.class)
public class HomePageTest extends Hooks {
    private HeaderSteps headerSteps = new HeaderSteps();
    private HomePageSteps homePageSteps = new HomePageSteps();

    //1
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяем видны и активны ли кнопки хедера: Статус заказа, Войти, Сравнения, Понравившиеся и Корзина")
    public void checkHeaderButtonsActiveAndDisplayed(){
        headerSteps.checkThatStatusButtonIsActive();
        headerSteps.checkThatStatusButtonIsDisplayed();
        headerSteps.checkThatProfileButtonIsActive();
        headerSteps.checkThatProfileButtonIsDisplayed();
        headerSteps.checkThatComparisonButtonIsNotActive();
        headerSteps.checkThatComparisonButtonIsDisplayed();
        headerSteps.checkThatFavouritesButtonIsNotActive();
        headerSteps.checkThatFavouritesButtonIsDisplayed();
        headerSteps.checkThatBasketButtonIsNotActive();
        headerSteps.checkThatBasketButtonIsDisplayed();
    }
    
    //2
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяем, активируется ли кнопка корзины, когда в неё добавляется товар")
    public void checkActivationBasketHeader(){
        homePageSteps.checkDayProductsIsDisplayed();
        homePageSteps.clickBuyButtonDayProducts(); /**Тут же проверка на отображение корзины (подтвержение, что сработал клик)*/
        headerSteps.checkBasketCount();
    }

    //7
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяем работает ли окно авторизации и активные в нем кнопки и ссылки")
    public void checkAuthorisationWindow(){
        headerSteps.clickProfileButton(); /**Там же проверка открылось ли окно с заголовком Вход или регистрация*/
        headerSteps.checkCloseButtonIsDisplayed();
        headerSteps.checkInputPhoneIsDisplayed();
        headerSteps.checkActiveLoginButton();
        headerSteps.checkEntityFormIIsDisplayed();
    }

    //10
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем окно изменения города, выбираем другой город")
    public void checkEditCity(){
        headerSteps.clickLocationCity(); /**Тут же проверка открылось ли окно*/
        headerSteps.chooseCity(); /**Тут же проверка закрылось ли окно*/
        headerSteps.checkLocationCityText();
    }

}
