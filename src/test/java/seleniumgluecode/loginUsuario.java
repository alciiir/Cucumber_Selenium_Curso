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

public class loginUsuario {
    private ChromeDriver driver;

    @Given("^El usuario debe estar en la pagina de login$")
    public void el_usuario_debe_estar_en_la_pagina_de_login() throws Throwable {
        System system = null;
        system.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.retrogames.cc/login.html");
        String expectedTitle = "RetroGames.cc - Play retro games online in your browser";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(4000);
    }

    @When("^Ingreso de credenciales$")
    public void ingreso_de_credenciales() throws Throwable {
    WebElement nombreUsuario = driver.findElement(By.cssSelector("#test-eq > div > div.register-form > form > div:nth-child(2) > input"));
    nombreUsuario.sendKeys("Alcir2592123");

    WebElement contraseñaUsuario = driver.findElement(By.cssSelector("#password"));
    contraseñaUsuario.sendKeys("test123456");

    WebElement LoginAhora = driver.findElement(By.xpath("//*[@id=\"test-eq\"]/div/div[1]/form/button"));
    LoginAhora.click();
    }

    @Then("^Debe aparecer el nombre de usuario en la parte superior de la pantalla$")
    public void debe_aparecer_el_nombre_de_usuario_en_la_parte_superior_de_la_pantalla() throws Throwable {
        WebElement Logueado = driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[2]/div/ul/li/a"));
        Assert.assertEquals("Alcir2592123",Logueado.getText());
        Thread.sleep(1500);
        driver.quit();
    }
}
