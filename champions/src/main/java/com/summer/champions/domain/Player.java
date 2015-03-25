package com.summer.champions.domain;


import com.summer.common.domain.IdEntity;

import javax.persistence.*;

/**
 * Created by Allen on 2015/3/14.
 */
@Entity
@Table(name = "PLAYER")
public class Player extends IdEntity{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    protected Long id;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

