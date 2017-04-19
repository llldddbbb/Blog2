package com.ldb.service.utils;

import com.ldb.dao.CommentDAO;
import com.ldb.pojo.vo.BlogVO;

/**
 * Created by ldb on 2017/4/17.
 */
public class BlogUtil {

    public static void setBlogVO(BlogVO blogVO, CommentDAO commentDAO){
        blogVO.setCommentCount(commentDAO.getCommentCount(blogVO.getId()));
    }
}
