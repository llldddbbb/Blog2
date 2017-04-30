package com.ldb.service.impl;

import com.ldb.dao.AdminDAO;
import com.ldb.dao.LoginHistoryDAO;
import com.ldb.pojo.po.AdminPO;
import com.ldb.pojo.po.LoginHistoryPO;
import com.ldb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ldb on 2017/4/20.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private LoginHistoryDAO loginHistoryDAO;

    @Override
    public AdminPO checkLogin(AdminPO adminPO) {
        return adminDAO.checkLogin(adminPO);
    }

    @Override
    public int addLoginHistory(LoginHistoryPO loginHistoryPO) {
        return loginHistoryDAO.addLoginHistory(loginHistoryPO);
    }

    @Override
    public LoginHistoryPO getLoginHistory() {
        return loginHistoryDAO.getLoginHistory();
    }

    @Override
    public AdminPO getAdminPOByUserName(String userName) {
        return adminDAO.getAdminPOByUserName(userName);
    }

    @Override
    public int updateAdmin(AdminPO adminPO) {
        return adminDAO.updateAdmin(adminPO);
    }

}
