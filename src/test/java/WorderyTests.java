import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;


public class WorderyTests {

    @Given("I have written correctly every test I found interesting and of use for the project")
    public void startup(){
        System.out.println("Sequence of tests in a given scenario is starting now...");
    }

    @Then("They should all pass and the scenario is now completed!")
    public void finish(){
        System.out.println("Congratulations! Every single test in the given scenario has passed!");
    }

    /*
    @Before i @After se namerno izostaveni so ogled na toa sto koristam samo edna test klasa
    - driverot ne e inicijaliziran na drugo mesto.

    - testovite prvicno se praveni so chrome webdriver v.91, a potoa na v.93
     */

    @When("I start my first test - Successfull Login")
    @Test
    public void SuccessfulLogin() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");


        WebElement prelogin = driver.findElement(By.linkText("Sign in"));
        prelogin.sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        List<WebElement> signinbutton = driver.findElements(By.className("u-1/1-3cols"));


        email.sendKeys("dotnetapp111@gmail.com");
        password.sendKeys("dotnetapp222");
        signinbutton.get(1).sendKeys(Keys.ENTER);


        String expectedURL = "https://wordery.com/account/settings";
        String actualURL = driver.getCurrentUrl();


        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my second test - Wrong Username Or Password")
    @Test
    public void WrongUsernameOrPassword() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");


        WebElement prelogin = driver.findElement(By.linkText("Sign in"));
        prelogin.sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        List<WebElement> signinbutton = driver.findElements(By.className("u-1/1-3cols"));


        email.sendKeys("dotnetapp111@gmail.com");
        password.sendKeys("dotnetapp22");
        signinbutton.get(1).sendKeys(Keys.ENTER);

        List<WebElement> errorMSG = driver.findElements(By.className("c-msg-box"));


        String expectedMSG = "Email/Password combination incorrect.";
        String actualMSG = errorMSG.get(0).getText().toString();


