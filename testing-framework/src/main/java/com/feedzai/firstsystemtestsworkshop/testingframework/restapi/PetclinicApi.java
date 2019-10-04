/*
 * The copyright of this file belongs to Feedzai. The file cannot be
 * reproduced in whole or in part, stored in a retrieval system,
 * transmitted in any form, or by any means electronic, mechanical,
 * photocopying, or otherwise, without the prior permission of the owner.
 *
 * © 2019 Feedzai, Strictly Confidential
 */

package com.feedzai.firstsystemtestsworkshop.testingframework.restapi;

import com.google.common.collect.ImmutableMap;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

/**
 * Rest Assured implementation to call the PetClinic API.
 *
 * @author Ricardo Lopes (ricardo.lopes@feedzai.com)
 */
public class PetclinicApi {
    /**
     * Generic specification for the requests.
     */
    private final RequestSpecification spec;

    /**
     * Instantiation of PetClinic REST tests.
     *
     * <p>This constructor sets an initial configuration for the requests to be performed.
     *
     * @param address Address from the PetClinic service.
     * @param port    Port where the PetClinic service is running.
     */
    public PetclinicApi(final String address, final int port) {
        this.spec = new RequestSpecBuilder()
                .setBaseUri(String.format("http://%s", address))
                .setPort(port)
                .setContentType(ContentType.JSON)
                .build();
    }

    /**
     * Send a GET's request to the {@code endpoint}.
     *
     * @param endpoint The endpoint used to perform the request.
     * @param params   The parameters to send along with the request.
     * @return a response.
     */
    private ValidatableResponseOptions<ValidatableResponse, Response> get(
            final String endpoint,
            final Map<String, Object> params) {
        return RestAssured.given()
                .spec(this.spec)
                .params(params)
                .when()
                .get(endpoint)
                .then()
                .log().ifValidationFails();
    }

    /**
     * Sends a request to list all the owners registered in PetClinic.
     * @return a response with all the owners.
     */
    public ValidatableResponseOptions<ValidatableResponse, Response> listOwners() {
        return this.get("owners/list", ImmutableMap.<String, Object>of());
    }
}
