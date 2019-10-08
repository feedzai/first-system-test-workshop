/*
 * The copyright of this file belongs to Feedzai. The file cannot be
 * reproduced in whole or in part, stored in a retrieval system,
 * transmitted in any form, or by any means electronic, mechanical,
 * photocopying, or otherwise, without the prior permission of the owner.
 *
 * © 2019 Feedzai, Strictly Confidential
 */

package com.feedzai.firstsystemtestsworkshop.testingframework.selenium;

import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;

/**
 * Top menu in the PetClinic application.
 * The users uses this to navigate between the different screens of the application.
 *
 * @author Ricardo Lopes (ricardo.lopes@feedzai.com)
 */
public class PetclinicMenu {
    /**
     * Constructor that allow PetclinicMenu instantiation.
     */
    public PetclinicMenu() { }

    /**
     * Click in the home button.
     */
    public void clickHomeButton() {
        $(Selectors.byAttribute(
                SelectorsHelpers.TOP_MENU_BUTTON_ATTRIBUTE_NAME,
                SelectorsHelpers.HOME_PAGE_BUTTON_ATTRIBUTE_VALUE)
        ).click();
    }

    /**
     * Click list all Owners.
     */
    public void clickListOwners() {
        $(Selectors.byText(SelectorsHelpers.OWNERS_BUTTON_LABEL)).click();
        $(Selectors.byText(SelectorsHelpers.All_OWNERS_BUTTON_LABEL)).click();
    }
}
