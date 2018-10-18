package org.scm.ojt.rest.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
//import org.bson.types.ObjectId;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Version;

/**
 * Created by Wicaksono on 10/11/2018.
 */
@Data
public abstract class BaseCollection {
    @Id
    @Property("id")
    @ApiModelProperty(dataType = "java.lang.String", value = "unique identifier", required = true, example = "89a1e095-1f42-4a1f-bde0-1824f3487538")
    protected ObjectId id;

    @Version
    @Property("version")
    @ApiModelProperty(dataType = "java.lang.String", value = "unique identifier", required = false, example = "1")
    protected Long version;

    protected String getObjectId(){
        return getId().toString();
    }

}
