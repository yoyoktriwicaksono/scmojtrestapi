package org.scm.ojt.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.mongodb.morphia.annotations.Property;

import java.util.UUID;

/**
 * Created by Yoyok_T on 12/10/2018.
 */
@ApiModel(description = "Supplier")
@Data
public class SupplierDTO {
    @ApiModelProperty(dataType = "java.lang.String", value = "unique identifier", required = true, example = "89a1e095-1f42-4a1f-bde0-1824f3487538")
    private String id;

    @ApiModelProperty(value = "SupplierID", required = true, example = "S001")
    private String SupplierID;

    @ApiModelProperty(value = "Name", required = true, example = "Yoyok Tri Wicaksono")
    private String Name;

    @ApiModelProperty(value = "Address", required = false, example = "Jl. Juanda 100 Dago")
    private String Address;

    @ApiModelProperty(value = "City", required = false, example = "Bandung")
    private String City;

    @ApiModelProperty(value = "Phone", required = false, example = "0835236356")
    private String Phone;

    @JsonCreator
    public SupplierDTO(
        @JsonProperty("id") final String id,
        @JsonProperty("supplierID") final String supplierID,
        @JsonProperty("name") final String name,
        @JsonProperty("address") final String address,
        @JsonProperty("city") final String city,
        @JsonProperty("phone") final String phone
    ) {
        this.id = id;
        this.SupplierID = supplierID;
        this.Name = name;
        this.Address = address;
        this.City = city;
        this.Phone = phone;
    }

}
