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

import static com.codeborne.selenide.Selenide.$;

/**
 * Screen that allow us to search for PetclinicOwners.
 *
 * @author Ricardo Lopes (ricardo.lopes@feedzai.com)
 */
public class PetclinicOwners {
    /**
     * Constructor that allow PetclinicOwners  instantiation.
     */
    public PetclinicOwners() { }

    /**
     * Assert that a given owner name is displayed in the owners list.
     *
     * @param ownerName the name from the owner to be asserted.
     */
    public void assertOwnerDisplayedInTable(final String ownerName) {
        $("table a").shouldHave(Condition.text(ownerName));
    }
}
