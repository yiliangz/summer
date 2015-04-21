package com.summer.spider.parser;

import com.google.common.collect.Lists;
import com.summer.spider.domain.Division;
import com.summer.spider.domain.Region;
import com.summer.spider.domain.Team;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * Created by Allen on 2015/4/17.
 */
public class DataCenterParser extends HtmlParser{

    TeamParser teamParser;

    List<Region> regions = Lists.newArrayList();

    List<Division> divisions = Lists.newArrayList();

    public List<Team> teams = Lists.newArrayList();

    @Override
    public void parse() {
        parseRegions();
        parseDivisions();
        parseTeams();
    }

    public void parseRegions() {
        Elements elements = this.getContent().select(CssSelector.Center.Region);
        for(Element element : elements) {
            Region region = new Region();
            region.setName(element.select("span:eq(0)").html());
            regions.add(region);
        }
    }

    public void parseDivisions() {
        Elements elements = this.getContent().select(CssSelector.Center.division);
        for(Element element : elements) {
            Division division = new Division();
            division.setName(element.html());
            divisions.add(division);
        }
    }

    public void parseTeams() {
        Elements elements = this.getContent().select(CssSelector.Center.team);
        for (Element element : elements) {
            Team team = new Team();
            team.setUrl(element.attr("href"));
            team.setName(element.html());
            teams.add(team);
        }
    }

}
