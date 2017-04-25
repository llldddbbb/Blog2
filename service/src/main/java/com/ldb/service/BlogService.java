package com.ldb.service;

import com.ldb.pojo.po.BlogPO;
import com.ldb.pojo.vo.BlogDateArchiveVO;
import com.ldb.pojo.vo.BlogVO;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface BlogService {

    List<BlogDateArchiveVO> listBlogDateArchive();

    BlogVO getRecommendBlog();

    List<BlogVO> listNewBlog();

    List<BlogVO> listHotBlog();

    BlogPO getBlog(Integer id);

    int updateBlogReadNum(Integer id);

    List<BlogVO> listBlog(HashMap<String,Integer> param);

    Long getBlogCount(HashMap<String,Integer> param);

    List<BlogPO> listBlogPO(HashMap<String,Integer> param);

    int addBlog(BlogPO blogPO);

    int updateBlog(BlogPO blogPO);


}
