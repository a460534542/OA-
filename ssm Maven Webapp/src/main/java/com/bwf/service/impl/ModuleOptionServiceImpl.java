package com.bwf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.ModuleOptionMapper;
import com.bwf.service.IModuleOptionService;
@Service
public class ModuleOptionServiceImpl implements IModuleOptionService {
	
	@Autowired
	ModuleOptionMapper moduleOptionMapper;
	
	@Override
	public Object getModuleOptionsByAffairModuleId(Integer id) {
		// TODO Auto-generated method stub
		return moduleOptionMapper.getModuleOptionsByAffairModuleId(id);
	}

}
