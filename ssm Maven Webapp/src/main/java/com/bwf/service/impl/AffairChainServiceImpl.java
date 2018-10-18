package com.bwf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bwf.dao.AffairChainMapper;
import com.bwf.dao.AffairMapper;
import com.bwf.entity.Affair;
import com.bwf.entity.AffairChain;
import com.bwf.service.IAffairChainService;

@Service
public class AffairChainServiceImpl implements IAffairChainService {

	@Autowired
	AffairChainMapper affairChainMapper;
	
	@Autowired
	AffairMapper affairMapper;
	
	
	// 流程链审批的方法
	@Override
	public void propose(AffairChain affairChain) {
		
		// 1)更新当前员工的审批记录
		affairChainMapper.propose( affairChain );
		
		// 获取 完整的 affairChain
		affairChain = affairChainMapper.getAffairChainByAffairChainId(affairChain.getAffairChainId());
						
		Affair affair = new Affair();
		affair.setAffairId(affairChain.getAffairId());
		
		if ( affairChain.getAffairChainStatus()==2 ) {
			// 获取下一条 affairChain
			affairChain.setAffairChainOrder( affairChain.getAffairChainOrder()+1 );
			AffairChain nextChain = affairChainMapper.getNext( affairChain );
			
			// 2) 把下一条流程链设置为 待审批状态
			if ( nextChain!=null ) {
				affairChainMapper.setNextStatus( nextChain );
			} else {
				// 设置 affair 表的 status 1
				affair.setAffairStatus(1);
				affairMapper.setStatus( affair );
			}
		} else {
			// 设置 affair 表的 status 2
			affair.setAffairStatus(2);
			affairMapper.setStatus( affair );
		}
		
	}

}
