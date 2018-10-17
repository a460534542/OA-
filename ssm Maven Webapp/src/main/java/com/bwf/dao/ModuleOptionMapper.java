package com.bwf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bwf.entity.ModuleOption;

public interface ModuleOptionMapper {

	void add(@Param("moduleOptions") List<ModuleOption> moduleOptions);

	List<ModuleOption> getModuleOptionsByAffairModuleId(Integer id);

}
