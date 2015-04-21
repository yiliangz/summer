package com.summer.champions.service;

import com.summer.champions.domain.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by Allen on 2015/4/13.
 */
@Repository("playerTestService")
public class PlayerTestServiceImpl implements PlayerTestService {

    @Resource
    protected SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void save() {
        Session session = getCurrentSession();
        session.get(Player.class,2L);
        Player player = new Player();
        Player player1 = new Player();
        session.save(player);
        session.save(player1);
    }

}
