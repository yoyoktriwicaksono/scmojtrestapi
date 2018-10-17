package org.scm.ojt.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Yoyok_T on 17/10/2018.
 */
@Data
public abstract class BaseDTO {
    @ApiModelProperty(dataType = "java.lang.String" ,value = "id", required = true, example = "S001")
    private String id;

//    @ApiModelProperty(dataType = "java.lang.String" ,value = "version", required = true, example = "1")
//    private int version;
}
