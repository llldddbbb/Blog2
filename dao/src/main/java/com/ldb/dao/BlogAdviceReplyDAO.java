package com.ldb.dao;

import com.ldb.pojo.po.BlogAdviceReplyPO;
import com.ldb.pojo.vo.BlogAdviceReplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ldb on 2017/4/19.
 */
public interface BlogAdviceReplyDAO {

    List<BlogAdviceReplyVO> listBlogAdviceReplyVO(@Param("blogAdviceId")Integer blogAdviceId);

    int addBlogAdviceReply(BlogAdviceReplyPO blogAdviceReplyPO);

    int deleteBlogAdviceReply(@Param("blogAdviceId") Integer blogAdviceId);

}
