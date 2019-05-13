package cn.service;

import cn.pojo.TBanji;
import cn.pojo.TXuesheng;
import cn.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface TBanjiService {
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
    void save(TBanji tBanji);
    TBanji getById(Integer class_id);
}
