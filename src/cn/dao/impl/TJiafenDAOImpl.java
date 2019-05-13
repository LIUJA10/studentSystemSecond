package cn.dao.impl;

import java.util.List;

import cn.dao.TJiafenDAO;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.pojo.TJiafen;

public class TJiafenDAOImpl extends BaseDaoImpl<TJiafen> implements TJiafenDAO {
}