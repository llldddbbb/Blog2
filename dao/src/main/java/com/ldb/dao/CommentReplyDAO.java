package com.ldb.dao;

import com.ldb.pojo.po.CommentReplyPO;
import com.ldb.pojo.vo.CommentReplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ldb on 2017/4/18.
 */
public interface CommentReplyDAO {

    List<CommentReplyVO> listCommentReply(@Param("commentId") Integer commentId);

    int addCommentReply(CommentReplyPO commentReplyPO);

    int deleteCommentReply(@Param("commentId")Integer commentId);
}
