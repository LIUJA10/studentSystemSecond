package cn.service.impl;

import cn.dao.TJiafenDAO;
import cn.dao.impl.TJiafenDAOImpl;
import cn.dao.impl.BaseDaoImpl;
import cn.pojo.TJiafen;
import cn.service.TJiafenService;
import cn.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public class TJiafenServiceImpl implements TJiafenService {

    private TJiafenDAO tJiafenDAO;
    public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
        //1 调用Dao查询总记录数
        Integer totalCount = tJiafenDAO.getTotalCount(dc);
        //2 创建PageBean对象
        PageBean pb = new PageBean(currentPage, totalCount, pageSize);
        //3 调用Dao查询分页列表数据

        List<TJiafen> list = tJiafenDAO.getPageList(dc,pb.getStart(),pb.getPageSize());
        //4 列表数据放入pageBean中.并返回
        pb.setList(list);
        return pb;
    }

    @Override
    public TJiafen getById(Integer jiafen_id) {
        return tJiafenDAO.getById(jiafen_id);
    }

    @Override
    public void save(TJiafen tJiafen) {
        tJiafenDAO.saveOrUpdate(tJiafen);
    }

    public void settJiafenDAO(TJiafenDAO tJiafenDAO) {
        this.tJiafenDAO = tJiafenDAO;
    }
}
