package org.scm.ojt.rest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mongodb.morphia.annotations.*;

/**
 * Created by Yoyok_T on 11/10/2018.
 */
@ApiModel(description = "Supplier Entity")
@Entity(value = "Supplier", noClassnameStored = true)
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

}
