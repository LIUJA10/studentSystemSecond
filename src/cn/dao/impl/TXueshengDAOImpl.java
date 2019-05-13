package cn.dao.impl;

import cn.dao.TXueshengDAO;
import cn.pojo.TXuesheng;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

public class TXueshengDAOImpl extends BaseDaoImpl<TXuesheng> implements TXueshengDAO {
    @Override
    public TXuesheng getByUserCode(final String user_code) {
        //HQL
        return getHibernateTemplate().execute(new HibernateCallback<TXuesheng>() {
            @Override
            public TXuesheng doInHibernate(Session session) throws HibernateException {
                String hql = "from TXuesheng where userName = ? ";
                Query query = session.createQuery(hql);
                query.setParameter(0, user_code);
                TXuesheng student = (TXuesheng) query.uniqueResult();
                return student;
            }
        });
    }
}