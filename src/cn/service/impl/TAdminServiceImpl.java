package cn.service.impl;

import cn.dao.TAdminDAO;
import cn.pojo.*;
import cn.service.TAdminService;
import cn.utils.MD5Utils;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class TAdminServiceImpl implements TAdminService {
	private TAdminDAO tAdminDAO;

	public void settAdminDAO(TAdminDAO tAdminDAO) {
		this.tAdminDAO = tAdminDAO;
	}

	@Override
	public TAdmin getUserByCodePassword(TAdmin a) {
		TAdmin existA=tAdminDAO.getByUserCode(a.getUserName());
		if (existA==null){
			throw new RuntimeException("用户名不存在");
		}
		if(!existA.getUserPw().equals(a.getUserPw())){
			throw new RuntimeException("密码错误");
		}
		return existA;
	}

}
