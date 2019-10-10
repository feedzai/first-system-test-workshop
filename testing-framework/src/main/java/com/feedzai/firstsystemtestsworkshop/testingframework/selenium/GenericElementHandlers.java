package com.feedzai.firstsystemtestsworkshop.testingframework.selenium;

import com.codeborne.selenide.Condition;

import javax.swing.text.html.HTML;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Class that contain a set of common elements used across different screens of the PetClinic application.
 * <ul>
 *     <li>Text Input elements</li>
 *     <li>Buttons</li>
 *     <li>Calendar</li>
 *     <li>Selects</li>
 * </ul>
 *
 *
 * @author Ricardo Lopes (ricardo.lopes@feedzai.com)
 */
public class GenericElementHandlers {
    /**
     * Private constructor.
     */
    private GenericElementHandlers() {}

    /**
     * Edits the text input element.
     *
     * @param label the label that identify the text input.
     * @param value the value to be sent using the {@link org.openqa.selenium.WebElement#sendKeys(CharSequence...)}
     *              to the input.
     */
    public static void editInput(final String label, final String value) {
        $$(SelectorsHelpers.FORM_INPUT_LOCATOR)
                .find(Condition.text(label))
                .find(HTML.Tag.INPUT.toString())
                .sendKeys(value);
    }

    /**
     * Edits an input area by setting its value.
     *
     * @implNote this method is useful e.g. in order to manage the Calendar input fields we have in the application.
     * Since PetClinic uses a Angular library that implements the calendar, we do not what to test the library
     * itself, and so we simply perform a {@link com.codeborne.selenide.SelenideElement#setValue(String)} that
     * will bypass the set of the date using the calendar.
     * We will assume that the library was already tested and the integration of the component should be
     * guaranteed by unit tests.
     *
     * @param label the label that identifies the input element.
     * @param value the value to be set in the input.
     */
    public static void editValue(final String label, final String value) {
        $$(SelectorsHelpers.FORM_INPUT_LOCATOR)
                .find(Condition.text(label))
                .find(HTML.Tag.INPUT.toString())
                .setValue(value);
    }

    /**
     * Edits the Select element by selecting one of the available options.
     *
     * @param label the label that identifies the select element.
     * @param value the value to be selected.
     */
    public static void editSelect(final String label, final String value) {
        $$(SelectorsHelpers.FORM_INPUT_LOCATOR)
                .find(Condition.text(label))
                .find(HTML.Tag.SELECT.toString())
                .selectOption(value);
    }

    /**
     * Clicks in a generic button.
     *
     * @param label the label from the button to be clicked.
     */
    public static void clickButton(final String label) {
        $$(SelectorsHelpers.GENERIC_BUTTON_CLASS).find(Condition.text(label)).click();
    }
}
