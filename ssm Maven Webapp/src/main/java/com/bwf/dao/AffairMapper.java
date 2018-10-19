package com.bwf.dao;

import java.util.List;

import com.bwf.entity.Affair;
import com.bwf.entity.User;

public interface AffairMapper {

	void add(Affair affair);

	List<Affair> getAffairByMe(User current);

	Affair getAffairDetailByAffairId(Integer id);

	void setStatus(Affair affair);

	List<Affair> getAffairToBePropose(User current);

}
