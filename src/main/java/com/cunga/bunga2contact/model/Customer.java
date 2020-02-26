package com.cunga.bunga2contact.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Customer {

    private final UUID id;
    private final String name;
    private final String surname;

    public Customer(@JsonProperty("id") UUID id,
                    @JsonProperty("name") String name,
                    @JsonProperty("surname") String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
