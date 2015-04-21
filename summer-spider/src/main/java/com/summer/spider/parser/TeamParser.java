package com.summer.spider.parser;

import com.google.common.collect.Lists;
import com.summer.common.utils.DateUtils;
import com.summer.common.utils.RegexUtils;
import com.summer.spider.domain.Coach;
import com.summer.spider.domain.Player;
import com.summer.spider.domain.Team;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Allen on 2015/4/17.
 */
public class TeamParser extends HtmlParser{

    private Team team;

    private Coach coach;

    private List<Player> players = Lists.newArrayList();

    @Override
    public void parse() {
        ParseTeam();
        parseCoach();
        parsePlayers();
    }

    public void ParseTeam() {
        team = new Team();
        Elements brief = getContent().select("#left > #table730middle").eq(0).select("tbody > tr");
        String str = getContent().select(CssSelector.Team.englishName).html();
        team.setName(brief.eq(0).select("td:eq(1)").html());
        team.setEnglishName(RegexUtils.getBracketsData(str));
        team.setCity(brief.eq(1).select("td").eq(1).html());
        team.setBoss(brief.eq(8).select("td:eq(1)").html());
        team.setArena(brief.eq(9).select("td:eq(1)").html());
        team.setChampions(getLong(brief.eq(11).select("td:eq(1)").html()));
        team.setJoinYear(getLong(brief.eq(10).select("td:eq(1)").html()));
    }

    public void parseCoach() {

    }

    public void parsePlayers() {
        Elements roster = getContent().select("#left > #table730middle").eq(1).select("tbody > tr:gt(0)");
        for (int i = 0; i < roster.size(); i++) {
            Player player = new Player();
            Element playerElement = roster.get(i);
            player.setUrl(playerElement.select("td:eq(1) a").attr("href"));
            player.setNo(playerElement.select("td:eq(0)").html());
            player.setName(playerElement.select("td:eq(1) a").html());
            player.setPosition(playerElement.select("td:eq(2)").html());
            player.setHeight(getDouble(playerElement.select("td:eq(3)").html()));
            player.setWeight(getLong(playerElement.select("td:eq(4)").html()));
            player.setBirthday(getDate(playerElement.select("td:eq(6)").html()));
            player.setNbaBallAge(getLong(playerElement.select("td:eq(7)").html()));
            players.add(player);
        }
        System.out.println(roster.outerHtml());
    }

}
