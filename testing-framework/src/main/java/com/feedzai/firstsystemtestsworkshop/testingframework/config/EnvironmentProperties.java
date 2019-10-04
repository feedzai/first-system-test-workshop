/*
 * The copyright of this file belongs to Feedzai. The file cannot be
 * reproduced in whole or in part, stored in a retrieval system,
 * transmitted in any form, or by any means electronic, mechanical,
 * photocopying, or otherwise, without the prior permission of the owner.
 *
 * © 2019 Feedzai, Strictly Confidential
 */

package com.feedzai.firstsystemtestsworkshop.testingframework.config;

/**
 *  Set of properties used in the setup of the Testing Environment.
 *
 *  @author Ricardo Lopes (ricardo.lopes@feedzai.com)
 */
public class EnvironmentProperties {
    /**
     * Name from Docker image from PetClinic app.
     * This docker image runs the Spring Boot version of the PetClinic application build with Angular.
     * See https://hub.docker.com/r/arey/springboot-petclinic/ for more details.
     */
    public static final String PETCLINIC_DOCKER_IMAGE = "arey/springboot-petclinic";
    /**
     * Hostname used by the selenium tests when run with test-containers.
     * See https://docs.docker.com/docker-for-mac/networking/#known-limitations-use-cases-and-workarounds.
     */
    public static final String HOSTNAME = "host.docker.internal";
    /**
     * Default port where PetClinic app is listening inside the container.
     */
    public static final int PETCLINIC_HTTP_PORT = 8080;

    /**
     * Private constructor to avoid instantiation.
     */
    private EnvironmentProperties() { }
}
