/*
 * The copyright of this file belongs to Feedzai. The file cannot be
 * reproduced in whole or in part, stored in a retrieval system,
 * transmitted in any form, or by any means electronic, mechanical,
 * photocopying, or otherwise, without the prior permission of the owner.
 *
 * © 2019 Feedzai, Strictly Confidential
 */

package com.feedzai.firstsystemtestsworkshop.systemtests;

import com.feedzai.firstsystemtestsworkshop.testingframework.config.EnvironmentProperties;
import com.feedzai.firstsystemtestsworkshop.testingframework.selenium.PetclinicSelenium;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests for the PetClinic GUI.
 */
public class PetclinicSeleniumTest {
    /**
     * PelClinic Selenium implementation.
     */
    PetclinicSelenium petclinicSelenium = new PetclinicSelenium(
            EnvironmentProperties.PETCLINIC_HOST, EnvironmentProperties.PETCLINIC_HTTP_PORT);

    @Test
    @Ignore("We are not integrated with test containers, environment needs to be bootstrapped manually.")
    public void assertUsersList() {
        petclinicSelenium.menu().clickHomeButton();
        petclinicSelenium.menu().clickListOwners();
        petclinicSelenium.owners().assertOwnerDisplayedInTable("George Franklin");
    }
}
