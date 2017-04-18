package com.ldb.service.impl;

import com.ldb.dao.CommentReplyDAO;
import com.ldb.pojo.po.CommentReplyPO;
import com.ldb.service.CommentReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ldb on 2017/4/18.
 */
@Service("commentReplyService")
public class CommentReplyServiceImpl implements CommentReplyService {

    @Autowired
    private CommentReplyDAO commentReplyDAO;

    @Override
    public int addCommentReply(CommentReplyPO commentReplyPO) {
        return commentReplyDAO.addCommentReply(commentReplyPO);
    }
}
