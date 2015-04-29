package com.summer.spider.repository;

import com.summer.common.repository.CrudRepositoryImpl;
import com.summer.spider.domain.Player;
import org.springframework.stereotype.Repository;

/**
 * Created by Allen on 2015/4/28.
 */
@Repository("playerRepository")
public class PlayerRepository extends CrudRepositoryImpl<Player,Long> {

}
