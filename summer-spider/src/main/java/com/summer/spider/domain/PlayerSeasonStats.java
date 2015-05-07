package com.summer.spider.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.summer.common.persistence.IdEntity;

import javax.persistence.*;

/**
 * Created by Allen on 2015/5/6.
 */
/* 赛季场均数据 */
@Entity
@Table(name = "PlayerSeasonStats")
public class PlayerSeasonStats extends IdEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playerId")
    @JsonBackReference
    private Player player;

    private long season;

    private String seasonText;

    private double points;

    private long attend;

    private long firstTeam;       //首发次数

    private double attendTime;    //出场时间(分钟)

    private double throwPercent;

    private double threePointPercent;

    private double freeThrowPercent;

    private double offenceRebound;

    private double defenceRebound;

    private double totalRebound;

    private double assist;

    private double block;

    private double steal;

    public double getSteal() {
        return steal;
    }

    public void setSteal(double steal) {
        this.steal = steal;
    }

    private double turnOver;

    private double foul;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public long getSeason() {
        return season;
    }

    public void setSeason(long season) {
        this.season = season;
    }

    public String getSeasonText() {
        return seasonText;
    }

    public void setSeasonText(String seasonText) {
        this.seasonText = seasonText;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public long getAttend() {
        return attend;
    }

    public void setAttend(long attend) {
        this.attend = attend;
    }

    public long getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(long firstTeam) {
        this.firstTeam = firstTeam;
    }

    public double getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(double attendTime) {
        this.attendTime = attendTime;
    }

    public double getThrowPercent() {
        return throwPercent;
    }

    public void setThrowPercent(double throwPercent) {
        this.throwPercent = throwPercent;
    }

    public double getThreePointPercent() {
        return threePointPercent;
    }

    public void setThreePointPercent(double threePointPercent) {
        this.threePointPercent = threePointPercent;
    }

    public double getOffenceRebound() {
        return offenceRebound;
    }

    public void setOffenceRebound(double offenceRebound) {
        this.offenceRebound = offenceRebound;
    }

    public double getDefenceRebound() {
        return defenceRebound;
    }

    public void setDefenceRebound(double defenceRebound) {
        this.defenceRebound = defenceRebound;
    }

    public double getTotalRebound() {
        return totalRebound;
    }

    public void setTotalRebound(double totalRebound) {
        this.totalRebound = totalRebound;
    }

    public double getAssist() {
        return assist;
    }

    public void setAssist(double assist) {
        this.assist = assist;
    }

    public double getBlock() {
        return block;
    }

    public void setBlock(double block) {
        this.block = block;
    }

    public double getTurnOver() {
        return turnOver;
    }

    public void setTurnOver(double turnOver) {
        this.turnOver = turnOver;
    }

    public double getFoul() {
        return foul;
    }

    public void setFoul(double foul) {
        this.foul = foul;
    }

    public double getFreeThrowPercent() {
        return freeThrowPercent;
    }

    public void setFreeThrowPercent(double freeThrowPercent) {
        this.freeThrowPercent = freeThrowPercent;
    }

}
