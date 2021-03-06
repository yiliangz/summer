package com.summer.common.persistence;

import javax.persistence.MappedSuperclass;

/**
 * Created by Allen on 2015/4/18.
 */
@MappedSuperclass
public class NamedEntity extends IdEntity{

    String name;

    String englishName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

}
