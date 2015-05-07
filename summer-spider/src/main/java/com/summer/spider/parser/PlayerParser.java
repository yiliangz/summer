package com.summer.spider.parser;

import com.google.common.collect.Lists;
import com.summer.common.constant.EncodingConstant;
import com.summer.common.utils.IOStreamUtils;
import com.summer.common.utils.RegexUtils;
import com.summer.spider.domain.Player;
import com.summer.spider.domain.PlayerSeasonStats;
import com.summer.spider.utils.FilePathUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * Created by Allen on 2015/5/4.
 */
public class PlayerParser extends HtmlParser {

    Player player;

    List<PlayerSeasonStats> playerSeasonStatses = Lists.newArrayList();

    public void parse() {
        parsePlayer();
        parsePlayerSeasonStats();
    }

    public void defaultInitialization() {
        selectSingle("#left");
    }

    public void defaultInitialization(Player player) {
        defaultInitialization();
        setPlayer(player);
    }

    public void parsePlayer() {
        String str = this.select(CssSelector.Player.englishName).html();

        Elements playerInfo = this.select("#table730middle").eq(0);
        player.setEnglishName(RegexUtils.getBracketsData(str));

        playerInfo = playerInfo.select("table");
        player.setBirthPlace(playerInfo.select("tr:eq(1) td:eq(1)").html());
        player.setGraduatedSchool(playerInfo.select("tr:eq(1) td:eq(3)").html());

        String joinYear = RegexUtils.getNumericData(playerInfo.select("tr:eq(3) td:eq(1)").html());
        if (!StringUtils.isEmpty(joinYear)) {
            player.setJoinYear(getLong(RegexUtils.getNumericData(joinYear)));
        }
        player.setDraftBrief(playerInfo.select("tr:eq(6) td:eq(1)").html());

        String url = playerInfo.select("tr:eq(0) td:eq(0) img").attr("src");
        saveImageFile(url, player.getEnglishName());
    }

    public void parsePlayerSeasonStats() {
        Elements statsInfo = this.select("#table730middle").eq(1).select("tr:gt(0)");
        for (int i = 0; i < (statsInfo.size() - 1)/2; i++) {

            PlayerSeasonStats stats = new PlayerSeasonStats();
            stats.setPlayer(player);
            Elements elements = statsInfo.get(i).select("td");
            for (int j = 0; j < elements.size(); j++) {
                Element element = elements.get(j);
                String value = element.html();

                //处理sina页面的一个bug,出现了两个 NBA生涯 统计数据
                if (value.contains("NBA生涯")) {
                    break;
                }
                if (j == 0) {
                    stats.setSeasonText(value);
                } else if (j == 2) {
                    stats.setAttend(getLong(value));
                } else if (j == 3) {
                    stats.setFirstTeam(getLong(value));
                } else if (j == 4) {
                    stats.setAttendTime(getDouble(value));
                } else if (j == 5) {
                    stats.setThrowPercent(getDouble(value));
                } else if (j == 6) {
                    stats.setThreePointPercent(getDouble(value));
                } else if (j == 7) {
                    stats.setFreeThrowPercent(getDouble(value));
                } else if (j == 8) {
                    stats.setOffenceRebound(getDouble(value));
                } else if (j == 9) {
                    stats.setDefenceRebound(getDouble(value));
                } else if (j == 10) {
                    stats.setTotalRebound(getDouble(value));
                } else if (j == 11) {
                    stats.setAssist(getDouble(value));
                } else if (j == 12) {
                    stats.setSteal(getDouble(value));
                } else if (j == 13) {
                    stats.setBlock(getDouble(value));
                } else if (j == 14) {
                    stats.setTurnOver(getDouble(value));
                } else if (j == 15) {
                    stats.setFoul(getDouble(value));
                } else if (j == 16) {
                    stats.setPoints(getDouble(value));
                }
            }
            playerSeasonStatses.add(stats);
        }
    }

    public void saveImageFile(String url, String playerName) {
        List<String> names = RegexUtils.getMatchData("\\S+", playerName);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; names != null && i < names.size(); i++) {
            if (i != 0) {
                builder.append("_");
            }
            builder.append(names.get(i));
        }
        String filePath = FilePathUtils.getPrefixImagePath() + "/player/" + builder.toString().toLowerCase() + ".jpg";
        IOStreamUtils.saveFile(url, filePath, EncodingConstant.GB_ENCODING);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<PlayerSeasonStats> getPlayerSeasonStatses() {
        return playerSeasonStatses;
    }

    public void setPlayerSeasonStatses(List<PlayerSeasonStats> playerSeasonStatses) {
        this.playerSeasonStatses = playerSeasonStatses;
    }

}
