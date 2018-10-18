package com.bwf.entity;

public class AffairChain {
	private Integer affairChainId;
	
	private Integer affairId;
	
	private Integer affairChainOrder;
	
	private Integer affairChainStatus;
	
	private String affairChainComment;
	
	private User approver;
	

	public Integer getAffairChainId() {
		return affairChainId;
	}

	public void setAffairChainId(Integer affairChainId) {
		this.affairChainId = affairChainId;
	}

	public Integer getAffairId() {
		return affairId;
	}

	public void setAffairId(Integer affairId) {
		this.affairId = affairId;
	}

	public Integer getAffairChainOrder() {
		return affairChainOrder;
	}

	public void setAffairChainOrder(Integer affairChainOrder) {
		this.affairChainOrder = affairChainOrder;
	}

	public Integer getAffairChainStatus() {
		return affairChainStatus;
	}

	public void setAffairChainStatus(Integer affairChainStatus) {
		this.affairChainStatus = affairChainStatus;
	}

	public String getAffairChainComment() {
		return affairChainComment;
	}

	public void setAffairChainComment(String affairChainComment) {
		this.affairChainComment = affairChainComment;
	}

	public User getApprover() {
		return approver;
	}

	public void setApprover(User approver) {
		this.approver = approver;
	}

	
}
