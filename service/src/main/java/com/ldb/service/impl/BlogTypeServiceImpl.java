package com.ldb.service.impl;

import com.ldb.dao.BlogTypeDAO;
import com.ldb.pojo.po.BlogTypePO;
import com.ldb.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {

    @Autowired
    private BlogTypeDAO blogTypeDAO;

    @Override
    public List<BlogTypePO> listBlogType() {
        return blogTypeDAO.listBlogTypePO();
    }
}
