package com.feedzai.firstsystemtestsworkshop.testingframework.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Representation for the Owner object model.
 * We are using lombok that allow us to easily create with boilerplate code in Java.
 * In this case, we are able to create a Builder, and set getters and setters for the object with a single annotation.
 * Builders are useful to write test data in a clear way,
 * see https://testing.googleblog.com/2018/02/testing-on-toilet-cleanly-create-test.html.
 *
 */
@Builder
@Getter
@Setter
public class Owner {
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("address")
    private String address;
    @JsonProperty("city")
    private String city;
    @JsonProperty("telephone")
    private String telephone;

    /**
     * Return the Full name from the Owner.
     * @return the value from {@link #firstName} and {@link #lastName} separated by a space.
     */
    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
