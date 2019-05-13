package cn.service.impl;

import cn.dao.TBanjiDAO;
import cn.dao.impl.TBanjiDAOImpl;
import cn.dao.impl.BaseDaoImpl;
import cn.pojo.TBanji;
import cn.service.TBanjiService;
import cn.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class TBanjiServiceImpl implements TBanjiService {
    private TBanjiDAO tBanjiDAO;
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        //1 调用Dao查询总记录数
        Integer totalCount =tBanjiDAO.getTotalCount(dc);
        //2 创建PageBean对象
        PageBean pb = new PageBean(currentPage, totalCount, pageSize);
        //3 调用Dao查询分页列表数据

        List<TBanji> list = tBanjiDAO.getPageList(dc,pb.getStart(),pb.getPageSize());
        //4 列表数据放入pageBean中.并返回
        pb.setList(list);
        return pb;
    }

    @Override
    public TBanji getById(Integer class_id) {
        return tBanjiDAO.getById(class_id);
    }

    @Override
    public void save(TBanji tBanji) {
        tBanjiDAO.saveOrUpdate(tBanji);
    }

    public void settBanjiDAO(TBanjiDAO tBanjiDAO) {
        this.tBanjiDAO = tBanjiDAO;
    }
}
