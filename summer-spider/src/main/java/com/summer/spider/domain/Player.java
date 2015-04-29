package com.summer.spider.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.summer.common.extend.Person;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Created by Allen on 2015/4/17.
 */
@Entity
@Table(name = "player")
public class Player extends Person {

    private long nbaBallAge;

    private String position;

    private String no;

    private String birthPlace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamId")
    @JsonBackReference
    private Team team;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
