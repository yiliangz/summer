package com.summer.spider.service;

import com.google.common.collect.Lists;
import com.summer.spider.domain.Player;
import com.summer.spider.domain.Team;
import com.summer.spider.parser.DataCenterParser;
import com.summer.spider.parser.HtmlParser;
import com.summer.spider.parser.TeamParser;

import java.util.List;

/**
 * Created by Allen on 2015/4/21.
 * <p/>
 * DataCenterService用来整个数据抓取和同步,其中sync()方法为总入口
 */
public class DataCenterService {

    private String entryUrl = "http://nba.sports.sina.com.cn/teams.php?dpc=1";

    DataCenterParser parser;

    public void sync() {
        parser = (DataCenterParser) new DataCenterParser().loadByGbEncoding(entryUrl);
        parser.parse();
        List<Team> teams = parser.getTeams();
        List<Player> players = Lists.newArrayList();

        for (int i = 0; i < 2; i++) {
            Team team = teams.get(i);
            TeamParser teamParser = (TeamParser) new TeamParser().loadByGbEncoding(team.getUrl());
            teamParser.parsePlayers();
            players.addAll(teamParser.getPlayers());
        }
    }


}
