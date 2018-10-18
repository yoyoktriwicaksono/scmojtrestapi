package org.scm.ojt.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Yoyok_T on 18/10/2018.
 */
@Data
public class CustomerDTO extends BaseDTO {
    private String name;

    private String phoneNumber;

    private String email;

    private AddressDTO address;

    @JsonCreator
    public CustomerDTO(){

    }

    @JsonCreator
    public CustomerDTO(
            @JsonProperty("id") final String id,
            @JsonProperty("version") final Long version,
            @JsonProperty("name") final String name,
            @JsonProperty("phoneNumber") final String phoneNumber,
            @JsonProperty("email") final String email,
            @JsonProperty("address") final AddressDTO address
    ){
        this.id = id;
        this.version = version;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

}
