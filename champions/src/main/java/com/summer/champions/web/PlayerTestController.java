package com.summer.champions.web;

import com.summer.champions.service.PlayerTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by Allen on 2015/4/13.
 */
@Controller
@RequestMapping(value = "/test")
public class PlayerTestController {

    @Autowired
    protected PlayerTestService playerTestService;

    @RequestMapping(value = "/delete/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public void delete(@PathVariable Long id) {
        playerTestService.save();
    }

}
