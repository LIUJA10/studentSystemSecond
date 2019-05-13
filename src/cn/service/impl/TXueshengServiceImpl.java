package cn.service.impl;

import cn.dao.TXueshengDAO;
import cn.service.TXueshengService;
import cn.utils.MD5Utils;
import cn.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import cn.pojo.TXuesheng;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public class TXueshengServiceImpl implements TXueshengService {
	private TXueshengDAO tXueshengDAO;
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1 调用Dao查询总记录数
		Integer totalCount = tXueshengDAO.getTotalCount(dc);
		//2 创建PageBean对象
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		//3 调用Dao查询分页列表数据

		List<TXuesheng> list =  tXueshengDAO.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 列表数据放入pageBean中.并返回
		pb.setList(list);
		return pb;
	}

	public void settXueshengDAO(TXueshengDAO tXueshengDAO) {
		this.tXueshengDAO = tXueshengDAO;
	}

	@Override
	public void save(TXuesheng tXuesheng) {
		tXueshengDAO.saveOrUpdate(tXuesheng);
	}

	@Override
	public TXuesheng getById(Integer xs_id) {
		return tXueshengDAO.getById(xs_id);
	}

	@Override
	public TXuesheng getStudentByCodePassword(TXuesheng t) {
		TXuesheng existT=tXueshengDAO.getByUserCode(t.getUserName());
		if (existT==null){
			throw  new RuntimeException("用户名不存在");
		}
		if (!existT.getUserPw().equals(t.getUserPw())){
			throw new RuntimeException("密码错误");
		}
		return existT;
	}
}
