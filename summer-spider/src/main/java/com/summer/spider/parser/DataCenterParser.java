package com.summer.spider.parser;

import com.google.common.collect.Lists;
import com.summer.spider.domain.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Allen on 2015/4/17.
 */
public class DataCenterParser extends HtmlParser {

    List<Region> regions = Lists.newArrayList();

    List<Division> divisions = Lists.newArrayList();

    List<Team> teams = Lists.newArrayList();

    List<Player> players = Lists.newArrayList();

    List<PlayerSeasonStats> playerSeasonStatses = Lists.newArrayList();

    public void defaultInitializing() {
        setContent(getContent().select(CssSelector.Center.dataCenter).first());
    }

    @Override
    public void parse() {
        parseRegions();
        parseDivisions();
        parseTeams();
        parseTeamsEx();
        parsePlayers();
    }

    public List<Region> parseRegions() {
        Elements elements = this.getContent().select("tr").eq(0).select("td");
        for (Element element : elements) {
            Region region = new Region();
            region.setName(element.select("span:eq(0)").html());
            regions.add(region);
        }
        return regions;
    }

    public List<Division> parseDivisions() {
        Elements elements = this.getContent().select(CssSelector.Center.division);
        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            Division division = new Division();
            division.setName(element.html());

            int regionInt = i < elements.size()/2 ? 0 : 1;
            division.setRegion(regions.get(regionInt));
            regions.get(regionInt).addDivision(division);
            divisions.add(division);
        }
        return divisions;
    }

    public List<Team> parseTeams() {
        Elements rowElements = this.getContent().select(CssSelector.Center.row);
        for (int i = 0; rowElements != null && i < rowElements.size(); i++) {
            Elements teamElements = rowElements.get(i).select(CssSelector.Center.team);
            for (int j = 0; j < teamElements.size(); j++) {
                Element element = teamElements.get(j);
                Team team = new Team();
                team.setUrl(element.attr("href"));
                team.setName(element.html());
                team.setDivision(divisions.get(j));
                teams.add(team);
            }
        }
        return teams;
    }

    public List<Team> parseTeamsEx() {
        for (Team team : this.teams) {
            TeamParser teamParser = new TeamParser();
            teamParser.loadByGbEncoding(team.getUrl());
            teamParser.setTeam(team);
            teamParser.parse();
            players.addAll(teamParser.getPlayers());
        }
        return this.teams;
    }

    /* 进一步解析球员 */
    public List<Player> parsePlayers() {
        for (Player player : players) {
            PlayerParser playerParser = new PlayerParser();
            playerParser.loadByGbEncoding(player.getUrl());
            if (isInitSuccess()) {
                playerParser.setPlayer(player);
                playerParser.parse();
                playerSeasonStatses.addAll(playerParser.getPlayerSeasonStatses());
            }
            try {
                System.out.println("synchronizing player:  " +player.getEnglishName() +
                        " , from team: " + player.getTeam().getEnglishName() + "...");
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return players;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public List<Division> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<Division> divisions) {
        this.divisions = divisions;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<PlayerSeasonStats> getPlayerSeasonStatses() {
        return playerSeasonStatses;
    }

    public void setPlayerSeasonStatses(List<PlayerSeasonStats> playerSeasonStatses) {
        this.playerSeasonStatses = playerSeasonStatses;
    }

}
