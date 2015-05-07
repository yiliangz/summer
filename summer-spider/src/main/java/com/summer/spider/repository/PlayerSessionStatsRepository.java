package com.summer.spider.repository;

import com.summer.common.repository.CrudRepository;
import com.summer.common.repository.CrudRepositoryImpl;
import com.summer.spider.domain.PlayerSeasonStats;
import org.springframework.stereotype.Repository;

/**
 * Created by Allen on 2015/5/7.
 */
@Repository
public class PlayerSessionStatsRepository extends CrudRepositoryImpl<PlayerSeasonStats,Long> {

}
