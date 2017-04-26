package com.ldb.dao;

import com.ldb.pojo.po.CommentPO;
import com.ldb.pojo.vo.CommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface CommentDAO {

    Long getCommentCount(@Param("blogId") Integer blogId);

    List<CommentVO> listNewCommentVO();

    List<CommentPO> listCommentPO(HashMap<String,Integer> param);

    int addComment(CommentPO commentPO);

    int deleteComment(HashMap<String ,Integer> param);


}
