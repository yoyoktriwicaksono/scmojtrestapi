package org.scm.ojt.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Yoyok_T on 18/10/2018.
 */
@Data
public class AddressDTO {
    @ApiModelProperty(dataType = "java.lang.String" ,value = "10", example = "Address number")
    private String number;
    @ApiModelProperty(dataType = "java.lang.String" ,value = "Street", example = "Address Street")
    private String street;
    @ApiModelProperty(dataType = "java.lang.String" ,value = "Town", example = "Address Town")
    private String town;
    @ApiModelProperty(dataType = "java.lang.String" ,value = "734523", example = "Address Postcode")
    private String postcode;

}
