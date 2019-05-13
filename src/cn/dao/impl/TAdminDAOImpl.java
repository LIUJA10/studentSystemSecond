package cn.dao.impl;
import cn.dao.TAdminDAO;
import cn.pojo.TAdmin;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

public class TAdminDAOImpl extends BaseDaoImpl<TAdmin> implements TAdminDAO {

    @Override
    public TAdmin getByUserCode( final String userName) {

        return getHibernateTemplate().execute(new HibernateCallback<TAdmin>() {
            @Override
            public TAdmin doInHibernate(Session session) throws HibernateException {
                String hql = "from TAdmin where userName = ? ";
                Query query = session.createQuery(hql);
                query.setParameter(0, userName);
                TAdmin tAdmin = (TAdmin) query.uniqueResult();
                return tAdmin;
            }
        });
    }
}