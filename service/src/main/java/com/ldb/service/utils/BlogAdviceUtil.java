package com.ldb.service.utils;

import com.ldb.dao.BlogAdviceReplyDAO;
import com.ldb.pojo.po.BlogAdvicePO;
import com.ldb.pojo.vo.BlogAdviceReplyVO;

import java.util.List;

/**
 * Created by ldb on 2017/4/19.
 */
public class BlogAdviceUtil {

    public static void setBlogAdvice(List<BlogAdvicePO> blogAdviceList, BlogAdviceReplyDAO blogAdviceReplyDAO){
        for(BlogAdvicePO blogAdvicePO:blogAdviceList){
            List<BlogAdviceReplyVO> blogAdviceReplyVOList = blogAdviceReplyDAO.listBlogAdviceReplyVO(blogAdvicePO.getId());
            blogAdvicePO.setBlogAdviceReplyVOList(blogAdviceReplyVOList);
        }

    }
}
