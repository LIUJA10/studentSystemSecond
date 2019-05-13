package cn.dao;

import cn.pojo.TXuesheng;

public interface TXueshengDAO extends BaseDAO<TXuesheng> {
    TXuesheng getByUserCode(String userName);
}
