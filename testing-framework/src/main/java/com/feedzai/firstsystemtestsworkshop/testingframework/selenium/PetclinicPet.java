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
        GenericElementHandlers.editInput(SelectorsHelpers.PET_NAME_INPUT_LABEL, name);
    }

    /**
     * Edits the Pet Birth date.
     *
     * @param birthdate the new birth date from the pet.
     */
    public void editBirthDate(final String birthdate) {
        GenericElementHandlers.editValue(SelectorsHelpers.PET_BIRTH_INPUT_LABEL, birthdate);
    }

    /**
     * Edits the Pet type.
     *
     * @param petType the type for the Pet.
     */
    public void editType(final String petType) {
        GenericElementHandlers.editSelect(SelectorsHelpers.PET_TYPE_INPUT_LABEL, petType);
    }

    /**
     * Clicks in submit button to create the Pet.
     */
    public void clickSubmit() {
        GenericElementHandlers.clickButton(SelectorsHelpers.SUBMIT_PET_BUTTON_LABEL);
    }
}
