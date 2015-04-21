package com.summer.champions.service;

import com.summer.champions.domain.Player;
import com.summer.common.service.CrudService;
import com.summer.common.service.CrudServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Allen on 2015/4/1.
 */
@Service("playerService")
public class PlayerServiceImpl extends CrudServiceImpl<Player,Long>
        implements PlayerService {

}
