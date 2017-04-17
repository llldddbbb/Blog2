package com.ldb.service.impl;

import com.ldb.dao.CommentDAO;
import com.ldb.pojo.vo.CommentVO;
import com.ldb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ldb on 2017/4/17.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public List<CommentVO> listNewComment() {
        return commentDAO.listNewCommentVO();
    }
}
