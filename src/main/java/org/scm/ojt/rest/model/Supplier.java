package org.scm.ojt.rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

/**
 * Created by Yoyok_T on 11/10/2018.
 */
//@ApiModel(description = "Supplier Entity")
@Entity(value = "supplier", noClassnameStored = true)
@Indexes(
        @Index(value = "SupplierID", fields = @Field("SupplierID"))
)
@Data
@EqualsAndHashCode(callSuper = false)
public class Supplier extends BaseCollection {

    @ApiModelProperty(value = "SupplierID", required = true, example = "S001")
    @Property("supplierID")
    private String SupplierID;

    @ApiModelProperty(value = "Name", required = true, example = "Supplier Name")
    @Property("name")
    private String Name;

    @ApiModelProperty(value = "Address", required = false, example = "Supplier Address")
    @Property("address")
    private String Address;

    @ApiModelProperty(value = "City", required = false, example = "Supplier City")
    @Property("city")
    private String City;

    @ApiModelProperty(value = "Phone", required = false, example = "Supplier Phone")
    @Property("phone")
    private String Phone;

//    @JsonCreator
//    public Supplier(
//            @JsonProperty("id") final ObjectId id,
//            @JsonProperty("supplierID") final String supplierID,
//            @JsonProperty("name") final String name,
//            @JsonProperty("address") final String address,
//            @JsonProperty("city") final String city,
//            @JsonProperty("phone") final String phone
//    ) {
//        this.id = id;
//        this.SupplierID = supplierID;
//        this.Name = name;
//        this.Address = address;
//        this.City = city;
//        this.Phone = phone;
//    }

}
