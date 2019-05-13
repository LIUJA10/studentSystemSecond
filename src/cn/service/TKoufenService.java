package cn.service;

import cn.pojo.TKoufen;
import cn.pojo.TXuesheng;
import cn.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface TKoufenService {
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
    void save(TKoufen tKoufen);
    TKoufen getById(Integer koufen_id);
}
