package com.ldb.dao;

import com.ldb.pojo.po.AdminPO;

/**
 * Created by ldb on 2017/4/20.
 */
public interface AdminDAO {

    AdminPO checkLogin(AdminPO adminPO);
}
