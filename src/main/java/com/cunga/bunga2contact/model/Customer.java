package com.cunga.bunga2contact.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

public class Customer {

    private final UUID id;
    private final String name;
    private final String surname;

    @JsonFormat(pattern="yyyy-MM-dd")
    private final Date dateOfBirth;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postCode;
    private String emailAddress;
    private String phoneNumber;


    public Customer(@JsonProperty("id") UUID id,
                    @JsonProperty("name") String name,
                    @JsonProperty("surname") String surname,
                    @JsonProperty("dateOfBirth") Date dateOfBirth,
                    @JsonProperty("addressLine1") String addressLine1,
                    @JsonProperty("addressLine2") String addressLine2,
                    @JsonProperty("city") String city,
                    @JsonProperty("state") String state,
                    @JsonProperty("postCode") String postCode,
                    @JsonProperty("emailAddress") String emailAddress,
                    @JsonProperty("phoneNumber") String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }
    @NotBlank
    public String getName() {
        return name;
    }
    @NotBlank
    public String getSurname() {
        return surname;
    }

    @NonNull
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


}
