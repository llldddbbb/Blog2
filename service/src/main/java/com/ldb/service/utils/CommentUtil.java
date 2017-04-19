package com.ldb.service.utils;

import com.ldb.dao.CommentReplyDAO;
import com.ldb.pojo.po.CommentPO;
import com.ldb.pojo.vo.CommentReplyVO;

import java.util.List;

/**
 * Created by ldb on 2017/4/19.
 */
public class CommentUtil {

    public static void setCommentList(List<CommentPO> commentPOList, CommentReplyDAO commentReplyDAO){
        for(CommentPO commentPO:commentPOList){
            List<CommentReplyVO> commentReplyVOList = commentReplyDAO.listCommentReply(commentPO.getId());
            commentPO.setCommentReplyVOList(commentReplyVOList);
        }
    }
}
