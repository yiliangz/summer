package com.summer.champions.domain;


import com.summer.common.domain.IdEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Created by Allen on 2015/3/14.
 */
@Entity
@Table(name = "PLAYER")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Player extends IdEntity{

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

