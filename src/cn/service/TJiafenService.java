package cn.service;

import cn.pojo.TJiafen;
import cn.pojo.TXuesheng;
import cn.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface TJiafenService {
    PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
    void save(TJiafen tJiafen);
    TJiafen getById(Integer jiafen_id);
}
