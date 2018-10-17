package com.bwf.service;

import java.util.List;

import com.bwf.entity.AffairModule;

public interface IAffairModuleService {

	void add(AffairModule affairModule, String[] optionName, Integer[] optionId, String[] optionData,
			Integer[] approverId);

	List<AffairModule> getAll();

}
