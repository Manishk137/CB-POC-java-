package com.chatboat.model;

public class SearchFeeds {
	private String searchKey;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	@Override
	public String toString() {
		return "SearchFeeds [searchKey=" + searchKey + "]";
	}
}
