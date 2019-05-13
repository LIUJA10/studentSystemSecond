package cn.service.impl;

import cn.dao.TKoufenDAO;
import cn.dao.impl.BaseDaoImpl;
import cn.dao.impl.TKoufenDAOImpl;
import cn.pojo.TKoufen;
import cn.service.TKoufenService;
import cn.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class TKoufenServiceImpl implements TKoufenService {


    private TKoufenDAO tKoufenDAO;
    @Override
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        //1 调用Dao查询总记录数
        Integer totalCount = tKoufenDAO.getTotalCount(dc);
        //2 创建PageBean对象
        PageBean pb = new PageBean(currentPage, totalCount, pageSize);
        //3 调用Dao查询分页列表数据

        List<TKoufen> list = tKoufenDAO.getPageList(dc,pb.getStart(),pb.getPageSize());
        //4 列表数据放入pageBean中.并返回
        pb.setList(list);
        return pb;
    }

    @Override
    public TKoufen getById(Integer koufen_id) {
        return tKoufenDAO.getById(koufen_id);
    }

    public void settKoufenDAO(TKoufenDAO tKoufenDAO) {
        this.tKoufenDAO = tKoufenDAO;
    }

    @Override
    public void save(TKoufen tKoufen) {
        tKoufenDAO.saveOrUpdate(tKoufen);
    }
}
