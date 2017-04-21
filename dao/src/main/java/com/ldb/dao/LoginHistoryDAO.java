package com.ldb.dao;

import com.ldb.pojo.po.LoginHistoryPO;

/**
 * Created by ldb on 2017/4/21.
 */
public interface LoginHistoryDAO {

    int addLoginHistory(LoginHistoryPO loginHistoryPO);

    LoginHistoryPO getLoginHistory();
}
