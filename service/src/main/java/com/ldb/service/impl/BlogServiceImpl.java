package com.ldb.service.impl;

import com.ldb.dao.BlogDAO;
import com.ldb.pojo.vo.BlogDateArchiveVO;
import com.ldb.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDAO blogDAO;

    @Override
    public List<BlogDateArchiveVO> listBlogDateArchive() {
        return blogDAO.listBlogDateArchiveVO();
    }
}
