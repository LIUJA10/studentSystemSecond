package cn.service.impl;

import cn.dao.TChengjiDAO;
import cn.dao.impl.TChengjiDAOImpl;
import cn.dao.impl.BaseDaoImpl;
import cn.pojo.TChengji;
import cn.service.TChengjiService;
import cn.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class TChengjiServiceImpl implements TChengjiService {
    private TChengjiDAO tChengjiDAO;

    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        //1 调用Dao查询总记录数
        Integer totalCount = tChengjiDAO.getTotalCount(dc);
        //2 创建PageBean对象
        PageBean pb = new PageBean(currentPage, totalCount, pageSize);
        //3 调用Dao查询分页列表数据

        List<TChengji> list = tChengjiDAO.getPageList(dc,pb.getStart(),pb.getPageSize());
        //4 列表数据放入pageBean中.并返回
        pb.setList(list);
        return pb;
    }

    @Override
    public TChengji getById(Integer id) {
        return tChengjiDAO.getById(id);
    }

    @Override
    public void save(TChengji tChengji) {
        tChengjiDAO.saveOrUpdate(tChengji);
    }

    public void settChengjiDAO(TChengjiDAO tChengjiDAO) {
        this.tChengjiDAO = tChengjiDAO;
    }
}
