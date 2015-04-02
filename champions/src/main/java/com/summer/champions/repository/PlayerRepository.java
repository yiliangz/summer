package com.summer.champions.repository;

import com.summer.champions.domain.Player;
import com.summer.common.repository.CrudRepositoryImpl;
import org.springframework.stereotype.Repository;

/**
 * Created by Allen on 2015/3/14.
 */
@Repository
public class PlayerRepository extends CrudRepositoryImpl <Player,Long> {

//    private SessionFactory sessionFactory;

//    public Player save() {
//        Player player = new Player();
//        player.setName("Curry22");
//        Session session = sessionFactory.openSession();
//        session.save(player);
//        return null;
//    }
//
//    public Player get(Long id) {
//        Session session = sessionFactory.openSession();
//        return (Player)session.get(Player.class,id);
//    }
//
//    public List<Player> getAll() {
//        Session session = sessionFactory.openSession();
//        String hql = "from Player";
//        return (List<Player>)session.createQuery(hql).list();
//    }
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        System.out.println("setSessionFactory..........");
//        this.sessionFactory = sessionFactory;
//    }
//
//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }

}
