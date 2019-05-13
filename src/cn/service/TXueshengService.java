package cn.service;

import cn.pojo.TXuesheng;
import cn.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface TXueshengService {
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
    void save(TXuesheng tXuesheng);
    TXuesheng getById(Integer xs_id);
    TXuesheng getStudentByCodePassword(TXuesheng t);
}
