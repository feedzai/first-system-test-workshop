/*
 * The copyright of this file belongs to Feedzai. The file cannot be
 * reproduced in whole or in part, stored in a retrieval system,
 * transmitted in any form, or by any means electronic, mechanical,
 * photocopying, or otherwise, without the prior permission of the owner.
 *
 * © 2019 Feedzai, Strictly Confidential
 */

package com.feedzai.firstsystemtestsworkshop.testingframework.selenium;

/**
 * Screen that show the information from a given Owner.
 *
 * @author Ricardo Lopes (ricardo.lopes@feedzai.com)
 */
public class PetclinicOwnerInfo {
    /**
     * Endpoint for the {@link PetclinicPet} that allow us to create a Pet associated with a Owner.
     */
    private PetclinicPet petclinicPet = new PetclinicPet();

    /**
     * Constructor that allow PetclinicOwners instantiation.
     */
    public PetclinicOwnerInfo() { }

    /**
     * Clicks in add new Pet button.
     */
    public void clickAddNewPet() {
        GenericElementHandlers.clickButton(SelectorsHelpers.ADD_PET_BUTTON_LABEL);
    }

    /**
     * Provide access to the {@link PetclinicPet} endpoint for a new Pet creation.
     * @return the {@link PetclinicPet} page.
     */
    public PetclinicPet pet() {
        return petclinicPet;
    }
}
