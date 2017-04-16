package com.ldb.service.impl;

import com.ldb.dao.BlogTagDAO;
import com.ldb.pojo.po.BlogTagPO;
import com.ldb.service.BlogTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
@Service("blogTagService")
public class BlogTagServiceImpl implements BlogTagService {

    @Autowired
    private BlogTagDAO blogTagDAO;

    @Override
    public List<BlogTagPO> listBlogTag() {
        return blogTagDAO.listBlogTag();
    }
}
