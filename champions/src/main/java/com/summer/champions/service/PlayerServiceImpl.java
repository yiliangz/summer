package com.summer.champions.service;

import com.summer.champions.domain.Player;
import com.summer.champions.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Allen on 2015/4/1.
 */
@Service("playerServiceImpl")
public class PlayerServiceImpl {

    @Autowired
    protected PlayerRepository playerRepository;

    public Player save(Player entity) {
        return playerRepository.save(entity);
    }
}
