package com.ldb.service.impl;

import com.ldb.dao.LikeDAO;
import com.ldb.service.LikeService;
import com.ldb.utils.DateUtil;
import com.ldb.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ldb on 2017/4/17.
 */
@Service("likeService")
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeDAO likeDAO;

    @Override
    public Long getLikeCount(){
        return likeDAO.getLikeCount();
    }

    @Override
    public int addLike(String userIP) {
        return likeDAO.addLike(userIP);
    }

    @Override
    public Long getTodayLike() {
        String todayDateStr = DateUtil.getTodayDateStr();
        String today= StringUtil.formatLikeSQL(todayDateStr);
        return likeDAO.getTodayLike(today);
    }
}
