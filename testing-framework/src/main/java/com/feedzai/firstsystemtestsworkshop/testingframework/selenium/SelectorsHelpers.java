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
}
