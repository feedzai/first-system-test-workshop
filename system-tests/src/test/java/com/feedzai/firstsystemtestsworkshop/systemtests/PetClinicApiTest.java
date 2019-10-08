/*
 * The copyright of this file belongs to Feedzai. The file cannot be
 * reproduced in whole or in part, stored in a retrieval system,
 * transmitted in any form, or by any means electronic, mechanical,
 * photocopying, or otherwise, without the prior permission of the owner.
 *
 * © 2019 Feedzai, Strictly Confidential
 */

package com.feedzai.firstsystemtestsworkshop.systemtests;

import com.feedzai.firstsystemtestsworkshop.testingframework.config.EnvironmentProperties;
import com.feedzai.firstsystemtestsworkshop.testingframework.restapi.PetclinicApi;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.HttpWaitStrategy;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;

import java.util.Map;

import static org.hamcrest.CoreMatchers.hasItems;

/**
 * Tests for the PetClinic API.
 */
public class PetClinicApiTest {
    /**
    @Rule
    public GenericContainer petclinic = new GenericContainer<>(EnvironmentProperties.PETCLINIC_DOCKER_IMAGE)
            .withExposedPorts(EnvironmentProperties.PETCLINIC_HTTP_PORT)
            .waitingFor(
                    new HttpWaitStrategy()
                            .forPort(EnvironmentProperties.PETCLINIC_HTTP_PORT)
                            .forStatusCode(HttpStatus.SC_OK));
    **/


    /**
     * PetClinic API to be used in the tests.
     */
    public static PetclinicApi petclinicApi;

    /**
     * Run before all tests.
     */
    @BeforeClass
    public static void beforeClass() {
        //servicePort = petclinic.getMappedPort(EnvironmentProperties.PETCLINIC_HTTP_PORT);
        petclinicApi = new PetclinicApi(EnvironmentProperties.PETCLINIC_DEFAULT_HOST, 8080);
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
        Map<String, String> owner = ImmutableMap.of(
                "firstName", "John",
                "lastName", "Dow",
                "address", "Instituto Pedro Nunes",
                "city", "Coimbra",
                "telephone", "999999999");

        petclinicApi.addOwner(owner);

        petclinicApi.listOwners().assertThat().body(
                "", hasItems(Matchers.hasEntry("firstName", "John"), Matchers.hasEntry("lastName", "Dow"))
        );
    }
}