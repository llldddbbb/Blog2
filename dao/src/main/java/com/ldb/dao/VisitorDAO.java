package com.ldb.dao;

import com.ldb.pojo.po.VisitorPO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ldb on 2017/4/17.
 */
public interface VisitorDAO {

    int addVisitor(VisitorPO visitorPO);

    Long getReadNum();

    Long getTodayReadNum(@Param("today") String today);
}
