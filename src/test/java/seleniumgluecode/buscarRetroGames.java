package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class buscarRetroGames {
    private ChromeDriver driver;

    @Given("^El usuario se encuentra en el buscador google$")
    public void el_usuario_se_encuentra_en_el_buscador_google() throws Throwable {
        System system = null;
        system.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        Thread.sleep(1500);
    }

    @When("^Ingresa el nombre de retrogames\\.cc en el buscador$")
    public void ingresa_el_nombre_de_retrogames_cc_en_el_buscador() throws Throwable {
    WebElement ingresoTexto = driver.findElement(By.className("gLFyf"));
        ingresoTexto.sendKeys("retrogames.cc");
        Thread.sleep(1500);
    }

    @When("^Le da click en boton Buscar en Google$")
    public void le_da_click_en_boton_Buscar_en_Google() throws Throwable {
    WebElement buscarEnGoolge = driver.findElement(By.className("gNO89b"));
        buscarEnGoolge.click();
        Thread.sleep(1000);
    }

    @When("^Le da click en la primera pagina sugerida por google$")
    public void le_da_click_en_la_primera_pagina_sugerida_por_google() throws Throwable {
    WebElement clickSitioRetroGames = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        clickSitioRetroGames.click();
        Thread.sleep(1000);
    }

    @Then("^Debe redirigir a la pagina de inicio de Retro Games$")
    public void debe_redirigir_a_la_pagina_de_inicio_de_Retro_Games() throws Throwable {
        String expectedTitle = "RetroGames.ccs - Play retro games online in your browser";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(1000);
        driver.quit();
    }
}
