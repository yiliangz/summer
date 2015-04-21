package com.summer.common.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Allen on 2015/4/12.
 */
@Entity
@Table(name = "PHONE")
public class Phone extends IdEntity{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
