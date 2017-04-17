package com.ldb.dao;

import com.ldb.pojo.vo.BlogDateArchiveVO;
import com.ldb.pojo.vo.BlogVO;

import java.util.List;

/**
 * Created by ldb on 2017/4/16.
 */
public interface BlogDAO {

    List<BlogDateArchiveVO> listBlogDateArchiveVO();

    BlogVO getRecommendBlogVO();

    List<BlogVO> listNewBlog();

}
