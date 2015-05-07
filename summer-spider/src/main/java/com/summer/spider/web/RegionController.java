package com.summer.spider.web;

import com.summer.common.web.CrudController;
import com.summer.spider.domain.Region;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Allen on 2015/5/4.
 */
@Controller
@RequestMapping(value = "/region")
public class RegionController extends CrudController<Region,Long> {

}
