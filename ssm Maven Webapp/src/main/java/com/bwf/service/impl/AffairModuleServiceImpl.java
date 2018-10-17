package com.bwf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.AffairModuleChainMapper;
import com.bwf.dao.AffairModuleMapper;
import com.bwf.dao.ModuleOptionMapper;
import com.bwf.entity.AffairModule;
import com.bwf.entity.AffairModuleChain;
import com.bwf.entity.ModuleOption;
import com.bwf.service.IAffairModuleService;

@Service
public class AffairModuleServiceImpl implements IAffairModuleService {

	
	@Autowired
	com.bwf.dao.AffairModuleMapper affairModuleMapper;
	
	@Autowired
	com.bwf.dao.ModuleOptionMapper moduleOptionMapper;

	@Autowired
	com.bwf.dao.AffairModuleChainMapper affairModuleChainMapper;
	
	@Override
	public void add(AffairModule affairModule, String[] optionName, Integer[] optionId, 
			String[] optionData, Integer[] approverId) {
		// 公文模板表 新增一条数据
		affairModuleMapper.add( affairModule );
		
		
		// 模板选项关系表中 新增 n 条数据
		List<ModuleOption> moduleOptions = new ArrayList<ModuleOption>();
		for( int i=0 ; i<optionName.length; i++ ) {
			ModuleOption moduleOption = new ModuleOption();
			moduleOption.setAffairModuleId(affairModule.getAffairModuleId());
			moduleOption.setOptionId(optionId[i]);
			moduleOption.setOrder(i+1);
			moduleOption.setOptionName(optionName[i]);
			moduleOption.setOptionData(optionData[i]);
			
			moduleOptions.add(moduleOption);
		}
		
		moduleOptionMapper.add( moduleOptions );
		
		// 往模板审批表中写入l条数据
		List<AffairModuleChain> chains = new ArrayList<>();
		for( int i=0;i <approverId.length ; i++ ) {
			AffairModuleChain chain = new AffairModuleChain();
			chain.setOrder(i+1);
			chain.setApproverId(approverId[i]);
			chain.setAffairModuleId(affairModule.getAffairModuleId());
			
			chains.add(chain);
		}
		
		affairModuleChainMapper.add( chains );
		
	}

	@Override
	public List<AffairModule> getAll() {
		
		return affairModuleMapper.getAll();
	}

}
