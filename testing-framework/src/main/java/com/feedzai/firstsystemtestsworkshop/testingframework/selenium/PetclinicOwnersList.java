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
}
