package com.ldb.service.impl;

import com.ldb.dao.AdminDAO;
import com.ldb.pojo.po.AdminPO;
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

    @Override
    public AdminPO checkLogin(AdminPO adminPO) {
        return adminDAO.checkLogin(adminPO);
    }
}
