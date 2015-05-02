package com.summer.test.spider.parser;

import com.google.common.collect.Maps;
import com.summer.common.page.Page;
import com.summer.common.page.PageRequest;
import com.summer.common.page.Sort;
import com.summer.spider.domain.Player;
import com.summer.spider.repository.PlayerRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * Created by Allen on 2015/4/30.
 */
public class PageTest extends BaseSpringContext{

    @Autowired
    private PlayerRepository playerRepository;

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    public void setPlayerRepository(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Test
    @Transactional
    public void testPage() {

        Map<String,String> searchParams = Maps.newHashMap();
        searchParams.put("team.englishName_eq","Lakers");
        searchParams.put("team.name_eq","湖人");
//        searchParams.put("team.coach.division.name_eq","湖人");
        searchParams.put("name_like","x");


        PageRequest page = new PageRequest();
        page.setSearchParams(searchParams);
        page.setPage(0);
        page.setSize(10);
//        page.addSort(new Sort("name", Sort.Order.DESC));
        page.addSort(new Sort("team.name", Sort.Order.ASC));
        page.addSort(new Sort("team.englishName", Sort.Order.ASC));


        Page p = playerRepository.getPage(page);

    }

}
