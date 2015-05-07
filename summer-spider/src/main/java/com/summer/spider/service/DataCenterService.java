package com.summer.spider.service;

import com.summer.spider.parser.DataCenterParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Allen on 2015/4/21.
 * DataCenterService用来整个数据抓取和同步,其中sync()方法为总入口
 */
@Service
public class DataCenterService {

    @Autowired
    RegionService regionService;

    @Autowired
    DivisionService divisionService;

    @Autowired
    TeamService teamService;

    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerSessionStatsService playerSessionStatsService;

    private static final String entryUrl = "http://nba.sports.sina.com.cn/teams.php?dpc=1";

    DataCenterParser parser;

    @Transactional
    public void sync() {
        parser = new DataCenterParser();
        parser.loadByGbEncoding(entryUrl);
        parser.defaultInitializing();
        parser.parse();
        saveEntities();
    }

    public void saveEntities() {
        regionService.saveEntities(parser.getRegions());
        divisionService.saveEntities(parser.getDivisions());
        teamService.saveEntities(parser.getTeams());
        playerService.saveEntities(parser.getPlayers());
        playerSessionStatsService.saveEntities(parser.getPlayerSeasonStatses());
    }


}
