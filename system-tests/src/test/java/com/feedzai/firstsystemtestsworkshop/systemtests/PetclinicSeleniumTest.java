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
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.HttpWaitStrategy;

import java.util.logging.Logger;

/**
 * Tests for the PetClinic GUI.
 */
public class PetclinicSeleniumTest {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @ClassRule
    public static GenericContainer petclinic = new GenericContainer<>(EnvironmentProperties.PETCLINIC_DOCKER_IMAGE)
            .withExposedPorts(EnvironmentProperties.PETCLINIC_HTTP_PORT)
            .waitingFor(
                    new HttpWaitStrategy()
                            .forPort(EnvironmentProperties.PETCLINIC_HTTP_PORT)
                            .forStatusCode(HttpStatus.SC_OK));


    @ClassRule
    public static BrowserWebDriverContainer chrome =
            new BrowserWebDriverContainer()
                    .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.SKIP, null)
                    .withCapabilities(new ChromeOptions());

    /**
     * PelClinic Selenium implementation.
     */
    public static PetclinicSelenium petclinicSelenium;

    /**
     * PetClinic API to be used in the tests.
     */
    public static PetclinicApi petclinicApi;

    @BeforeClass
    public static void beforeClass() {
        LOGGER.info("VNC address for Chrome container: " + chrome.getVncAddress());
        petclinicSelenium = new PetclinicSelenium(
                chrome.getWebDriver(),
                EnvironmentProperties.TEST_CONTAINERS_SELENIUM_HOSTNAME,
                petclinic.getMappedPort(EnvironmentProperties.PETCLINIC_HTTP_PORT)
        );
        petclinicApi = new PetclinicApi(
                EnvironmentProperties.PETCLINIC_DEFAULT_HOST,
                petclinic.getMappedPort(EnvironmentProperties.PETCLINIC_HTTP_PORT)
        );
    }

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
