package cn.service.impl;

import cn.dao.BaseDictDao;
import cn.pojo.BaseDict;
import cn.service.BaseDictService;

import java.util.List;

public class BaseDictServiceImpl implements BaseDictService {
	
	private BaseDictDao bdd;
	
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		return bdd.getListByTypeCode(dict_type_code);
	}

	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}

	
}
