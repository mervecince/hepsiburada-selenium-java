package org.hepsiburada.tests;

import org.apache.commons.io.FileUtils;
import org.hepsiburada.hook.Hook;
import org.hepsiburada.listener.Watcher;
import org.hepsiburada.pages.HomePage;
import org.hepsiburada.pages.ProductPage;
import org.hepsiburada.pages.SearchProductPage;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Scenarios extends Hook {

    @Rule
    public Watcher watcher = new Watcher();

    private HomePage homePage;
    private ProductPage productPage;
    private SearchProductPage searchProductPage;

    @BeforeClass
    public static void beforeClass() {
        hookBeforeClass();
    }

    @AfterClass
    public static void afterClass() {
        hookAfterClass();
    }

    @Before
    public void before() throws IOException {
        hookBefore();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        searchProductPage = new SearchProductPage(driver);
        FileUtils.deleteDirectory(new File(System.getProperty("user.dir") + "/screenshot"));
    }
    
    @Test
    public void hepsiBuradaCase() {
        homePage.waitPage();
        homePage.search("iphone");
        searchProductPage.clickWithIndexProduct(0);
        searchProductPage.switchToNewPage();
        productPage.clickEvaluationButton();
        productPage.clickThumbsUpButton();
        productPage.checkThankYouTextArea();
    }

    @After
    public void after() {
        hookAfter();
    }
}
