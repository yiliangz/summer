package com.summer.spider.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.summer.common.extend.Person;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * Created by Allen on 2015/4/17.
 */
@Entity
@Table(name = "Player")
public class Player extends Person {

    @ManyToOne
    @JoinColumn(name = "teamId")
    @JsonManagedReference
    private Team team;

    private long nbaBallAge;

    private String position;

    private String no;

    private String birthPlace;

    private String graduatedSchool;

    private long joinYear;

    private String draftBrief;         //选秀情况

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

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public long getJoinYear() {
        return joinYear;
    }

    public void setJoinYear(long joinYear) {
        this.joinYear = joinYear;
    }

    public String getDraftBrief() {
        return draftBrief;
    }

    public void setDraftBrief(String draftBrief) {
        this.draftBrief = draftBrief;
    }
}
