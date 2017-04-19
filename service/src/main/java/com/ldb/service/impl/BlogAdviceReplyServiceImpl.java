package com.ldb.service.impl;

import com.ldb.dao.BlogAdviceReplyDAO;
import com.ldb.pojo.po.BlogAdviceReplyPO;
import com.ldb.service.BlogAdviceReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ldb on 2017/4/19.
 */
@Service("blogAdviceReplyService")
public class BlogAdviceReplyServiceImpl implements BlogAdviceReplyService {

    @Autowired
    private BlogAdviceReplyDAO blogAdviceReplyDAO;

    @Override
    public int addBlogAdviceReply(BlogAdviceReplyPO blogAdviceReplyPO) {
        return blogAdviceReplyDAO.addBlogAdviceReply(blogAdviceReplyPO);
    }
}
