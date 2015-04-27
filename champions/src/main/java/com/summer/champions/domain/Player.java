package com.summer.champions.domain;


import com.summer.common.domain.IdEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Created by Allen on 2015/3/14.
 */
@Entity
@DynamicUpdate(value = true)
@Table(name = "PLAYER")
public class Player extends IdEntity{

    public String name;

    public String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

