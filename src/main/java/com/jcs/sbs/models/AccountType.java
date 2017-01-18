package com.jcs.sbs.models;

public class AccountType {
	private String customerName;
	private String userName;
	private String accountId;
	private String billingType;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getBillingType() {
		return billingType;
	}
	public void setBillingType(String billingType) {
		this.billingType = billingType;
	}
	
	public AccountType() {
		super();
	}
	public AccountType(String customerName, String userName, String accountId, String billingType) {
		super();
		this.customerName = customerName;
		this.userName = userName;
		this.accountId = accountId;
		this.billingType = billingType;
	}
	@Override
	public String toString() {
		return "AccountType [customerName=" + customerName + ", userName=" + userName + ", accountId=" + accountId
				+ ", billingType=" + billingType + "]";
	}
	
	
	
}
