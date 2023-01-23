package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class registroUsuario {
    private ChromeDriver driver;
    @Given("^El usuario debe estar en la parte de registro de Retro Games$")
    public void el_usuario_debe_estar_en_la_parte_de_registro_de_Retro_Games() throws Throwable {
        System system = null;
        system.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.retrogames.cc/register.html");
        String expectedTitle = "RetroGames.cc - Play retro games online in your browser";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Thread.sleep(1500);
    }

    @When("^Llenar formulario$")
    public void llenar_formulario() throws Throwable {
        //Ingreso de nombre de usario
     WebElement nombreUsario = driver.findElement(By.xpath("//*[@id=\"test-eq\"]/div/div[1]/form/div[2]/input"));
        nombreUsario.sendKeys("Alcir2592123");
        //Ingreso de correo
     WebElement correo = driver.findElement(By.xpath("//*[@id=\"test-eq\"]/div/div[1]/form/div[3]/input"));
        correo.sendKeys("alej.riverac@duocuc.cl");
        //Ingreso de contraseña
        WebElement contraseña = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        contraseña.sendKeys("test123456");
        //Ingreso de repetir contraseña
        WebElement repContraseña = driver.findElement(By.xpath("//*[@id=\"test-eq\"]/div/div[1]/form/div[5]/input"));
        repContraseña.sendKeys("test123456");
        // click en el boton Registrar AHORA
        WebElement registrarAhora = driver.findElement(By.xpath("//*[@id=\"test-eq\"]/div/div[1]/form/button"));
        registrarAhora.click();
    }

    @Then("^Debe derigir a mi perfil$")
    public void debe_derigir_a_mi_perfil() throws Throwable {
        WebElement tituloPerfil = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div[1]/aside/div/div/div/div[1]"));
        Assert.assertEquals("Profile Overview",tituloPerfil.getText());
        Thread.sleep(1500);
        driver.quit();
    }

}
