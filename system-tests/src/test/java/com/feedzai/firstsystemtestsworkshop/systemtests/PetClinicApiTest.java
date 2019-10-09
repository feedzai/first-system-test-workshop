/*
 * The copyright of this file belongs to Feedzai. The file cannot be
 * reproduced in whole or in part, stored in a retrieval system,
 * transmitted in any form, or by any means electronic, mechanical,
 * photocopying, or otherwise, without the prior permission of the owner.
 *
 * © 2019 Feedzai, Strictly Confidential
 */

package com.feedzai.firstsystemtestsworkshop.systemtests;

import com.feedzai.firstsystemtestsworkshop.testingframework.common.Owner;
import com.feedzai.firstsystemtestsworkshop.testingframework.config.EnvironmentProperties;
import com.feedzai.firstsystemtestsworkshop.testingframework.restapi.PetclinicApi;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.HttpWaitStrategy;

import static org.hamcrest.CoreMatchers.hasItems;

/**
 * Tests for the PetClinic API.
 */
public class PetClinicApiTest {
    @ClassRule
    public static GenericContainer petclinic = new GenericContainer<>(EnvironmentProperties.PETCLINIC_DOCKER_IMAGE)
            .withExposedPorts(EnvironmentProperties.PETCLINIC_HTTP_PORT)
            .waitingFor(
                    new HttpWaitStrategy()
                            .forPort(EnvironmentProperties.PETCLINIC_HTTP_PORT)
                            .forStatusCode(HttpStatus.SC_OK));


    /**
     * PetClinic API to be used in the tests.
     */
    public static PetclinicApi petclinicApi;

    /**
     * Run before all tests.
     */
    @BeforeClass
    public static void beforeClass() {
        final int servicePort = petclinic.getMappedPort(EnvironmentProperties.PETCLINIC_HTTP_PORT);
        petclinicApi = new PetclinicApi(EnvironmentProperties.PETCLINIC_DEFAULT_HOST, servicePort);
    }

    /**
     * Call Rest API 'owners' endpoint to assert that the list of users works correctly and that a given user is returned.
     */
    @Test
    public void assertUsersList() {
        petclinicApi.listOwners().assertThat().body(
                "", hasItems(Matchers.hasEntry("firstName", "George"), Matchers.hasEntry("lastName", "Franklin"))
        );
    }

    /**
     * Call Rest API 'owners' endpoint to add a new user.
     */
    @Test
    public void addNewUser() {
        final Owner owner = Owner.builder()
                .firstName("John")
                .lastName("Doe")
                .address("Instituto Pedro Nunes")
                .city("Coimbra")
                .telephone("999999999").build();
        petclinicApi.addOwner(owner);

        petclinicApi.listOwners().assertThat().body(
                "", hasItems(
                        Matchers.hasEntry("firstName", owner.getFirstName()),
                        Matchers.hasEntry("lastName", owner.getLastName())
                )
        );
    }

    /**
     * Test the creation of users with invalid telephone numbers.
     * The following scenarios are validated:
     * <ul>
     *     <li>Null telephone number - not sent in the request</li>
     *     <li>Telephone number with letters</li>
     *     <li>Empty telephone number - sent in the request as empty string</li>
     *     <li>Upper bound telephone number - 11 digits</li>
     *     <li>Non digit / letters characters</li>
     * </ul>
     */
    @Test
    public void addNewUserInvalidTelephone() {
        final String missingTelephoneMessage = "must not be empty";
        final String invalidTelephoneFormatMessage = "numeric value out of bounds (<10 digits>.<0 digits> expected)";

        final Owner invalidTelephone = Owner.builder()
                .firstName("John")
                .lastName("Doe")
                .address("Instituto Pedro Nunes")
                .city("Coimbra")
                .build();

        petclinicApi.addOwnerAndAssertError(
                invalidTelephone,
                "telephone",
                missingTelephoneMessage,
                null);

        invalidTelephone.setTelephone("abc");
        petclinicApi.addOwnerAndAssertError(
                invalidTelephone,
                "telephone",
                invalidTelephoneFormatMessage,
                "abc");

        invalidTelephone.setTelephone("");
        petclinicApi.addOwnerAndAssertError(
                invalidTelephone,
                "telephone",
                invalidTelephoneFormatMessage,
                "");

        invalidTelephone.setTelephone("1234567891011");
        petclinicApi.addOwnerAndAssertError(
                invalidTelephone,
                "telephone",
                invalidTelephoneFormatMessage,
                "1234567891011");

        invalidTelephone.setTelephone("1.02");
        petclinicApi.addOwnerAndAssertError(
                invalidTelephone,
                "telephone",
                invalidTelephoneFormatMessage,
                "1.02");
    }

    /**
     * Test the creation of users with valid telephone numbers.
     * <ul>
     *     <li>Number of characters in the lower bound of 1 digit</li>
     *     <li>Number of characters in the upper bound of 10 digits</li>
     * </ul>
     */
    @Test
    public void validTelephone() {
        final Owner validOwner = Owner.builder()
                .firstName("owner 1")
                .lastName("owner 1")
                .address("Instituto Pedro Nunes")
                .city("Coimbra")
                .build();

        validOwner.setTelephone("1");
        petclinicApi.addOwner(validOwner).assertThat().statusCode(HttpStatus.SC_CREATED);

        validOwner.setTelephone("1234567890");
        petclinicApi.addOwner(validOwner).assertThat().statusCode(HttpStatus.SC_CREATED);
    }
}