package com.summer.test.spider.parser;

import com.summer.spider.domain.PlayerSeasonStats;
import com.summer.spider.repository.DivisionRepository;
import com.summer.spider.service.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Allen on 2015/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class BaseSpringContext {

    @Autowired
    RegionService regionService;

    @Autowired
    DivisionService divisionService;

    @Autowired
    TeamService teamService;

    @Autowired
    PlayerService playerService;

    @Autowired
    DataCenterService dataCenterService;

    @Autowired
    PlayerSessionStatsService playerSessionStatsService;

}
