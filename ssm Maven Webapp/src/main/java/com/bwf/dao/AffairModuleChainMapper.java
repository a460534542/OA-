package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.AffairModuleChain;

public interface AffairModuleChainMapper {

	void add(@Param("chains") List<AffairModuleChain> chains);

}
