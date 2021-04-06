package com.chatboat.model;

public class AssociateResponseViewModel {
	
	AssociateResponseView associateResponseView;

	public AssociateResponseView getAssociateResponseView() {
		return associateResponseView;
	}

	public void setAssociateResponseView(AssociateResponseView associateResponseView) {
		this.associateResponseView = associateResponseView;
	}

	@Override
	public String toString() {
		return "AssociateResponseViewModel [associateResponseView=" + associateResponseView + "]";
	}
}
