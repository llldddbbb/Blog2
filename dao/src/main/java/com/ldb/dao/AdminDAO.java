package com.ldb.dao;

import com.ldb.pojo.po.AdminPO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ldb on 2017/4/20.
 */
public interface AdminDAO {

    AdminPO checkLogin(AdminPO adminPO);

    AdminPO getAdminPOByUserName(@Param("userName") String userName);

    int updateAdmin(AdminPO adminPO);
}
