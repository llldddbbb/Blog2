package com.ldb.service.impl;

import com.ldb.dao.VisitorDAO;
import com.ldb.pojo.po.VisitorPO;
import com.ldb.service.VisitorService;
import com.ldb.utils.DateUtil;
import com.ldb.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ldb on 2017/4/17.
 */
@Service("visitorService")
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorDAO visitorDAO;

    @Override
    public int addVisitor(VisitorPO visitorPO) {
        return visitorDAO.addVisitor(visitorPO);
    }

    @Override
    public Long getReadNum() {
        return visitorDAO.getReadNum();
    }

    @Override
    public Long getTodayReadNum() {
        String todayDateStr = DateUtil.getTodayDateStr();
        String today= StringUtil.formatLikeSQL(todayDateStr);
        return visitorDAO.getTodayReadNum(today);
    }
}
