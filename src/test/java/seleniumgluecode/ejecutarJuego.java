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

public class ejecutarJuego {
    private ChromeDriver driver;

    @Given("^El usuario debe estar ubicado en la pagina principal de Retro Games$")
    public void el_usuario_debe_estar_ubicado_en_la_pagina_principal_de_Retro_Games() throws Throwable {
        System system = null;
        system.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");



        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.retrogames.cc/");
        String expectedTitle = "RetroGames.cc - Play retro games online in your browser";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(1500);
    }

    @When("^El usuario debe Buscar el juego$")
    public void el_usuario_debe_Buscar_el_juego() throws Throwable {
    WebElement ingresoNombreJuego = driver.findElement(By.xpath("//*[@id=\"searchform\"]/div/input"));
        ingresoNombreJuego.sendKeys("Donkey Kong Country USA");
        Thread.sleep(1000);
     WebElement clickSubmit = driver.findElement(By.cssSelector("#searchform > div > div > input"));
        clickSubmit.click();
     // Seleccionar una consola
        Select listaConsola = new Select(driver.findElement(By.name("system")));
        listaConsola.selectByIndex(2);
     // Click en buscar
     WebElement clickSearchNow = driver.findElement(By.cssSelector("body > div.off-canvas-wrapper > div > div.off-canvas-content > section > div.row.secBg > div > div.row.list-group.search-results > form > div.large-6.columns > button"));
        Thread.sleep(1000);
    }

    @When("^El usuario debe poder abrir el juego$")
    public void el_usuario_debe_poder_abrir_el_juego() throws Throwable {
        WebElement clickJuego = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[3]/div/div[1]/img"));
        Actions actions = new Actions(driver);
        actions.doubleClick(clickJuego).perform();
        Thread.sleep(1000);
    }

    @Then("^El juego debe ejecutarse$")
    public void el_juego_debe_ejecutarse() throws Throwable {
        //Click en descargar juego
        WebElement descargarJuego = driver.findElement(By.name("start"));
        descargarJuego.click();
        Thread.sleep(1000);
        //Click en ejecutar el juego
        WebElement comenzarJuego = driver.findElement(By.id("ejs-2284544"));
        comenzarJuego.click();
    }

}


