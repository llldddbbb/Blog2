package com.ldb.service.impl;

import com.ldb.dao.LikeDAO;
import com.ldb.service.LikeService;
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
    public int getLikeCount(){
        return likeDAO.getLikeCount();
    }
}
