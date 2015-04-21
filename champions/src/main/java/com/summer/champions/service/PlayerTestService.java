package com.summer.champions.service;

import com.summer.champions.domain.Player;
import com.summer.common.service.CrudServiceImpl;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Allen on 2015/4/13.
 */
public interface PlayerTestService {

    public void save();

}
