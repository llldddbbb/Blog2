package com.ldb.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by ldb on 2017/4/16.
 */
public interface CommentDAO {

    int getCommentCount(@Param("blogId") Integer blogId);
}
