package com.ldb.service;

import com.ldb.pojo.po.CommentPO;
import com.ldb.pojo.vo.CommentVO;

import java.util.List;

/**
 * Created by ldb on 2017/4/17.
 */
public interface CommentService {

    List<CommentVO> listNewComment();

    List<CommentPO> listComment(Integer blogId);

    int addComment(CommentPO commentPO);

    Long getCommentCount();
}
