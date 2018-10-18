package org.scm.ojt.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.scm.ojt.rest.entity.Account;
import org.scm.ojt.rest.entity.Address;

import java.util.List;
import java.util.UUID;

/**
 * Created by Yoyok_T on 17/10/2018.
 */
@ApiModel(description = "Supplier Entity")
@Data
public class CustomerDTO extends BaseDTO {
    @ApiModelProperty(dataType = "java.lang.String" ,value = "Name", required = true, example = "Nama Customer")
    private String name;
    private List<AccountDTO> accounts;
    private AddressDTO address;

    @JsonCreator
    public CustomerDTO(){
    }

    @JsonCreator
    public CustomerDTO(
            @JsonProperty("id") final String id,
            @JsonProperty("name") final String name,
            @JsonProperty("accounts") final List<AccountDTO> accounts,
            @JsonProperty("address") final AddressDTO address
    ) {
        this.setId(id);
        this.setName(name);
        this.setAccounts(accounts);
        this.setAddress(address);
    }
}
