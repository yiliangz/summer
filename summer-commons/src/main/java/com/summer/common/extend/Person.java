package com.summer.common.extend;

import com.summer.common.persistence.NamedEntity;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by Allen on 2015/4/17.
 */
@MappedSuperclass
public abstract class Person extends NamedEntity {

    private Date Birthday;

    private double height;

    private double weight;

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
