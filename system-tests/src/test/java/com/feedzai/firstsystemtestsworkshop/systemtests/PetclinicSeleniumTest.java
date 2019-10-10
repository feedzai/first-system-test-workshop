/*
 * The copyright of this file belongs to Feedzai. The file cannot be
 * reproduced in whole or in part, stored in a retrieval system,
 * transmitted in any form, or by any means electronic, mechanical,
 * photocopying, or otherwise, without the prior permission of the owner.
 *
 * © 2019 Feedzai, Strictly Confidential
 */

package com.feedzai.firstsystemtestsworkshop.systemtests;

import com.feedzai.firstsystemtestsworkshop.testingframework.common.Owner;
import com.feedzai.firstsystemtestsworkshop.testingframework.config.EnvironmentProperties;
import com.feedzai.firstsystemtestsworkshop.testingframework.restapi.PetclinicApi;
import com.feedzai.firstsystemtestsworkshop.testingframework.selenium.PetclinicSelenium;
import org.junit.Test;

/**
 * Tests for the PetClinic GUI.
 */
public class PetclinicSeleniumTest {
    /**
     * PelClinic Selenium implementation.
     */
    PetclinicSelenium petclinicSelenium = new PetclinicSelenium(
            EnvironmentProperties.PETCLINIC_DEFAULT_HOST, EnvironmentProperties.PETCLINIC_HTTP_PORT);

    /**
     * PetClinic API to be used in the tests to create resources easily.
     */
    public PetclinicApi petclinicApi = new PetclinicApi(
            EnvironmentProperties.PETCLINIC_DEFAULT_HOST,
            EnvironmentProperties.PETCLINIC_HTTP_PORT);

    /**
     * Uses Selenium to navigate to the owners page and assert that the users list presented contain the given user.
     */
    @Test
    public void assertUsersList() {
        petclinicSelenium.menu().clickHomeButton();
        petclinicSelenium.menu().clickListOwners();
        petclinicSelenium.owners().assertOwnerDisplayedInTable("George Franklin");
    }

    /**
     * Uses Selenium to create a new Pet in the PetClinic and associate it with an existent Owner.
     */
    @Test
    public void addPetToOwner() {
        final Owner owner = Owner.builder()
                .firstName("Selenium")
                .lastName("Owner")
                .address("Selenium Address")
                .city("Selenium City")
                .telephone("999999999").build();
        petclinicApi.addOwner(owner);

        petclinicSelenium.menu().clickListOwners();
        petclinicSelenium.owners().clickOwnerName(owner.getFullName());
        petclinicSelenium.owners().info().clickAddNewPet();
        petclinicSelenium.owners().info().pet().editName("boby");
        petclinicSelenium.owners().info().pet().editBirthDate("01/01/2019");
        petclinicSelenium.owners().info().pet().editType("dog");
        petclinicSelenium.owners().info().pet().clickSubmit();
        petclinicSelenium.menu().clickListOwners();
        petclinicSelenium.owners().assertPetFromOwner(owner.getFullName(), "boby");
    }
}