        assertEquals(actualMSG,expectedMSG);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my third test - Test Change Password")
    @Test
    public void TestChangePassword() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("My Wordery")).sendKeys(Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.linkText("Change Password")).sendKeys(Keys.ENTER);
        Thread.sleep(500);

        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElement(By.id("newPassword")).sendKeys("dotnetapp222");
        driver.findElement(By.id("newPassword2")).sendKeys("dotnetapp222");

        Thread.sleep(500);

        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);

        String expected = "Password updated. You may now use it to log back in.";
        String actual = driver.findElement(By.className("c-msg-box--success")).getText();

        assertEquals(actual,expected);

        Thread.sleep(2000);

        driver.close();

    }

    @When("I start my first test - Test Shop Link")
    @Test
    public void TestShopLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        List<WebElement> navbar = driver.findElements(By.className("c-global-utils__nav-label"));

        navbar.get(0).sendKeys(Keys.ENTER);

        String expectedURL = "https://wordery.com/";
        String actualURL = driver.getCurrentUrl();

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();

    }

    @And("I start my second test - Test Blog Link")
    @Test
    public void TestBlogLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        List<WebElement> navbar = driver.findElements(By.className("c-global-utils__nav-label"));

        navbar.get(1).sendKeys(Keys.ENTER);

        String expectedURL = "https://wordery.com/blog";
        String actualURL = driver.getCurrentUrl();

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();

    }

    @And("I start my third test - Test About Link")
    @Test
    public void TestAboutLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        List<WebElement> navbar = driver.findElements(By.className("c-global-utils__nav-label"));

        navbar.get(2).sendKeys(Keys.ENTER);

        String expectedURL = "https://wordery.com/about-wordery/our-story";
        String actualURL = driver.getCurrentUrl();

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();

    }

    @And("I start my fourth test - Test Help And Contact Link")
    @Test
    public void TestHelpAndContactLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        List<WebElement> navbar = driver.findElements(By.className("c-global-utils__nav-label"));

        navbar.get(3).sendKeys(Keys.ENTER);

        String expectedURL = "https://wordery.com/cs/help";
        String actualURL = driver.getCurrentUrl();

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();

    }

    @And("I start my fifth test - Test Change Currency To GBP")
    @Test
    public void TestChangeCurrencyToGBP() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        List<WebElement> navbar = driver.findElements(By.className("c-global-utils__nav-label"));

        navbar.get(4).sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        driver.findElement(By.className("c-crncy-sel__link")).sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        String expected = "GBP";
        String actual = driver.findElement(By.className("u-t--middle")).getText();

        assertEquals(actual,expected);

        Thread.sleep(2000);

        driver.close();

    }

    @And("I start my sixth test - Test View Basket")
    @Test
    public void TestViewBasket() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        List<WebElement> navbar = driver.findElements(By.className("c-global-utils__nav-label"));

        navbar.get(5).sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        driver.findElement(By.className("u-mb1/2")).sendKeys(Keys.ENTER);

        String expectedURL = "https://wordery.com/basket";
        String actualURL = driver.getCurrentUrl();

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();

    }

    @And("I start my seventh test - Test MyWordery Link SignIn")
    @Test
    public void TestMyWorderyLinkSignIn() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");


        List<WebElement> prelogins = driver.findElements(By.className("u-t--middle"));
        prelogins.get(2).click();

        Thread.sleep(2000);

        List<WebElement> credentials = driver.findElements(By.className("label__focus"));


        credentials.get(0).sendKeys("dotnetapp111@gmail.com");
        credentials.get(1).sendKeys("dotnetapp222");

        List<WebElement> loginbuttons = driver.findElements(By.className("c-login-form__btn"));
        loginbuttons.get(0).click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://wordery.com/";

        assertEquals(expectedURL,actualURL);

        Thread.sleep(2000);

        driver.close();

    }

    @And("I start my eighth test - Test MyWishlist Link")
    @Test
    public void TestMyWishlistLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        List<WebElement> navbar = driver.findElements(By.className("c-global-utils__nav-label"));

        navbar.get(7).sendKeys(Keys.ENTER);

        String expectedURL = "https://wordery.com/account/wishlist";
        String actualURL = driver.getCurrentUrl();

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();

    }

    @And("I start my nineth test - Test MyWishlist Creation")
    @Test
    public void TestMyWishlistCreate() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        List<WebElement> navbar = driver.findElements(By.className("c-global-utils__nav-label"));

        navbar.get(7).sendKeys(Keys.ENTER);

        Thread.sleep(500);

        driver.findElements(By.className("o-spread")).get(0).sendKeys(Keys.ENTER);

        driver.findElement(By.id("listname")).sendKeys("TestWishlist");
        Thread.sleep(2000);
