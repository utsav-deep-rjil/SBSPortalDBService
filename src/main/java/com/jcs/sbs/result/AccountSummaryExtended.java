package com.jcs.sbs.result;

public class AccountSummaryExtended extends AccountSummaryResult {
    private String accountType;

    public AccountSummaryExtended() {
        super();
    }

    public AccountSummaryExtended(AccountSummaryResult accountSummaryResult, String accountType) {
        super(accountSummaryResult);
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

}
