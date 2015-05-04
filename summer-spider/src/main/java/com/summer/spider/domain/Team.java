package com.summer.spider.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.common.collect.Lists;
import com.summer.common.persistence.NamedEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Allen on 2015/4/17.
 */
@Entity
@DynamicUpdate(value = true)
@Table(name = "team")
public class Team extends NamedEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "divisionId")
    @JsonBackReference
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

    /* 英文缩写 */
    private String abbr;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Player> players = Lists.newArrayList();

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
