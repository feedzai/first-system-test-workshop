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

import static com.codeborne.selenide.Selenide.$$;

/**
 * Screen that allow us to search for PetclinicOwnersList.
 *
 * @author Ricardo Lopes (ricardo.lopes@feedzai.com)
 */
public class PetclinicOwnersList {
    /**
     * Endpoint for the {@link PetclinicOwnerInfo}.
     */
    private PetclinicOwnerInfo ownersInfoPage = new PetclinicOwnerInfo();

    /**
     * Constructor that allow PetclinicOwnersList  instantiation.
     */
    public PetclinicOwnersList() { }

    /**
     * Assert that a given owner name is displayed in the owners list.
     *
     * @param ownerName the name from the owner to be asserted.
     */
    public void assertOwnerDisplayedInTable(final String ownerName) {
        $$(SelectorsHelpers.OWNER_NAME_LINK_IN_TABLE_ELEMENT).find(Condition.text(ownerName)).exists();
    }

    /**
     * Click in the Owner with the given name.
     *
     * @param ownerName the name from the owner to be clicked.
     */
    public void clickOwnerName(final String ownerName) {
        $$(SelectorsHelpers.OWNER_NAME_LINK_IN_TABLE_ELEMENT).find(Condition.text(ownerName)).click();
    }

    /**
     * Asserts that the owner is associated with the given pet.
     *
     * @param ownerName the name from the owner.
     * @param ownerName the name from the pet associated with the owner.
     */
    public void assertPetFromOwner(final String ownerName, final String petName) {
        $$(SelectorsHelpers.OWNER_NAME_LINK_IN_TABLE_ELEMENT)
                .find(Condition.text(ownerName))
                .parent().parent()
                .$$("td").get(4).shouldHave(Condition.matchesText(petName));
    }

    /**
     * Provide access to the {@link PetclinicOwnerInfo} endpoint.
     * @return the {@link PetclinicOwnerInfo} page.
     */
    public PetclinicOwnerInfo info() {
        return ownersInfoPage;
    }
}
