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
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

/**
 * Screen that allow us to create Pets associated with a given owner.
 *
 * @author Ricardo Lopes (ricardo.lopes@feedzai.com)
 */
public class PetclinicPet {
    /**
     * Constructor that allow PetclinicPet instantiation.
     */
    public PetclinicPet() { }

    /**
     * Edits the Pet name.
     *
     * @param name the new name from the pet.
     */
    public void editName(final String name) {
        $$(SelectorsHelpers.FORM_INPUT_LOCATOR)
                .find(Condition.text(SelectorsHelpers.PET_NAME_INPUT_LABEL))
                .find("input")
                .sendKeys(name);
    }

    /**
     * Edits the Pet Birth date.
     * @implNote since PetClinic uses a Angular library that implements the calendar, we do not what to test the library
     * itself, and so we simply perform a {@link com.codeborne.selenide.SelenideElement#setValue(String)} that
     * will bypass the set of the date using the calendar.
     * We will assume that the library was already tested and the integration of the component should be
     * guaranteed by unit tests.
     *
     * @param birthdate the new birth date from the pet.
     */
    public void editBirthDate(final String birthdate) {
        $$(SelectorsHelpers.FORM_INPUT_LOCATOR)
                .find(Condition.text(SelectorsHelpers.PET_BIRTH_INPUT_LABEL))
                .find("input")
                .setValue(birthdate);
    }

    /**
     * Edits the Pet type.
     *
     * @param petType the type for the Pet.
     */
    public void editType(final String petType) {
        $$(SelectorsHelpers.FORM_INPUT_LOCATOR)
                .find(Condition.text(SelectorsHelpers.PET_TYPE_INPUT_LABEL))
                .find("select")
                .selectOption(petType);
    }

    /**
     * Clicks in submit button to create the Pet.
     */
    public void clickSubmit() {
        $$(SelectorsHelpers.GENERIC_BUTTON_CLASS).find(Condition.text(SelectorsHelpers.SUBMIT_PET_BUTTON_LABEL)).click();
    }
}
