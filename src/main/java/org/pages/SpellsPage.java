package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.data.TestData.HOMEPAGE_URL;
import static org.data.TestData.SPELLS_PAGE_URL;

public class SpellsPage extends ParentPage{

    public SpellsPage(WebDriver webDriver) {
        super(webDriver);
    }

    private Logger logger = Logger.getLogger(getClass());


    @FindBy(xpath = "//a[text()='Fireball']")
    private WebElement fireballSpell;
    String fireballSpellLocator = "//a[text()='Fireball']";

    @FindBy(xpath = "//a[em[text()='3rd Level']]")
    private WebElement thirdLevelSpellTab;
    String thirdLevelSpellTabLocator = "//a[em[text()='3rd Level']]";

    public SpellsPage openPage() {
        webDriver.get(SPELLS_PAGE_URL);
        logger.info("Login Page was opened with URL " + SPELLS_PAGE_URL);
        return this;
    }

    public SpellsPage clickOnThirdLevelSpellTab() {
        clickOnElement(thirdLevelSpellTabLocator);
        logger.info("Clicked on Third Level Spell Tab");
        return this;
    }

    public void checkIsFireballSpellVisible() {
        checkIsElementVisible(fireballSpellLocator);
        logger.info("Fireball Spell is visible");
    }
}
