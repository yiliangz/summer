package com.summer.spider.domain;

import com.summer.common.domain.Person;

import javax.persistence.Transient;

/**
 * Created by Allen on 2015/4/17.
 */
public class Player extends Person {

    private long nbaBallAge;

    private String position;

    private String no;

    private String birthPlace;

    @Transient
    private String url;

    public long getNbaBallAge() {
        return nbaBallAge;
    }

    public void setNbaBallAge(long nbaBallAge) {
        this.nbaBallAge = nbaBallAge;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
}
