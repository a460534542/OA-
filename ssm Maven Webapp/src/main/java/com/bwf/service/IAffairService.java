package com.bwf.service;

import java.util.List;

import com.bwf.entity.Affair;
import com.bwf.entity.User;

public interface IAffairService {

	void add(Affair affair);

	List<Affair> getAffairByMe(User current);

	Affair getAffairDetailByAffairId(Integer id);

}
