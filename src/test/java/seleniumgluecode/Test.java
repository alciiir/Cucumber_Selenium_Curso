package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    private ChromeDriver driver;

    @Given("^El usuario se encuentra en el homepage de la pagina imlittletester$")
    public void el_usuario_se_encuentra_en_el_homepage_de_la_pagina_imlittletester() throws Throwable {
        // Escriba código aquí que convierta la frase anterior en acciones concretas
        System system = null;
        system.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://imalittletester.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @When("^Hace click sobre el boton The Little Tester comics$")
    public void hace_click_sobre_el_boton_The_Little_Tester_comics() throws Throwable {
        // Escriba código aquí que convierta la frase anterior en acciones concretas
        WebElement TituloComicElemento = driver.findElement(By.xpath("//*[@id=\"modal-3-content\"]/ul/li[2]/a/span"));
        TituloComicElemento.click();
        Thread.sleep(2000);

    }

    @Then("^Debe redirigir a la pantalla Comics$")
    public void debe_redirigir_a_la_pantalla_Comics() throws Throwable {
        // Escriba código aquí que convierta la frase anterior en acciones concretas
        WebElement paginaTituloComics = driver.findElement(By.xpath("//*[@id=\"wp--skip-link--target\"]/h1"));
        //Assert.assertTrue("No se redirecciono correctamente a la pagina de Comics ", paginaTituloComics.isDisplayed());
        Assert.assertEquals("Category: comics",paginaTituloComics.getText());
        Thread.sleep(1500);
        driver.quit();
    }

}
