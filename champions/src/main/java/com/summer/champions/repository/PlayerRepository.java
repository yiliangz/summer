package com.summer.champions.repository;

import com.summer.champions.domain.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Allen on 2015/3/14.
 */
public class PlayerRepository {

    private SessionFactory sessionFactory;

    public Player save() {
        Player player = new Player();
        player.setName("Curry22");
        Session session = sessionFactory.openSession();
        session.save(player);
        return null;
    }

    public Player get(Long id) {
        Session session = sessionFactory.openSession();
        return (Player)session.get(Player.class,id);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        System.out.println("setSessionFactory..........");
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
