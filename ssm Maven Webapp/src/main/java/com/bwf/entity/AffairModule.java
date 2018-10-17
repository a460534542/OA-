package com.bwf.entity;

public class AffairModule {
	
	
	
	@Override
	public String toString() {
		return "AffairModule [affairModuleId=" + affairModuleId + ", affairModuleName=" + affairModuleName
				+ ", affairModuleProducerId=" + affairModuleProducerId + "]";
	}

	private Integer affairModuleId;
	
	private String affairModuleName;
	
	private Integer affairModuleProducerId;

	public Integer getAffairModuleId() {
		return affairModuleId;
	}

	public void setAffairModuleId(Integer affairModuleId) {
		this.affairModuleId = affairModuleId;
	}

	public String getAffairModuleName() {
		return affairModuleName;
	}

	public void setAffairModuleName(String affairModuleName) {
		this.affairModuleName = affairModuleName;
	}

	public Integer getAffairModuleProducerId() {
		return affairModuleProducerId;
	}

	public void setAffairModuleProducerId(Integer affairModuleProducerId) {
		this.affairModuleProducerId = affairModuleProducerId;
	}
	
	

}
