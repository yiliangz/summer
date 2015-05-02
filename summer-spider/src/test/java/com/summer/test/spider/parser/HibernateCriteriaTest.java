package com.summer.test.spider.parser;

import com.google.common.collect.Maps;
import com.summer.common.persistence.CriteriaParser;
import com.summer.common.persistence.SearchFilter;
import com.summer.spider.domain.Player;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2015/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class HibernateCriteriaTest {

//    @Autowired
//    private PlayerRepository playerRepository;

    @Resource
    private SessionFactory sessionFactory;

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Test
    @Transactional
    public void testCriteria() {
        Session session = getCurrentSession();
        DetachedCriteria criteria = DetachedCriteria.forClass(Player.class);
        criteria.add(Restrictions.like("name","%eee%"));
        criteria.add(Restrictions.like("birthPlace","%sss%"));
        DetachedCriteria c = criteria.createCriteria("team").add(Restrictions.eq("englishName", "Lakers"));
        List list = c.getExecutableCriteria(session).list();
    }

    @Test
    @Transactional
    public void test() {
        Session session = getCurrentSession();
        Map<String,String> searchParams = Maps.newHashMap();
        searchParams.put("team.englishName_eq","Warriors");
        searchParams.put("birthPlace_eq","eeeee");
        List<SearchFilter> filters = SearchFilter.parse(searchParams);
        Criteria criteria = CriteriaParser.parse(filters, Player.class,session);
        criteria.list();
    }

    @Test
    @Transactional
    public void testProjectionRowCount() {
        Session session = getCurrentSession();
        DetachedCriteria criteria = DetachedCriteria.forClass(Player.class);
        Object count =
                criteria.setProjection(Projections.rowCount())
                .add(Restrictions.like("name", "%eee%"))
                .addOrder(Order.asc("name"))
                .getExecutableCriteria(session)
                .uniqueResult();
        System.out.println(count);
    }

    @Test
    @Transactional
    public void testProjectionOrder() {
        Session session = getCurrentSession();
        DetachedCriteria criteria = DetachedCriteria.forClass(Player.class);
        criteria.getExecutableCriteria(session)
                .addOrder(Order.asc("name"))
                .addOrder(Order.asc("birthPlace"))
                .list();
    }

    @Test
    @Transactional
    public void testResult() {
        Session session = getCurrentSession();
        DetachedCriteria criteria = DetachedCriteria.forClass(Player.class);
        criteria.getExecutableCriteria(session)
                .setFirstResult(1)
                .setMaxResults(5)
                .list();
    }

}
