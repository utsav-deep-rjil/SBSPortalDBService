package com.jcs.sbs.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import com.jcs.sbs.common.ExcelReader;
import com.jcs.sbs.common.ServiceUtil;
import com.jcs.sbs.dao.VolumeDao;
import com.jcs.sbs.dao.impl.VolumeDaoImpl;
import com.jcs.sbs.models.AccountType;
import com.jcs.sbs.result.AccountSummaryExtended;
import com.jcs.sbs.result.AccountSummaryResult;
import com.jcs.sbs.result.ResultCount;
import com.jcs.sbs.service.CommonService;

public class AccountServiceImpl implements CommonService {

    private VolumeDao volumeDao = new VolumeDaoImpl();

    public List getResult(String search, String sortBy, String sortDirection, int offset, int limit, String filter, List<String> optionalParams)
            throws HibernateException {

        List<AccountSummaryResult> queryResult = volumeDao.getAccountSummary("%" + search + "%", sortBy, sortDirection,
                offset, limit, filter);
        Map<String, AccountType> mappdedAccount = ExcelReader.getExcelAccountType();
        List<AccountSummaryExtended> extendedResult = new ArrayList<AccountSummaryExtended>();
        for (AccountSummaryResult accountSummary : queryResult) {
            AccountType accountType = mappdedAccount.get(
                    ServiceUtil.removeLeadingZeroes(
                            accountSummary.getProject_id()));
            if (accountType == null) {
                accountType = new AccountType();
                accountType.setBillingType("Internal");
            }
            AccountSummaryExtended extended = new AccountSummaryExtended(accountSummary, accountType.getBillingType());
            extendedResult.add(extended);
        }
        return extendedResult;

    }

    public ResultCount getTotalResultCount(String search, String filter, List<String> optionalParams) {

        return volumeDao.accountSummaryResultCount("%" + search + "%", filter);

    }

}
