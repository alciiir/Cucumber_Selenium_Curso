package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class filtrarConsola {
    private ChromeDriver driver;

    @Given("^El usuario debe estar ubicado en la pagina principal$")
    public void el_usuario_debe_estar_ubicado_en_la_pagina_principal() throws Throwable {
        System system = null;
        system.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.retrogames.cc");
        String expectedTitle = "RetroGames.cc - Play retro games online in your browser";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(1500);
    }

    @When("^Da click en PLAYSTATION$")
    public void da_click_en_PLAYSTATION() throws Throwable {
        WebElement PLAYSTATION = driver.findElement(By.cssSelector("#beNav > div:nth-child(3) > ul > li:nth-child(5) > a"));
        PLAYSTATION.click();
    }

    @Then("^Debe redirigir a juegos unicamente de PLAYSTATION$")
    public void debe_redirigir_a_juegos_unicamente_de_PLAYSTATION() throws Throwable {
        WebElement playstationGames = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[1]/h4"));
        Assert.assertEquals("PlayStation Games",playstationGames.getText());
        Thread.sleep(1500);
        driver.quit();

    }



}
