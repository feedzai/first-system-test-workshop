package com.feedzai.firstsystemtestsworkshop.testingframework.config;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import org.testcontainers.DockerClientFactory;

import java.util.List;

/**
 *  Docker client helper with functions that allow us to manage the Docker Environment running
 *  in the host machine.
 *
 *  @author Ricardo Lopes (ricardo.lopes@feedzai.com)
 */
public class DockerClientHelper {
    /**
     * Private constructor.
     */
    private DockerClientHelper() { }

    /**
     * Get the IP from the Docker Container based on the given container id.
     *
     * @param containerId the id from the docker container.
     */
    public String getIpFromDockerContainer(final String containerId) {
        final DockerClient client = DockerClientFactory.instance().client();
        final List<Container> containers = client.listContainersCmd().withShowAll(true).exec();
        final Container container1 = containers.stream().filter(
                container -> container.getId().equals(containerId)
        ).findFirst().get();

        return container1.getNetworkSettings().getNetworks().get("bridge").getGateway();
    }
}
