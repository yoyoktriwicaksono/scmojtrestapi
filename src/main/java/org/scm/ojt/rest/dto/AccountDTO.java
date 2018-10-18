package org.scm.ojt.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * Created by Yoyok_T on 17/10/2018.
 */
@Data
public class AccountDTO extends BaseDTO {
    @ApiModelProperty(dataType = "java.lang.String" ,value = "Name", example = "Pemilik Account")
    private String name;

}
