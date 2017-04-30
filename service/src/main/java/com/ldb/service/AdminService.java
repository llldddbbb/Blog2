package com.ldb.service;

import com.ldb.pojo.po.AdminPO;
import com.ldb.pojo.po.LoginHistoryPO;

/**
 * Created by ldb on 2017/4/20.
 */
public interface AdminService {

    AdminPO checkLogin(AdminPO adminPO);

    int addLoginHistory(LoginHistoryPO loginHistoryPO);

    LoginHistoryPO getLoginHistory();

    AdminPO getAdminPOByUserName(String userName);

    int updateAdmin(AdminPO adminPO);


}
