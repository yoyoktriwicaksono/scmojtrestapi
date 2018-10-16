package org.scm.ojt.rest.entity;

import org.mongodb.morphia.annotations.Entity;

/**
 * Created by Yoyok_T on 16/10/2018.
 */
@Entity
public class Account extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
