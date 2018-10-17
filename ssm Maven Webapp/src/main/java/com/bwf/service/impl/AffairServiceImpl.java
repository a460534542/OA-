package com.bwf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.AffairMapper;
import com.bwf.entity.Affair;
import com.bwf.service.IAffairService;

@Service
public class AffairServiceImpl implements IAffairService {
	
	@Autowired
	AffairMapper affairMapper;

	@Override
	public void add(Affair affair) {
		// TODO Auto-generated method stub
		affairMapper.add( affair );
	}

}
