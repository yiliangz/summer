package com.summer.spider.web;

import com.summer.common.web.CrudController;
import com.summer.spider.domain.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

/**
 * Created by Allen on 2015/4/30.
 */
@Controller
@Transactional
@RequestMapping(value = "/player")
public class PlayerController extends CrudController<Player,Long> {

}
