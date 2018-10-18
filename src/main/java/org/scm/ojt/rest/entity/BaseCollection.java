package org.scm.ojt.rest.entity;

import lombok.Data;
import org.bson.types.ObjectId;
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
    private ObjectId id;

    @Version
    @Property("version")
    private Long version;

//    public String getID(){
//        return getID().toString();
//    }

}