//        driver.findElement(By.id("list-is-public")).sendKeys(Keys.ENTER);
//        Thread.sleep(2000);
        driver.findElements(By.tagName("button")).get(11).sendKeys(Keys.ENTER);
        Thread.sleep(4000);

        String expected = "TestWishlist";
        String actual = driver.findElement(By.className("o-title__title")).getText();

        assertEquals(actual,expected);

        Thread.sleep(2000);

        driver.close();

    }

    @And("I start my tenth test - Test Delete MyWishlist ListOne")
    @Test
    public void DeleteMyWishlistListOne() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("My Wishlist")).sendKeys(Keys.ENTER);
        Thread.sleep(4500);
        driver.findElement(By.linkText("Edit List")).sendKeys(Keys.ENTER);

        driver.findElement(By.className("c-btn--error")).sendKeys(Keys.ENTER);

        Thread.sleep(6000);

        String expected = "No lists have been created yet, go ahead and make your first one...";
        String actual = driver.findElements(By.tagName("p")).get(4).getText();

        assertEquals(expected,actual);

        Thread.sleep(2000);

        driver.close();
    }

    @When("I start my first test - Test Grid View")
    @Test
    public void TestGridView() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.id("header-search")).sendKeys("Gorgias");
        driver.findElements(By.className("o-addon__extra")).get(0).sendKeys(Keys.ENTER);


        driver.findElement(By.id("grid-view")).sendKeys(Keys.ENTER);

        String expected = "https://wordery.com/search?term=Gorgias&negatives=%7B%22salesExclusions%22%3A%5B%22GB%22%5D%7D&viewBy=grid";
        String actual = driver.getCurrentUrl();

        assertEquals(expected,actual);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my second test - Test Search And Book Details")
    @Test
    public void TestSearchAndBookDetails() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.id("header-search")).sendKeys("Nightwing by Peter Tomasi");
        driver.findElements(By.className("o-addon__extra")).get(0).sendKeys(Keys.ENTER);

        driver.findElements(By.className("ga-view-btn")).get(0).sendKeys(Keys.ENTER);

        String expected = "Nightwing by Peter Tomasi";
        String actual = driver.findElement(By.tagName("h1")).getText();

        assertEquals(expected,actual);

        Thread.sleep(2000);

        driver.close();
    }


    @And("I start my third test - Search Book And Add To MyWishlist")
    @Test
    public void SearchBookAndAddToMyWishlist() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.id("header-search")).sendKeys("Nightwing by Peter Tomasi");
        driver.findElements(By.className("o-addon__extra")).get(0).sendKeys(Keys.ENTER);

        driver.findElements(By.className("ga-view-btn")).get(0).sendKeys(Keys.ENTER);



        driver.findElements(By.className("js-wl-add")).get(0).sendKeys(Keys.ENTER);

        driver.findElement(By.id("add-item")).sendKeys("Favourite");
        Thread.sleep(4500);
        driver.findElement(By.className("c-add-item__btn")).sendKeys(Keys.ENTER);
        Thread.sleep(4500);
        driver.findElement(By.linkText("View wishlists")).sendKeys(Keys.ENTER);
        Thread.sleep(4500);

        String expected = "Nightwing by Peter Tomasi";
        String actual = driver.findElement(By.linkText("Nightwing by Peter Tomasi")).getText();

        assertEquals(expected,actual);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my fourth test - Delete MyWishlist ListTwo")
    @Test
    public void DeleteMyWishlistListTwo() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("My Wishlist")).sendKeys(Keys.ENTER);
        Thread.sleep(4500);
        driver.findElement(By.linkText("Edit List")).sendKeys(Keys.ENTER);

        driver.findElement(By.className("c-btn--error")).sendKeys(Keys.ENTER);

        Thread.sleep(6000);

        String expected = "No lists have been created yet, go ahead and make your first one...";
        String actual = driver.findElements(By.tagName("p")).get(4).getText();

        assertEquals(expected,actual);

        Thread.sleep(2000);

        driver.close();
    }




    /**

     mora da bidi odobreno od tim na sajt, a ne mozam da izbrisam, zatoa e komentiran ovoj test
     test search and book details


    @Test
    public void TestReviewBook() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.id("header-search")).sendKeys("Nightwing");
        driver.findElements(By.className("o-addon__extra")).get(0).sendKeys(Keys.ENTER);

        driver.findElements(By.className("ga-view-btn")).get(1).sendKeys(Keys.ENTER);



        driver.findElement(By.linkText("Review this book")).sendKeys(Keys.ENTER);
        Thread.sleep(4500);
        //driver.findElement(By.id("icon-star")).sendKeys(Keys.ENTER);
        driver.findElements(By.className("label__focus")).get(3).sendKeys("Great Book!");
        Thread.sleep(4500);
        driver.findElements(By.className("label__focus")).get(4).sendKeys("Great Title");

        driver.findElement(By.className("c-btn--icon")).sendKeys(Keys.ENTER);


        String expected = "Write a Review";
        String actual = driver.findElements(By.tagName("h2")).get(2).getText();

        assertEquals(expected,actual);

        Thread.sleep(2000);

        driver.close();
    }

**/

