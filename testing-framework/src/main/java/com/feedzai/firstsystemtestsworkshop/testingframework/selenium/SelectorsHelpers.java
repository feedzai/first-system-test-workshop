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
 * Class that contains the different Selectors used in the Selenium code to identify the page elements.
 * @implNote In this workshop we are using different strategies with the purpose of showing that they exist.
 * In a real project, we should work along side with the development team in a common strategy on how the
 * pages should be created and which elements could be used in the test automation.
 * E.g. we at Feedzai use a specific css class to identify elements that could be used in the automated tests.
 *
 *
 * @author Ricardo Lopes (ricardo.lopes@feedzai.com)
 */
public class SelectorsHelpers {

    /**
     * Private constructor.
     */
    private SelectorsHelpers () {}

    // Selector by generic css selector

    public static final String WELCOME_PAGE_LAYOUT_ELEMENT =  "layout-welcome";

    public static final String OWNER_NAME_LINK_IN_TABLE_ELEMENT =  "table td a";

    // Selectors by attribute

    public static final String TOP_MENU_BUTTON_ATTRIBUTE_NAME = "title";

    public static final String HOME_PAGE_BUTTON_ATTRIBUTE_VALUE =  "home page";

    public static final String VETERINARIANS_BUTTON_ATTRIBUTE_VALUE =  "veterinarians";


    // Selectors by label

    public static final String OWNERS_BUTTON_LABEL = "Owners";

    public static final String All_OWNERS_BUTTON_LABEL = "All";

    public static final String ADD_PET_BUTTON_LABEL = "Add New Pet";

    public static final String PET_NAME_INPUT_LABEL = "Name";

    public static final String PET_BIRTH_INPUT_LABEL = "Birth date";

    public static final String PET_TYPE_INPUT_LABEL = "Type";

    public static final String SUBMIT_PET_BUTTON_LABEL = "Submit";

    // Selectors by class

    public static final String GENERIC_BUTTON_CLASS = ".btn-default";

    public static final String FORM_INPUT_LOCATOR = ".form-group";

}
