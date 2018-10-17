package org.scm.ojt.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.scm.ojt.rest.entity.Account;
import org.scm.ojt.rest.entity.Address;

import java.util.List;

/**
 * Created by Yoyok_T on 17/10/2018.
 */
@ApiModel(description = "Supplier Entity")
@Data
public class CustomerDTO extends BaseDTO {
    @ApiModelProperty(dataType = "java.lang.String" ,value = "Name", required = true, example = "Nama Customer")
    private String Name;
    private List<Account> accounts;
    private Address address;
}