/*
    Dopolnitelno testiranje na dodavavnje kniga vo kosnicka ne e testirano poradi nemoznosta za istoto zaklucno so 18.07.2021 (12.09.2021 i 14.09.2021)
    Za site knigi dava deka se Currently Unavailable - Why is this unavailable?
    Spored toa sto procitav na stranata istoto navodno e zaradi Brexit i Covid restrikcii
 */


    @When("I start my first test - Test Fiction Link")
    @Test //
    public void TestFictionLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("Fiction")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Browse all of Fiction")).click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://wordery.com/fiction";

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my second test - Test Fiction -> Adventure Link")
    @Test
    public void TestFictionAdventureLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("Fiction")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Adventure")).sendKeys(Keys.ENTER);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://wordery.com/adventure-books-FJ";

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my third test - Test Fiction -> AudioBooks Link")
    @Test
    public void TestFictionAudioBooksLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("Fiction")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Audio Books")).sendKeys(Keys.ENTER);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://wordery.com/audio-books";

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my fourth test - Test Fiction -> HorrorAndGhostStories Link")
    @Test
    public void TestFictionHorrorAndGhostStoriesLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("Fiction")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Horror & Ghost Stories")).sendKeys(Keys.ENTER);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://wordery.com/horror-ghost-stories-books-FK";

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my fifth test - Test Non-Fiction Link")
    @Test
    public void TestNonFictionLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("Non-Fiction")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Browse all of Non-Fiction")).sendKeys(Keys.ENTER);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://wordery.com/non-fiction";

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my sixth test - Test Children And Young Adult Link")
    @Test
    public void TestChildrenYoungAdultLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("Children's & Young Adult")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Browse all of Children's & Young Adult")).sendKeys(Keys.ENTER);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://wordery.com/childrens-books";

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my seventh test - Test Education Link")
    @Test
    public void TestEducationLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("Education")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Browse all of Education")).sendKeys(Keys.ENTER);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://wordery.com/education";

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my eighth test - Test Stationery & Gifts -> Adult Colouring Books Link")
    @Test
    public void TestStationeryGiftsLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("Stationery & Gifts")).click();
        Thread.sleep(500);
        driver.findElement(By.linkText("Adult Colouring Books")).sendKeys(Keys.ENTER);

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://wordery.com/adult-colouring-books-WFX";

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();
    }

    @When("I start my first test - Test Bestsellers Link")
    @Test
    public void TestBestsellersLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("Bestsellers")).click();
        Thread.sleep(500);


        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://wordery.com/bestsellers";

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my second test - Test FAQ Link")
    @Test
    public void TestFAQLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("FAQ")).click();
        Thread.sleep(500);


        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://wordery.com/about-wordery/faq";

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my third test - Test Terms Of Sale Link")
    @Test
    public void TestTermsOfSaleLink() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("Terms of Sale")).click();
        Thread.sleep(500);


        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://wordery.com/cs/terms_sale";

        assertEquals(actualURL,expectedURL);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my fourth test - Test MySettings")
    @Test
    public void TestMySettings() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.linkText("My Settings")).click();
        Thread.sleep(500);

        driver.findElements(By.className("c-i__select")).get(1).sendKeys("21");
        driver.findElements(By.className("c-i__select")).get(2).sendKeys("11");
        driver.findElements(By.className("c-i__select")).get(3).sendKeys("1994");

        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        String actual = driver.findElement(By.className("c-msg-box--success")).getText();
        String expected = "Your settings have been saved.";

        assertEquals(actual,expected);

        Thread.sleep(2000);

        driver.close();
    }

    @And("I start my fifth test - Test Subscribe Option")
    @Test
    public void TestSubscribe() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);

        driver.findElement(By.id("subscribe-to-newsletter-email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("subscribe-to-newsletter-confirm")).click();
        driver.findElement(By.id("subscribe-to-newsletter-tsandcs")).click();

        Thread.sleep(1000);

        driver.findElements(By.tagName("button")).get(14).sendKeys(Keys.ENTER);


        String actual = driver.findElement(By.className("c-msg-box--success")).getText();
        String expected = "Thanks for signing up!";

        assertEquals(actual,expected);

        Thread.sleep(2000);

        driver.close();
    }

}

/*
    Linkovi na knigi preku "Bestsellers" ne se testirani poradi toa sto istite dinamicki se menuvaat -
        skoro nevozmozno e da se napise tocen test dokolku istiot ne bide izvrsen odma
 */


/*
        Reusable code:

        System.setProperty("webdriver.chrome.driver", "D:\\Fakultet\\Proekti Programiranje\\Aips, OS, Skit\\SKiT\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://wordery.com/");

        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        driver.findElement(By.id("email")).sendKeys("dotnetapp111@gmail.com");
        driver.findElement(By.id("password")).sendKeys("dotnetapp222");
        driver.findElements(By.className("u-1/1-3cols")).get(1).sendKeys(Keys.ENTER);


        Thread.sleep(1000);



        Thread.sleep(2000);

        driver.close();
 */