package com.bwf.dao;

import java.util.List;

import com.bwf.entity.AffairModule;

public interface AffairModuleMapper {

	void add(AffairModule affairModule);

	List<AffairModule> getAll();

}
