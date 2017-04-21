package com.ldb.service;

import com.ldb.pojo.po.VisitorPO;

/**
 * Created by ldb on 2017/4/17.
 */
public interface VisitorService {

    int addVisitor(VisitorPO visitorPO);

    Long getReadNum();

    Long getTodayReadNum();
}
