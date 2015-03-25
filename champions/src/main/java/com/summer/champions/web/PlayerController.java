package com.summer.champions.web;

import com.summer.champions.repository.PlayerRepository;
import com.summer.common.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Allen on 2015/3/17.
 */
@Controller
@RequestMapping(value = "/player")
public class PlayerController {


    @Resource
    protected PlayerRepository playerRepository;

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public Object list(@PathVariable Long id) {
        DateUtils.getYesterdayStart();
        return playerRepository.get(id);
    }

}
