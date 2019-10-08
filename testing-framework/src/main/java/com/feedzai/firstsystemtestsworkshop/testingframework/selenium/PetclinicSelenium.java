/*
 * The copyright of this file belongs to Feedzai. The file cannot be
 * reproduced in whole or in part, stored in a retrieval system,
 * transmitted in any form, or by any means electronic, mechanical,
 * photocopying, or otherwise, without the prior permission of the owner.
 *
 * © 2019 Feedzai, Strictly Confidential
 */

package com.feedzai.firstsystemtestsworkshop.testingframework.selenium;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

/**
 * Main class that contains the endpoints from all screens in PetClinic application
 * that Selenide can interact with.
 *
 * @author Ricardo Lopes (ricardo.lopes@feedzai.com)
 */
public class PetclinicSelenium {
    /**
     * Url used when the browser is open by the Webdriver.
     */
    private String url;
    /**
     * Endpoint for the {@link PetclinicMenu}.
     */
    private PetclinicMenu petclinicMenu = new PetclinicMenu();
    /**
     * Endpoint for the {@link PetclinicOwners}.
     */
    private PetclinicOwners ownersPage = new PetclinicOwners();

    /**
     * The constructor for the Selenide implementation of the PetClinic application.
     *
     * @param webdriver web driver instance to be used if the tests will run against a docker container.
     * @param hostname  the host name where PetClinic is available.
     * @param port      the port where PetClinic is available.
     */
    public PetclinicSelenium(final WebDriver webdriver, final String hostname, final int port) {
        this.url = String.format("http://%s:%s/", hostname, port);
        WebDriverRunner.setWebDriver(webdriver);
        Selenide.open(url);
        assertHomePage();
    }

    /**
     * The constructor for the Selenide implementation of the PetClinic application.
     *
     * @param hostname  the host name where PetClinic is available.
     * @param port      the port where PetClinic is available.
     */
    public PetclinicSelenium(final String hostname, final int port) {
        this.url = String.format("http://%s:%s/", hostname, port);
        Selenide.open(url);
        assertHomePage();
    }

    /**
     * Asserts that the expected 'Welcome message' is displayed in the PetClinic homepage.
     */
    public void assertHomePage() {
        Selenide.$(SelectorsHelpers.WELCOME_PAGE_LAYOUT_ELEMENT).shouldHave(Condition.text("Welcome to Petclinic"));
    }

    /**
     * Provide access to the {@link PetclinicMenu} endpoint.
     * @return the {@link PetclinicMenu}.
     */
    public PetclinicMenu menu() {
        return petclinicMenu;
    }

    /**
     * Provide access to the {@link PetclinicOwners} endpoint.
     * @return the {@link PetclinicOwners} page.
     */
    public PetclinicOwners owners() {
        return ownersPage;
    }

}
