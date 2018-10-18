package com.bwf.entity;

import java.util.List;

public class Affair {
	
	private Integer affairId;
	
	private AffairModule affairModule;
	
	private String affairData;
	
	private User proposer;
	
	//0 未完成 , 1 已完成  , 2已驳回
	private Integer affairStatus;
	
	private List<AffairChain> affairChains;

	public List<AffairChain> getAffairChains() {
		return affairChains;
	}

	public void setAffairChains(List<AffairChain> affairChains) {
		this.affairChains = affairChains;
	}

	public Integer getAffairStatus() {
		return affairStatus;
	}

	public void setAffairStatus(Integer affairStatus) {
		this.affairStatus = affairStatus;
	}

	public Integer getAffairId() {
		return affairId;
	}

	public void setAffairId(Integer affairId) {
		this.affairId = affairId;
	}

	public AffairModule getAffairModule() {
		return affairModule;
	}

	public void setAffairModule(AffairModule affairModule) {
		this.affairModule = affairModule;
	}

	public String getAffairData() {
		return affairData;
	}

	public void setAffairData(String affairData) {
		this.affairData = affairData;
	}

	public User getProposer() {
		return proposer;
	}

	public void setProposer(User proposer) {
		this.proposer = proposer;
	}

	
	

}
