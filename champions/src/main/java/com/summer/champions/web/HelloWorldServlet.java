package com.summer.champions.web;

import com.summer.champions.repository.PlayerRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Allen on 2015/1/18.
 */
//@Controller
//@WebServlet(name = "HelloWorldServlet",urlPatterns="/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {

    @Resource
    public PlayerRepository playerRepository;

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    public void setPlayerRepository(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("SessionFactorySessionFactorySessionFactorySessionFactory...");
        playerRepository.get(7L);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


    public void init() throws ServletException {
        super.init();
    }

}
