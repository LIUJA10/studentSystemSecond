package cn.service;

import cn.pojo.TChengji;
import cn.pojo.TXuesheng;
import cn.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface TChengjiService {
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
    void save(TChengji tChengji);
    TChengji getById(Integer id);
}
