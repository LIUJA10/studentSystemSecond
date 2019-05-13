package cn.dao;

import cn.pojo.TAdmin;

public interface TAdminDAO extends BaseDAO<TAdmin> {
    TAdmin  getByUserCode(String userName);
}
