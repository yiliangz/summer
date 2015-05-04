package com.summer.spider.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.common.collect.Lists;
import com.summer.common.persistence.NamedEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Allen on 2015/4/17.
 */
/* 分区: 现在一共6个 */
@Entity
@Table(name = "division")
public class Division extends NamedEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regionId")
    @JsonBackReference
    private Region region;

    @OneToMany(mappedBy = "division", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Team> teams = Lists.newArrayList();

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

}
