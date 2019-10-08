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
import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.HttpWaitStrategy;

import static org.hamcrest.CoreMatchers.hasItems;

/**
 * Tests for the PetClinic API.
 */
public class PetClinicApiTest {
    @Rule
    public GenericContainer petclinic = new GenericContainer<>(EnvironmentProperties.PETCLINIC_DOCKER_IMAGE)
            .withExposedPorts(EnvironmentProperties.PETCLINIC_HTTP_PORT)
            .waitingFor(
                    new HttpWaitStrategy()
                            .forPort(EnvironmentProperties.PETCLINIC_HTTP_PORT)
                            .forStatusCode(HttpStatus.SC_OK));

    /**
     * Call Rest API 'owners' endpoint to assert that the list of users works correctly and that a given user is returned.
     */
    @Test
    public void assertUsersList() {
        final int servicePort = petclinic.getMappedPort(EnvironmentProperties.PETCLINIC_HTTP_PORT);

        final PetclinicApi petclinicApi = new PetclinicApi(EnvironmentProperties.PETCLINIC_HOST, servicePort);

        petclinicApi.listOwners().assertThat().body(
                "", hasItems(Matchers.hasEntry("firstName", "George"), Matchers.hasEntry("lastName", "Franklin"))
        );
    }
}