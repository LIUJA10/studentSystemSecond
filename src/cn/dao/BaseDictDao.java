package cn.dao;


import cn.pojo.BaseDict;

import java.util.List;

public interface BaseDictDao extends BaseDAO<BaseDict> {
	//根据类型获得数据字典列表
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
