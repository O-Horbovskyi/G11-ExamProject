package org.spellsPageTests;

import org.baseTest.BaseTest;
import org.junit.Test;

public class SpellsPageTests extends BaseTest {

    @Test
    public void T005_SpellsPageTabsTest() {
        pageProvider.getSpellsPage()
                .openPage()
                .clickOnThirdLevelSpellTab()
                .checkIsFireballSpellVisible();
    }
}
