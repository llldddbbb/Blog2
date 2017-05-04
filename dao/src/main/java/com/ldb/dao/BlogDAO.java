package com.ldb.dao;

import com.ldb.pojo.po.BlogPO;
import com.ldb.pojo.vo.BlogCommentVO;
import com.ldb.pojo.vo.BlogDateArchiveVO;
import com.ldb.pojo.vo.BlogVO;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface BlogDAO {

    List<BlogDateArchiveVO> listBlogDateArchiveVO();

    BlogVO getRecommendBlogVO();

    List<BlogVO> listNewBlog();

    List<BlogVO> listHotBlog();

    BlogPO getBlog(Integer id);

    int updateBlogReadNum(Integer id);

    List<BlogVO> listBlog(HashMap<String,Object> param);

    Long getBlogCount(HashMap<String,Object> param);

    List<BlogPO> listBlogPO(HashMap<String,Object> param);

    int addBlog(BlogPO blogPO);

    int updateBlog(BlogPO blogPO);

    int deleteBlog(Integer id);

    BlogCommentVO getBlogCommentVO(@Param("id") Integer id);

}
