package com.summer.champions.web;

import com.summer.champions.domain.Player;
import com.summer.champions.repository.PlayerRepository;
import com.summer.champions.service.PlayerService;
import com.summer.champions.service.PlayerServiceImpl;
import com.summer.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by Allen on 2015/3/17.
 */
@Controller
@RequestMapping(value = "/player")
public class PlayerController {

    @Resource(name = "playerServiceImpl")
    protected PlayerServiceImpl playerServiceImpl;

//    @RequestMapping(value = "/{id}")
//    @ResponseBody
//    public Object get(@PathVariable Long id) {
//        return playerRepository.get(id);
//    }

    @RequestMapping(value = "/all")
    @ResponseBody
    public Object getAll() {
        DateUtils.getYesterdayStart();
//        return playerRepository.getAll();
        return null;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public Object save() {
        Player player = new Player();
        player.setName("curry33");
//        return playerRepository.save(player);
        return playerServiceImpl.save(player);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public void delete() {
//        playerRepository.delete(21L);
    }

}
