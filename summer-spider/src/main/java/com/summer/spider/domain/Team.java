package com.summer.spider.domain;

import com.summer.common.domain.NamedEntity;

import javax.persistence.Transient;

/**
 * Created by Allen on 2015/4/17.
 */
public class Team extends NamedEntity {

    private Division division;

    private String city;

    private String boss;

    /* 球馆 */
    private String arena;

    /* 冠军数 */
    private Long champions;

    @Transient
    private String url;

    private long joinYear;

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getJoinYear() {
        return joinYear;
    }

    public void setJoinYear(long joinYear) {
        this.joinYear = joinYear;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getChampions() {
        return champions;
    }

    public void setChampions(Long champions) {
        this.champions = champions;
    }
}
