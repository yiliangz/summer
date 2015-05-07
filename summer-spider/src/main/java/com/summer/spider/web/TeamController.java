package com.summer.spider.web;

import com.summer.common.web.CrudController;
import com.summer.spider.domain.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

/**
 * Created by Allen on 2015/5/4.
 */
@Controller
@RequestMapping(value = "/team")
public class TeamController extends CrudController<Team,Long> {

}
