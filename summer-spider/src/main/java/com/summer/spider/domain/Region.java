package com.summer.spider.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.google.common.collect.Lists;
import com.summer.common.persistence.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Allen on 2015/4/17.
 */
/* 西部和东部 */
@Entity
@Table(name = "region")
public class Region extends NamedEntity {

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Division> divisions = Lists.newArrayList();

    public List<Division> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<Division> divisions) {
        this.divisions = divisions;
    }

    public void addDivision(Division division) {
        this.divisions.add(division);
    }

}
