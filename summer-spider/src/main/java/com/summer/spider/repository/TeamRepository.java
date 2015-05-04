package com.summer.spider.repository;

import com.summer.common.repository.CrudRepositoryImpl;
import com.summer.spider.domain.Team;
import org.springframework.stereotype.Repository;

/**
 * Created by Allen on 2015/5/4.
 */
@Repository
public class TeamRepository extends CrudRepositoryImpl<Team,Long> {

}
