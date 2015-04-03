package com.summer.champions.web;

import com.summer.champions.domain.Player;
import com.summer.common.web.CrudController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Allen on 2015/3/17.
 */
@Controller
@RequestMapping(value = "/player")
public class PlayerController extends CrudController<Player,Long> {

}
